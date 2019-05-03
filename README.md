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
  
  **GraphiQL URL: http://localhost:8080/graphiq**
  
  ###  Schema

    type User  {  
      id: ID! 
      name : String!
      posts : [Post]  
    }
    
    type Post {
      id: ID! 
      text: String! 
      imageUrl : String
      user: User!
    }

    type Query {
      findAllUser: [User]!
      countUsers: Long!
      findUserFromPost(id: ID!) : User
      findUser(id: ID!) : User
      findAllPost: [Post]!
      countPost: Long!
      countPostOfUser(id: ID!) : Long
      findPost(id: ID!) : Post
      findAllPostOfUser(id: ID!) : [Post]  
    }

    type Mutation {
      newUser(name: String!) : User!
      deleteUser(id: ID!) : Boolean
      updateUserName(id: ID!, name: String!) : User!  
      newPost(text: String!, imageUrl: String!, userId: ID!) : Post!
      deletePost(id: ID!) : Boolean
      updatePostText(id: ID!, text: String!) : Post!
    }
  
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

