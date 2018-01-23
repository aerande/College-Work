Step by step execution:

1. Import the data from database by running the below command:
    sqoop import --connect jdbc:mysql://localhost/Logs_Database --table logs -m 1
    
2. Generate the codegen in the same folder same as the provided Java files by running the below command:
    sqoop codegen --connect jdbc:mysql://localhost/Logs_Database --table logs --class-name Log
    
3. To find frequently visited webpage per month, compile the two files "SqoopPerMonth" and "Log" at a time, after copying them into 1 folder and running the command:
    hadoop com.sun.tools.javac.Main *.java
    
4. Create a jar file by running this command:
    jar cf month.jar *.class
    
5. To find the answer, run this below command:
    hadoop jar month.jar SqoopPerMonth -libjars $SQOOP_HOME/sqoop-1.4.6.jar
    
6. To find frequently visited webpage per day, compile the two files "SqoopPerDay" and "Log" at a time, after copying them into 1 folder and running the command:
    hadoop com.sun.tools.javac.Main *.java
    
7. Create a jar file by running this command:
    jar cf day.jar *.class
    
8. To find the answer, run this below command:
    hadoop jar day.jar SqoopPerDay -libjars $SQOOP_HOME/sqoop-1.4.6.jar
