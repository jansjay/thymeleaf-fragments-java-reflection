# Using thymeleaf fragments and java reflection

This repository will demonstrate how to use thymeleaf to create pages for entities by including common set of fragments. The fragments will support CRUD actions. The fragments uses java reflection to loop through the attributes.

This demonstration uses Spring Boot.


## Running the demo

### Running with Visual Studio code

Checkout the Repository to your local machine.
Open Visual Studio code and open the git repository folder.

The code will run using a H2 in memory DB. The changes will not be persistent. 

To change the db, modify ```src/main/resources/application.properties``` file with the values for your mysql installation.
Go to the menu Run and select "Start Debugging" or "Run without Debugging"

Open the browser and navigate to ```http://localhost:8080```

### Running with command line 

Bash ``` ./mvnw spring-boot:run ```
Windows Command Prompt ``` mvnw.cmd spring-boot:run ```

Open the browser and navigate to ```http://localhost:8080```