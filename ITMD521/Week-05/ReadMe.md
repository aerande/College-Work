Steps to run the project:

1. Copy all the text files from local drive to hadoop directory as follows:
        hadoop fs -copyFromLocal ./1796-sotu.txt /user/$USER/data/
        hadoop fs -copyFromLocal ./1993-sotu.txt /user/$USER/data/
        hadoop fs -copyFromLocal ./1997-sotu.txt /user/$USER/data/
        hadoop fs -copyFromLocal ./2001-sotu.txt /user/$USER/data/
        hadoop fs -copyFromLocal ./2005-sotu.txt /user/$USER/data/
        hadoop fs -copyFromLocal ./2009-sotu.txt /user/$USER/data/
        hadoop fs -copyFromLocal ./2013-sotu.txt /user/$USER/data/
        
2. For point 1, compile and generate jar file (probably with name - wc.jar) for the file 'WordCount.java'.
   Then run the below hadoop command:
        hadoop jar wc.jar WordCount /user/$USER/data/ /user/$USER/output1
        
3. For point 3, compile and generate jar file (probably with name - wc.jar) for the file 'WordCount3.java'.
   Then run the below hadoop command:
        hadoop jar wc.jar WordCount3 /user/$USER/data/ /user/$USER/output2
        
4. For point 2, compile and generate jar file (probably with name - wc.jar) for the file 'WordCount2.java'.
   Then run the below hadoop command:
        hadoop jar wc.jar WordCount2 /user/$USER/data/ /user/$USER/output3
        
5. For point 4, continue with already generated jar file from (4.) and copy the provided pattern file 'pattern.txt' into the hadoop directory by running below command:
        hadoop fs -copyFromLocal ./pattern.txt /user/$USER/patternfile
        
   Then run the below command to get the output:
        hadoop jar wc.jar WordCount2 -Dwordcount.case.sensitive=false /user/$USER/data/ /user/$USER/output4 -skip             /user/$USER/patternfile/pattern.txt
