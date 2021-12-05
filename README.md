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

  <br>
  For the  above diagram, the description are as follows:
  **Command Separation :** When ever a user make POST,PUT, DELETE or PATCH request , the dispatcher servlet will route to the specific controller. Controller will call the AXON Command Gateway which will hold the data that need to be push to the event pipeline. Once the AXON Command Gateway send the data , Aggregation will get the data, validate the data and then publish it to the Event Sourceing pipeline (in our case it Axon Server). Once the Event are pushed , the Command Event handler which keeps listen to the Event Source pipeline will fetch the data repository layer will persist the data to the persistent storage.
  <br/>
  **Query Separation :**  When ever a user make GET request , the dispatcher servlet will route to the specific controller. Controller will call the AXON Query Gateway which will hold the data that need to be push to the event pipeline. Once the AXON Query Gateway send the data , Projection will send the reques then publish it to the Event Sourceing pipeline (in our case it Axon Server). Once the Event are pushed , the Query Event handler which keeps listen to the Event Source pipeline and once the request is received will read the data to the persistent storage.
