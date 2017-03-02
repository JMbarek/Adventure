# Adventure
> Serialize/Deserialize from/to XML using Jackson &amp; DAO pattern &amp; Factory pattern ...


- Under "Adventure/target/classes" are all the .class files available ( *.class compiled classes by maven).
- to run the project :     
      - cd  Adventure
      - java  -cp  target/classes  Controller.Runner  input/map.xml  input/config1.txt  output/route.xml
- to run the unit tests: 
      - cd  Adventure
      - mvn test (unit tests will be by Maven run)
       and the output should be like in below:
        
 ```[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building adventure 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ adventure ---
[WARNING] File encoding has not been set, using platform encoding Cp1252, i.e. build is platform dependent!
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.6.0:compile (default-compile) @ adventure ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ adventure ---
[WARNING] Using platform encoding (Cp1252 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory C:\Users\jaouhar.mbarek\IdeaProjects\Adventure\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.6.0:testCompile (default-testCompile) @ adventure ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-surefire-plugin:2.19.1:test (default-test) @ adventure ---

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestRunner
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.78 sec - in TestRunner

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.630 s
[INFO] Finished at: 2017-03-02T16:04:05+01:00
[INFO] Final Memory: 11M/491M
[INFO] ------------------------------------------------------------------------

 ```
 
                           
