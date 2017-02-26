# trains
Requirements: java-8, maven

To build project:
mvn clean install

To run project:
-Create a file in project folder and pass filename as argument (lines.txt)
-Put in the file a line containing input graph (AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7)
-Run the project:
mvn exec:java -Dexec.mainClass="mygroup.App" -Dexec.args="lines.txt"
