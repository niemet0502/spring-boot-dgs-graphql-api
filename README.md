# Spring Boot DGS GraphQL API 
A simple spring boot GraphQL API built with the Netflix framework [DGS](https://netflix.github.io/dgs/). 

## Technical Stack 
- [Spring boot]() 
- [DGS]()
- [MySQL](): for the database

## Requirement
- A Running mysql db on your machine.
- [Maven](https://maven.apache.org/) installed. 
- Java JDK 17 installed. 

## Usage 

- Clone the repository
```
    git clone git@github.com:niemet0502/spring-boot-dgs-graphql-api.git
```
- Change directory
```
cd spring-boot-dgs-graphql-api
```
- Edit the db credentials in the `application.yaml` file. 
- Install dependencies 
```
    mvn clean install
```
- Run the project 
```
    mvn spring-boot:run
```

Then you can access the graphQL playground at http://localhost:7004/graphiql

## Built by

- Marius Vincent NIEMET [Twitter](https://twitter.com/mariusniemet05) [LinkedIn](https://www.linkedin.com/in/marius-vincent-niemet-928b48182/) 