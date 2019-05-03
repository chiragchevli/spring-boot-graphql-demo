<div align="center">
  
# spring-boot-graphql-demo
#### Simple GraphQL project with Query, Mutation and Subscription and GraphiQL in Spring boot 2

</div>

### Technologies
    
 * **Spring Boot 2.1.3**
 * **GraphQL**
 * **GraphiQL**
 * **H2 Database**

   
 ### Run Apllication
 
  ```
  $ gradlew :bootRun
  ```
  
  **You can Also Run This Application in java Based IDE like STS, Eclipse or intellij**
  
  **GraphiQL URL: http://localhost:8080/graphiq
  
  ###  Mutation Example (On GraphiQL)

    mutation updateUserName($id: ID!, $name: String!) {
      updateUserName(id: $id, name: $name)  {
         id
         name
        }
      }  

    QUERY VARIABLES

     {
      "id": 1,
      "name": "Chirag"
     }

###  Query Example (On GraphiQL)
    
    {
    findUserFromPost(id: 3) {
        id
        name
      }
    }
    
 ### References
 
  * https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot

  
**In case you find any problems or you have any suggestion or you want to add new features fell free to contact me** :smile:  

