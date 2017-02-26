package mygroup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Trains App
 *
 */
public class App 
{


    public static void main( String[] args )
    {

        String fileName = args[0];

        //read file into stream
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //Load graph in memory data structure
            stream.forEach(line->{
                CitiesAnalyzer.analyze(line);
            });


            System.out.println("Output #1: "+(CitiesAnalyzer.pathDistance("ABC")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("ABC")));
            System.out.println("Output #2: "+(CitiesAnalyzer.pathDistance("AD")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("AD")));
            System.out.println("Output #3: "+(CitiesAnalyzer.pathDistance("ADC")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("ADC")));
            System.out.println("Output #4: "+(CitiesAnalyzer.pathDistance("AEBCD")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("AEBCD")));
            System.out.println("Output #5: "+(CitiesAnalyzer.pathDistance("AED")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("AED")));
            System.out.println("Output #6: "+CitiesAnalyzer.path("C",5,'C').size());
            System.out.println("Output #7: "+CitiesAnalyzer.pathExact("A",5,'C').size());
            System.out.println("Output #8: "+CitiesAnalyzer.pathShortest("A",'C'));
            System.out.println("Output #9: "+CitiesAnalyzer.pathShortest("B",'B'));
            System.out.println("Output #10: "+CitiesAnalyzer.pathWithBoundedDistance("C",30,'C').size());



        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
