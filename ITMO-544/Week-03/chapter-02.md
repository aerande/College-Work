### **1. Why is design for operations so important?**

  * The main reason for designing of operations is to make sure that all the operational functions are working perfectly.

### **2. How is automated configuration typically supported?**

  * Configuration using automated way is typically supported for these three tasks:
    - Backing up a new configuration file, updating it regularly (typically configuration is dynamically updated as the system initiates), and restoring it.
    - Archiving a configuration is also an important task. Automated tasks can be used to spot the difference between an archived file and a revised file.
    - If a configuration file is in a running state, automated tasks can be used to archive the file at the current state.

### **3. List the important factors for redundancy through replication.**

  * Services should be designed to support redundancy in created replicas.
  * One of important factor is that if a service was not designed to work behind load balancer, then on the front-side, the system may work, but will develop problems in later phases, and which will be untraceble.
  * For a login process, if the client's credentials are stored locally by the web server, and not communicated to replicas, and the load balancer receives requests from the same client, the client will have to login again.

### **4. Give an example of a partially implemented process in your current environment. What would you do to fully implement it?**

  * The development environment which I worked on, had an partially implemented process of calculating insurance for a particular product, and not update the database and transfer the data.
  * To fully implement it, I would start building test cases for the whole process, and start working on those cases.

### **5. Why might you not want to solve an issue by coding the solution yourself?**

  * As an outsider coder for an organization, we are unaware of the coding standards of that organization, and our code may not be accepted. And as a result, any bugs will be critised badly.
  * Code submission from outside coders are easy way to solve issues. For example, at Google, there is a code approval process, when the code is approved by both the parties, then the code is accepted in the system.

### **6. Which type of problems should appear first on your priority list?**

  * Utmost problems to appear on the priority list is to select an item which has the biggest impact on the system even for a small change. But this process ends in wasting resources, satisfying process outcome, but will not solve operational problems.
  * Instead, we should focus on solving operational problems, and solve bigger bottlenecks that will have the biggest impact.

### **7. Which factors can you bring to an outside vendor to get the vendor to take your issue seriously?**

  * Vendors are very sensitive to appraisal of their products. No vendors would like their products criticised.
  * If we write a code that develops a framework around the vendor's software, then this could grab attention of the vendor and they can take the issue seriously.
