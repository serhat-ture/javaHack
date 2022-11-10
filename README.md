## javaHack Blog App
Users can post about Java Programming and also make a comment to particular posts.\
User should define a unique title when posting.\
Each post may have multiple comments and can be changeable.\
Admin is authorized  all request.
serhat and ahmet are standard user that they can read posts and make comments, but have no authority to post. 

## Technologies

Java 8+, Spring Boot, Spring Security, JWT, PostgreSQL, Lombok, Spring Data JPA ( Hibernate), Tomcat, Postman, Intellij IDEA


## Project Structure

<ul>
<li>config</li>
   <li>controller</li>
  <li>dto</li>
  <li>entity</li>
  <li>exception</li>
  <li>mapper </li>
  <li>repository</li>
<li>security</li>
  <li>service</li>
  <li>serviceImp</li>
<li>util</li>
</ul>

## Authorization
| Username | Password |
|----------|----------|
| admin    | admin    |
| serhat   | password |
| ahmet    | ahmet    |

| Type  | Method |
|-------| ------ |
| POST | http://localhost:8080/api/auth/signin |

```
{  "usernameOrEmail": "admin", 
    "password": "admin"

 }

```

## Erd Diagram
<img width="483" alt="javaHack erd" src="https://user-images.githubusercontent.com/67038603/191129791-7acc6dc2-7bf9-413e-904d-3bf09c9161fe.png">


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

<img width="722" alt="comment" src="https://user-images.githubusercontent.com/67038603/191130011-bf78e6fc-729e-414c-ac63-9a05c5fe351e.png">
| Post Table

<img width="627" alt="post" src="https://user-images.githubusercontent.com/67038603/191130066-4404ce7b-e1e7-4006-b06e-0d8190fec2c3.png">