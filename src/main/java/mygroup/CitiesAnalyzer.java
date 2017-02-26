package mygroup;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 25/02/17.
 */
public class CitiesAnalyzer {

    static Map<Character,List<Tuple>> map=new HashMap<Character, List<Tuple>>();
    static int totalDistance=0;

    public static void analyze(String routes){

        totalDistance=Arrays.stream(routes.split(", ")).mapToInt(route->Character.getNumericValue(route.charAt(2))).sum();

        map=Arrays.stream(routes.split(", "))
                .map(route->new Tuple(route.charAt(0),route.charAt(1),Character.getNumericValue(route.charAt(2))))
                .collect(Collectors.groupingBy(Tuple::getA));




    }

    public static Integer pathDistance(String path){
        if (path.length()==1) return 0;
        if (!map.containsKey(path.charAt(0))) return null;
        Tuple route=map.get(path.charAt(0)).stream().filter(t->t.b==path.charAt(1)).findAny().orElse(null);
        if (route==null) return null;
        else {
            Integer r=pathDistance(path.substring(1));
            return r!=null?route.c+r:null;
        }


    }

    public static List<String> path(String p,int length,char end){
//        if (path.length()>3) return null;
//        if (!map.containsKey('C')) return null;

          if(p.length()==length)
              return new ArrayList<>();
          if(p.charAt(p.length()-1)==end&&p.length()>1){
              List<String> result=new ArrayList();
              result.add(p);
              for(Tuple t:map.get(p.charAt(p.length()-1))) {
                  result.addAll(path(p + String.valueOf(t.b), length, end));
              }
              return result;
          } else {
              List<String> result=new ArrayList();
              for(Tuple t:map.get(p.charAt(p.length()-1))){

                  result.addAll(path(p+String.valueOf(t.b),length,end));
              }
              return result;

          }




    }

    public static List<String> pathExact(String p,int length,char end){
//        if (path.length()>3) return null;
//        if (!map.containsKey('C')) return null;

        if(p.length()>length)
            return new ArrayList<>();
        if(p.charAt(p.length()-1)==end&&p.length()==length){
            List<String> result=new ArrayList();
            result.add(p);
            return result;
        } else {
            List<String> result=new ArrayList();
            for(Tuple t:map.get(p.charAt(p.length()-1))){

                result.addAll(pathExact(p+String.valueOf(t.b),length,end));
            }
            return result;

        }




    }

    public static int pathShortest(String p,char end){
//        if (path.length()>3) return null;
//        if (!map.containsKey('C')) return null;
        int shortest=0;
        if(pathDistance(p)>totalDistance)
            return 20;
        if(p.charAt(p.length()-1)==end&&p.length()>1){

            return pathDistance(p);
        } else {
            List<String> result=new ArrayList();

            for(Tuple t:map.get(p.charAt(p.length()-1))){
                if(shortest==0)
                    shortest=pathShortest(p+String.valueOf(t.b),end);
                else
                    shortest=Math.min(shortest,pathShortest(p+String.valueOf(t.b),end));

            }
            return shortest;

        }




    }


    public static List<String> pathWithBoundedDistance(String p,int length,char end){
//        if (path.length()>3) return null;
//        if (!map.containsKey('C')) return null;

        if(pathDistance(p)>=length)
            return new ArrayList<>();
        if(p.charAt(p.length()-1)==end&&p.length()>1){
            List<String> result=new ArrayList();
            result.add(p);
            for(Tuple t:map.get(p.charAt(p.length()-1))) {
                result.addAll(pathWithBoundedDistance(p + String.valueOf(t.b), length, end));
            }
            return result;
        } else {
            List<String> result=new ArrayList();
            for(Tuple t:map.get(p.charAt(p.length()-1))){

                result.addAll(pathWithBoundedDistance(p+String.valueOf(t.b),length,end));
            }
            return result;

        }




    }



}
