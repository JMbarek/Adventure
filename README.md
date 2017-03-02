# Adventure
> Serialize/Deserialize from/to XML using Jackson &amp; DAO pattern &amp; Factory pattern ...


- Under "Adventure/target/classes" are all the .class files available ( *.class compiled classes by maven).
- to run the project :     
      - cd  Adventure
      - java  -cp  target/classes  Controller.Runner  input/map.xml  input/config1.txt  output/route.xml
- to run the unit tests(unit tests will be run by Maven): 
      - cd  Adventure
      - mvn test 
      
        - The output should be like in below:
        
 ```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestRunner
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.78 sec - in TestRunner

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

 ```
 
                           
