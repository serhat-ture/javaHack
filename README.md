#javaHack Blog App
Users can post about Java Programming and also make a comment to particular posts.\
User should define a unique title when posting.\
Each post may have multiple comments and can be changeable.

## Technologies

Java 8+, Spring Boot, PostgreSQL, Lombok, Spring Data JPA ( Hibernate), Tomcat, Postman, Intellij IDEA


## Project Structure

<ul>
   <li>controller</li>
  <li>dto</li>
  <li>entity</li>
  <li>exception</li>
  <li>mapper </li>
  <li>repository</li>
  <li>service</li>
  <li>serviceImp</li>
</ul>

## Erd Diagram

<img src="javaHack.erd" src="/Users/ahmetserhatture/Documents/javaHack/src/main/resources/static/javaHack.erd.png" width="500">


Some method and body examples:

| Type | Method |
|------| ------ |
| GET  | http://localhost:8080/api/posts/3/comments |

```
[
    {
        "id": 1,
        "name": "Serhat Ture",
        "email": "serhat@mail.com",
        "commentBody": "informative post"
    },
    {
        "id": 2,
        "name": "Can Kemal",
        "email": "can@mail.com",
        "commentBody": "nice !!"
    }
]

```

| Type | Method |
|------| ------ |
| GET  | http://localhost:8080/api/posts|

```
[
    {
        "id": 1,
        "title": "Arrays",
        "description": "Java Core",
        "content": "Data types"
    },
    {
        "id": 2,
        "title": "list",
        "description": "list-array",
        "content": "Data typess"
    },
    {
        "id": 3,
        "title": "integer",
        "description": "primitive data",
        "content": "java basic"
    }
]

```

| Type | Method |
|------| ------ |
| PUT  | http://localhost:8080/api/posts/3/comments/2 |

```
{
    
    "name": "Can Kemal",
    "email": "can@mail.com",     //we will change this
    "commentBody": "nice !!"
}

{
    "id": 2,
    "name": "Can Kemal",
    "email": "kemal@mail.com",   /changed
    "commentBody": "useful."
}

```
| Comment Table

<img src="comment" src="/Users/ahmetserhatture/Documents/javaHack/src/main/resources/static/comment.png" width="600">

| Post Table

<img src="post" src="/Users/ahmetserhatture/Documents/javaHack/src/main/resources/static/post.png" width="600">