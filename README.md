Online Advising Simulation using RPC & Message Queuing
---

Description
---
This project simulates an online advising system which we use to register for our classes. Students request clearance for a course from the advisor. At some other time, the advisor approves or disapproves the request and then the student is notified of the advisor’s decision. It requires 4 processes to simulate this: a student process, an advisor process, a notification process and a message queuing server (MQS). The student process, advisor process and notification process communicate through the message queuing server (message-oriented middleware). Communication from these processes to the message queuing server is through remote procedure calls. Please see figure 1:  
![figure1](https://user-images.githubusercontent.com/11136682/42258450-78918766-7f21-11e8-808d-1459045a430a.PNG)  
Note: Student, Advisor and Notification Process do not communicate directly. The dotted arrow in figure 1 implies the logical flow of messages. Also, “RPC” is interchangeable with “RMI,” depending on your selected programming language.   
  
Student Process:The Student process works on behalf of the student. It takes as input (from the command prompt) the name of the student and the course for which the student wants clearance. The Student process then sends a message through the MQS to the Advisor seeking clearance. It keeps on doing this (under control of the user) until it is killed.   
  
Advisor Process: When it is started, the Advisor Process contacts the MQS for any message from the Student process. If there are any messages, then it retrieves them and approve or disapprove the requests based on a random probability. It then sends a message for each request (message) through the MQS to the Notification process so that it (the Notification process) can notify the Student process about the decision. If there are no messages for the Advisor process in the MQS then it sleeps for 3 seconds and again contact back to check for messages. It keeps on doing this until is killed. It also prints a message for each request (message) that the Advisor process processes (whether it is approved or not).  
 
Notification Process: The Notification process notifies the Student process about the Advisor’s decision. To simulate this, it prints on the command prompt the student name, course and the advisor decision. The Notification process checks MQS for messages from the Advisor process. If there are any messages, then it retrieves them and notify the student by printing as stated above. If there are no messages, then it sleeps for 7 seconds and then contact the MQS again. It keeps doing this until is killed.  
  
Message Queuing Server (MQS):  
This process simulates the Message Queuing server. MQS has the following:  
1. It is able to store a message to any requesting process.
2. It has only one physical queue (Array list).
to store the messages from both Student and Advisor process.
3. Messages once retrieved are physically deleted from the queue.
4. Messages are persistent, i.e. even if you shut down the server the
messages are not lost. 
When the MQS is restarted it reloads all the messages from the file to the
main memory data structure.  


Assumptions
---
There should be 3  files test.txt, test1.txt and text3.txt to reduce the exception of creating a file.  Path: “C:/Apps/text.txt”
Beginning we need to give a command start rmiregistry in command prompt.

Running programs
---
First the server.java should be run. Then student, advisor and notification can be independently run as needed. But ideally should go to student process , advisor and notification at end.


Objective
---
1. Exposure to application development in distributed environment
2. Understanding two communication models for distributed processes  
a.) Remote Procedure Call / Remote Method Invocation (Synchronous
Communication)  
b.) Message Oriented Communication (Asynchronous persistent
Communication)
3. Understanding the message queuing systems

References
---
* https://docs.oracle.com/javase/tutorial/rmi/index.html  for client server connection.
* http://www.pk.org/rutgers/notes/pdf/03-rpc.pdf (Good Tutorial on Distributed
Technologies including RPC).
* https://users.cs.cf.ac.uk/Dave.Marshall/C/node33.html (RPC with C).
* https://docs.oracle.com/javase/tutorial/rmi/index.html (RMI with Java)
