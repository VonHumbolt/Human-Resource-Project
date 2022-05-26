 # Human Resource Project
 ### This is a Human Reource Project for Patika.dev Spring Backend Course.
 
## Brief Of Project
 This is a basic Human Resoruce project. It is written with Java Spring Framework. Also, PostgreSQL is used as a database.
 This project's architecture is N Layered Architecture. Project's authorization and security processes are written with Spring Security.
 For authorizaiton processes, JWT token is used. 
 
 ## Layers
 	Project's Layers
 	
 ### Models
 Project's entities and dtos are in this package. This entities also represent a table in database.
 
 ### Dao
 Data Access Layer of Project. All repositories in project are in this package. 
 For each entity there is an interface that extends the JpaRepository from Spring Data Jpa.  

 ### Services
 Business Layer of Project. Service interfaces and manager classes are in these folder.
 Business codes of project are written in this package.
 
 ## Controllers
This package has all rest controller classes which publish the project on internet as an api. 

## Security
Configuration classes which are necessary for Spring Security. Authentication and authorization processes are written in here.
And, JWT token is generated and verified in this package.