#### Instructions to run Jekyll into the Load-Balancer

  * Create a installation file which specifies the installation process of apache2 server and jekyll into the instance. Here the file name is "install.sh".

  * Create a file "create-env.sh" which first launches 2 instances with parameters being passed from the command-line. The parameters to be passed are:
    - AMI ID
    - Count
    - Key pair name
    - Security group ID

  * Create a load-balancer with necessary parameters and attach the launched instances to this load-balancer.

  * To successfully run Jekyll into the cloud services, we have to make the load-balancer listen to the port 4000.

  * At the end of the running of this file, 2 instances will be running successfully and 1 load-balancer will be created.

  * To check the success, we will pick the DNS name from the load-balancer, which is:

  ![load-balancer-details](/images/aws-week-04-load-balancer.PNG)

  * Run this DNS name into the browser, which will show the apache2 success page:

  ![apache2-success](/images/aws-week-04-apache2-success.PNG)

  * As described above, Jekyll runs on port 4000. So to check whether it is installed successfully, we use the link <DNS name:4000> and lookup the screen as below:

  ![jekyll-success](/images/aws-week-04-jekyll.PNG)
