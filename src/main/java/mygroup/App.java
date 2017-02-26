package mygroup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        String fileName = args[0];
        File f=new File(".");
        System.out.println(f.getAbsolutePath());



        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach(line->{
                System.out.println(line);
                CitiesAnalyzer.analyze(line);
            });


            System.out.println(CitiesAnalyzer.pathDistance("ABC")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("ABC"));
            System.out.println(CitiesAnalyzer.pathDistance("AD")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("AD"));
            System.out.println(CitiesAnalyzer.pathDistance("ADC")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("ADC"));
            System.out.println(CitiesAnalyzer.pathDistance("AEBCD")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("AEBCD"));
            System.out.println(CitiesAnalyzer.pathDistance("AED")==null?"NO SUCH ROUTE":CitiesAnalyzer.pathDistance("AED"));
            System.out.println(CitiesAnalyzer.path("C",5,'C'));
            System.out.println(CitiesAnalyzer.pathExact("A",5,'C'));
            System.out.println(CitiesAnalyzer.pathShortest("A",'C'));
            System.out.println(CitiesAnalyzer.pathShortest("B",'B'));
            System.out.println(CitiesAnalyzer.pathWithBoundedDistance("C",30,'C'));



        } catch (IOException e) {
            e.printStackTrace();
        }





    }



}
