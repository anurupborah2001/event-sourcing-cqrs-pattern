# Event Sourcing using CQRS Pattern using Spring Boot and AXON Framework
  Microservice Architectural design patterns like Domain Driven Design and CQRS(Command Query Responsibility Separation) can be used with event sourcing techniques to built a separation of read and write models.
  In a CQRS context, one benefit of Event Sourcing is that the same events can be used to notify other components — in particular, to notify the read model. The read model uses the events to create a snapshot of the current state, which is more efficient for queries. However, Event Sourcing adds complexity to the design
  
 **Requirements:**
 1. Java 8 or higher
 2. Spring Boot
 3. [Axon Framework](https://axoniq.io/)
 
**NB :** For Axon Framework you can manually download the zip file and navigate to the AxonServer folder and run java -jar axonserver-<version>.jar
  
**CQRS Architecture Diagram:**
<br/>
![image](https://user-images.githubusercontent.com/861835/144732982-72f89818-0ff1-4ce6-a92b-ac01e0afc5b0.png)
  
<br />
For the  above diagram, the description are as follows:
<br/>
**Command Separation :** When ever a user make POST,PUT, DELETE or PATCH request , the dispatcher servlet will route to the specific controller. Controller will call the AXON Command Gateway which will hold the data that need to be push to the event pipeline. Once the AXON Command Gateway send the data , Aggregation will get the data, validate the data and then publish it to the Event Sourceing pipeline (in our case it Axon Server). Once the Event are pushed , the Command Event handler which keeps listen to the Event Source pipeline will fetch the data repository layer will persist the data to the persistent storage.
<br/>
**Query Separation :**  When ever a user make GET request , the dispatcher servlet will route to the specific controller. Controller will call the AXON Query Gateway which will hold the data that need to be push to the event pipeline. Once the AXON Query Gateway send the data , Projection will send the reques then publish it to the Event Sourceing pipeline (in our case it Axon Server). Once the Event are pushed , the Query Event handler which keeps listen to the Event Source pipeline and once the request is received will read the data from the persistent storage.
  
 ### Axon Dahsboard
  **Command :**
  ![image](https://user-images.githubusercontent.com/861835/144734579-21674b9c-404b-434a-b417-e569504a7286.png)
<br/>
   When inserting the record to database, the event stored in the AXON Server can be seen in the dashboard:
  ![image](https://user-images.githubusercontent.com/861835/144734620-44734434-54ee-4e07-914f-3b0fa5035dba.png)
  ![image](https://user-images.githubusercontent.com/861835/144734631-03b8394e-1e2f-4846-8c37-9d83833da9f6.png)
  <br/> 
  To see specific Identifier ID using Axon Dashboard:
  ![image](https://user-images.githubusercontent.com/861835/144734647-e050dd88-d26e-4649-8f22-81119eec71d0.png)

**Query :**
  <br/>
  Whenever a query request is made , it will be captured in the Axon Dashboard:
  ![image](https://user-images.githubusercontent.com/861835/144734710-b7625085-6a14-4c06-8db0-e6c1a03e2f43.png)


  
