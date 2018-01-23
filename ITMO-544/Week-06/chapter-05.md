### **1. What is scaling?**

  * A system's ability to process a out-growing workload (measured in transactions/second), amount of data flowing, and excess number of users is called Scaling. These systems must be built to be scalable from the start because growth is expected and system's limit can be known to how far the system is scalable.

### **2. What are the options for scaling a service that is CPU bound?**

  * A system that runs on CPU power, a service can work better if that system can be moved to a machine with faster CPU, more cores in CPUs, bigger RAM, faster disk drives and faster network interfaces. This technique is called Scaling Up.

### **3. What are the options for scaling a service whose storage requirements are growing?**

  * Due to growing storage requirements, CDN (Content Delivery Networks) is the best suitable option for scaling a service.
  * Caching in CDN just don't copy all the content to all the caches. Instead, it is done into the datacentres specific to that location.

### **4. The data in Figure 1.10 is outdated because hardware tends to get less expensive every year. Update the chart for the current year. Which items changed the least? Which changed the most?**

|                          Action                          | Typical time (ns) (Old value) | Typical time (ns) (New value) |
|----------------------------------------------------------|-------------------------------|-------------------------------|
| L1 cache reference                                       | 0.5                           | 1                             |
| Branch mispredict                                        | 5                             | 3                             |
| L2 cache reference                                       | 7                             | 4                             |
| Mutex lock/unlock                                        | 100                           | 17                            |
| Main memory reference                                    | 100                           | 100                           |
| Compress 1K bytes with Zippy                             | 10,000                        | 2,000                         |
| Send 2K bytes over 1 Gbps network                        | 20,000                        | 125                           |
| Read 1 MB sequentially from memory                       | 250,000                       | 6,000                         |
| Round trip within same datacenter                        | 500,000                       | 500,000                       |
| Read 1 MB from SSD                                       | 1,000,000                     | 98,000                        |
| Disk seed                                                | 10,000,000                    | 3,000,000                     |
| Read 1 MB sequentially from network                      | 10,000,000                    | 10,000,000                    |
| Read 1 MB sequentially from disk                         | 30,000,000                    | 1,000,000                     |
| Send packet from California to Netherlands to California | 150,000,000                   | 150,000,000                   |

  * The item which changed least is L1 cache reference which is from 0.5 ns to 1.0 ns.
  * The itme which changed most is Read 1 MB sequentially from disk which is from 30,000,000 ns to 1,000,000 ns.
  * [Reference is taken from https://people.eecs.berkeley.edu/~rcs/research/interactive_latency.html]

### **5. Rewrite the data in Figure 1.10 in terms of proportion. If reading from main memory took 1 second, how long would the other operations take? For extra credit, draw your answer to resemble a calendar or the solar system.**

|                          Action                          | Proportion time (s) |
|----------------------------------------------------------|---------------------|
| L1 cache reference                                       | 0.005               |
| Branch mispredict                                        | 0.05                |
| L2 cache reference                                       | 0.07                |
| Mutex lock/unlock                                        | 1                   |
| Main memory reference                                    | 1                   |
| Compress 1K bytes with Zippy                             | 100                 |
| Send 2K bytes over 1 Gbps network                        | 200                 |
| Read 1 MB sequentially from memory                       | 2,500               |
| Round trip within same datacenter                        | 5,000               |
| Read 1 MB from SSD                                       | 10,000              |
| Disk seed                                                | 100,000             |
| Read 1 MB sequentially from network                      | 100,000             |
| Read 1 MB sequentially from disk                         | 300,000             |
| Send packet from California to Netherlands to California | 1,500,000           |

### **6. Take the data table in Figure 1.10 and add a column that identifies the cost of each item. Scale the costs to the same unit—for example, the cost of 1 terabyte of RAM, 1 terabyte of disk, and 1 terabyte of L1 cache. Add another column that shows the ratio of performance to cost. (Note – I know 1 terrabyte of ram doesn’t exist – you need to extrapolate.)**

  * 

### **7. What is the theoretical model that describes the different kinds of scaling techniques?**

  * The AKF Scaling Cube is a modern technique to achieve scaling to massive proportions. It works with three basic operations:
    - replicate the entire system (horizontal duplication)
    - split the system into individual functions, or resources (service splits)
    - split the system into individual chunks (formulaic splits)

### **8. How do you know when scaling is needed?**

  * Due to growing network traffic and number of users, the systems that handle these factors today won't be able to handle the same factors next year. So, in order to not lose customers, the business should scale up the services to handle more traffic, and keep scaling up from time to time. Thus, when the system is not performing well according to its capabilities, scaling is needed.

### **9. What are the most common scaling techniques and how do they work? When are they most appropriate to use?**

  * The most scaling techniques are described below:
    - Horizontal duplication: This technique duplicates the services so that overall throughput is obtained. This technique is most preferrable when there is more than usual network traffic that the server can handle.
    - Functional or Service Splits - In this technique, the system is scaled by splitting out each individual function and allocating additional resources to them. When the system requires resources of high performance and certain tasks are heavy to perform, this technique can be used by splitting off the transactions which can be processed by dedicated pool pf machines.
    - Lookup Oriented Splits - This technique scales a system by splitting the data into distinguishable segments, and each segment is allocated resources. This technique is only used when the x-axis and y-axis techniques won't work. The segments are made based on customer functionality, organizational divisions, etc.

### **10. Which scaling techniques also improve resiliency?**

  * The Horizontal duplication technique is best to improve resiliency, as this technique generates replicas of each services along with load balancers.

### **11. Describe how your environment uses a CDN or research how it could be used.**

  * CDN stands for Content Delivery Network. CDNs caches content on servers all over the world. When the user requests for content. then it is fulfilled from the nearest cache available from the user.
  * CDNs do not copy all the content into all the servers. Instead, it determines the usage trends and cache contents accordingly to that location. For example, if a user is in US, and is constantly requesting some images, then these images are copied to all the servers across US. 

### **12. Research Amdahl’s Law and explain how it relates to the AKF Scaling Cube.**

  * Amdahl's law is a formula which gives the theoretical speedup in terms of latency of the execution of a task at a fixed workload that can be expected of a system whose resources are improved. This formula is often helpful in parallel computing to predict the speedup when using multiple processors.
  * For example, if a program needs 20 hours to process using single processor core, and if a part of program which takes one hour to process and cannot be parallelized, then the remaining 19 hours of execution time can be parallelized, and the minimum execution time cannot be less than 1 hour.
  * Amdahl's law is similar to AKF cube as both of these laws work with parallel processing.
  * [Reference taken from https://en.wikipedia.org/wiki/Amdahl%27s_law]