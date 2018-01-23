MapReduce

- It happens in two phases:
    1. Map Phase: Splitting, Sorting and Merging of data into many (Key,Value) pairs which are then sent to the Reduce phase.  
    2. Reduce Phase: This phase merges all Key,Value pairs into 1 final pair.
- The code is written in Java language and data is stored in HDFS.
- The Mapper is the first step to run. Anomaly is although Mapper class has not completed 100% execution, the Reducer phase starts executing when generally Mapper phase reaches 80%. This saves time because Reducer does not wait for Mapper to complete.
    
SQL

- In SQL, here using MySQL, we first insert data into the database table. The first step is to create a database, and then a table in that database.
- Unlike Hadoop offering parallel processing, SQL does not provide that, and so any operation in relational database like SQL takes time.

Sqoop

- The purpose of Sqoop is to load data from the relational database into the HDFS, and then run appropriate MapReduce job to get the result.
- Each column data of the database is stored in a text file in HDFS as a Comma Separated Value (CSV).

Hive

- Hive is an open source data system that sits on top of HDFS and it uses language known as HQL (Hive Query Language).
- The HQL structure is similar to of SQL, so one who is not aware of MapReduce job, can still work with Hive, with the help of Sqoop.


Personal choice

- I would like to work and understand more about Hive, as it requires no knowledge of MapReduce, and one can work with SQL queries, and Hive is best suitable for SQL Developers. 
