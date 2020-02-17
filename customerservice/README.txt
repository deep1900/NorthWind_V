Project Instructions:

Before starting the project(Pre-requisite):
Step 1: download the database from https://github.com/jpenniman/java-ms-training/tree/master/databases
Step 2: Import the Database into mysql
Step 3: download rabbitMQ or use docker image of rabbitMQ.

After installing pre-requisite:
Step 1: Run the project as a Java Application
step 2: for the Customer module here is the list of endpoints
 1. http://localhost:8080/customer/test (To check the application working or not)
 2.  http://localhost:8080/customer/getAllCustomer(Get All Customer information without address)
 3.  http://localhost:8080/customer/addCustomer(add a customer)
 4. http://localhost:8080/customer/findById/{id}(find Customer by ID)
 5. http://localhost:8080/customer/deleteCustomer/{id}(delete a customer using id)
 6. http://localhost:8080/customer/getAllCustomer/getAddress/{id1}(Get a address of a customer by using id)
 7. http://localhost:8080/customer/updateCustomer(update a customer information)

step 3: Address endpoints
1.http://localhost:8080/address/test
2.http://localhost:8080/address/getAll
3.http://localhost:8080/addressupdateAddress
4.http://localhost:8080/address/getAddress/{id}

I have also implemented RabbitMQ for the testing purpose. you can see in the terminal that application is receiveing a hello world message from the rabbitMQ.


If you have any Questions regarding project please feel free to reach me out on pateldeep1219@gmail.com.