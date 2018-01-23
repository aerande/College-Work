### **1. Describe the single-machine, three-tier, and four-tier web application architectures.**

  * Single machine web server - It is a type of system which consists of software that contains HTTP protocol, receiving requests, processing them, generating a result, and sending the response. This kind of web server has static content, dynamic content as well as database-driven dynamic content.
  ![single machine architecture](/images/single_machine_architecture.JPG)
  * Three-tier web service - Three-tier web service is an architecture that has total of three layers, mainly, load balancer layer, web server layer, and data service layer.
  ![3-tier architecture](/images/3-tier_architecture.JPG)
  * Four-tier web service - The four-tier web service serves individual applications having common frontend infrastructure. The request comes to load-balancer, which divides the traffic among different froentend applications.
  ![4-tier architecture](/images/4-tier_architecture.JPG)

### **2. Describe how a single-machine webserver, which uses a database to generate content, might evolve to a three-tier webserver.  How would this be done with minimal downtime?**

  * The single-machine webserver uses database driven manipulation of dynamic which is retrieved when a request hits the database, and generates a web page. Here, the database and the server are on the same side, so when the architecture reaches its threshold, the system can't perform according to it's requirements.
  * When such things happen, the business should evolve to three-tier architecture webserver where the server and the database are two different entities. Even if one entity reaches its threshold, it would not affect the other.
  * Here, all the traffic will be directed through load-balancer which will route the traffic equally through the servers and this requires minimal downtime with just an update to make it up and running.

### **3. Describe the common web service architectures, in order from smallest to largest.**

  * Single machine webserver architecture is the **smallest of all architectures** as it contains the webserver, static or dynamic content, and a database driving dynamic content. 

### **4. Describe how different local load balancer types work and what their pros and cons are. You may choose to make a comparison chart.**

  * DNS Round Robin:
    - This works by listing all the IP addresses of all replicas in the DNS link for the name of the webserver. In this method, the web browser receives all IP addresses, but randomly picks one to try first. This will lead to distribute the load evenly among the replicas.
    - Pros: This technique is easy to implement and it's free. There is no need of any extra hardware.
    - Cons: Difficult to control and is not very responsive. If one replica dies unexpectedly, the site will be down for the time DNS clears it cache.
  
  * Layer 3 and 4 Load Balancers:
    - TCP sessions packets first pass through the L3 & L4 load balancers, and then these load balancers redirect these sessions to one of the replicas. L3 works as IP layer and L4 works as TCP layer as per network protocols.
    - Pros: They are simple and fast. If one replica is down, then the traffic is routed other replicas.

  * Layer 7 Load Balancer:
    - L7 load balancers are similar that of L3 & L4, but L7 load balancers make decisions according to application layer protocol. They have the capability to examine what is inside an HTTP protocol, i.e., cookies, headers, URLs, etc.
    - Cons: When all the requests come from the same IP address, then debugging gets complicated and confusing.

### **5. What is “shared state” and how is it maintained between replicas?**

  * Web servers receive HTTP requests, but the information retrieved from this request is needed by the next HTTP request. In this case, the information is stored in the backend so that it can be accessed. But load balancers may store this information to different backend, and which cannot be found.
  * 

### **6. What are the services that a four-tier architecture provides in the first tier?**

  * 

### **7. What does a reverse proxy do? When is it needed?**

  * A reverse proxy enables one web server to provide content and use services from another web server openly. The user who uses a website, is actually made up of a patchwork of many applications.
  * On top of four-tiered web service, which provides a central platform to perform security and other services, reverse proxy is helpful as it is simpler and connects the web browsers and the pathwork of HTTP servers that sits behind it.

### **8. Suppose you wanted to build a simple image-sharing web site. How would you design it if the site was intended to serve people in one region of the world? How would you then expand it to work globally?**

  * 

### **9. What is a message bus architecture and how might one be used?**

  * 

### **10. What is an SOA?**

  * 

### **11. Why are SOAs loosely coupled?**

  * 

### **12. How would you design an email system as an SOA?**

  * 

### **13. Who was Christopher Alexander and what was his contribution to architecture?**

  * 