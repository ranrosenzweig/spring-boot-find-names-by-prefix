# Spring boot find names by prefix
This is a SpringBoot application that provides list of names by given prefix string, based on a pre-loaded names.
## Prerequisites
- Java
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)
- [H2 Database](https://www.h2database.com/html/main.html)
- [Lombok](https://objectcomputing.com/resources/publications/sett/january-2010-reducing-boilerplate-code-with-project-lombok)

### API Endpoints
> **GET Mapping** http://localhost:8081/findByPrefix/{prefix}  - Get all names with given prefix

      Response Body - Example Value
        [
            {
                "name": "Bryan",
                "initial": "B"
            },
            {
                "name": "Bryce",
                "initial": "B"
            },
            {
                "name": "Bryson",
                "initial": "B"
            }
        ]
> **H2 console** http://localhost:8081/h2
>
![Alt text](images/H2%20Login.png?raw=true "H2 console login details")

#### Input validation:
The {prefix} must contain al least 2 chars and at most 10 chars
### Loading data into H2
In this exercise The requirement was to avoid the app to be aware about the file (provided /data/Manes.csv, therefore I choose to load it via H2 console<BR>

1. > DROP TABLE IF EXISTS ENTITY;
2. > CREATE TABLE ENTITY AS SELECT NAME, SUBSTRING(NAME,1,1) AS INITIAL FROM CSVREAD('C:\data\Names.csv');
3. > CREATE INDEX INDEX_INITIAL ON ENTITY (INITIAL);

Notes:
- Index has been added to the table in order to improve the performance while fetching the data from the table.
  run SET TRACE_LEVEL_SYSTEM_OUT 3; can validate if the query optimizer is using the index or not.
- Run the above after initial the app.

### TODO
- Access Control
- Swagger
- Add more tests
