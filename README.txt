README:

ATMDemo is a small web app that uses Spring Boot:
- maven Project
- spring Boot version 2.2.12
- java 8
- packaging: Jar (Tomcat embedded)
- dependencies: Spring Web, Spring Data JPA, Spring Security,
                H2 Database (in memory DB), Thymeleaf (for web pages)

The app has 4 endpoints:

- "/loginPage" for the Spring security login
  At startUp the User table from the DB will be populated with following users (use them to login):
        * username= "Billy" , password/PIN= "1111" (in DB is encoded), amount= "20000"
        * username= "Bobby" , password/PIN= "2222" (in DB is encoded), amount= "15000"
        * username= "Johnny" , password/PIN= "3333" (in DB is encoded), amount= "10000"

- "/access-denied" I didn't use roles because the app was getting too complicated, but I used this page for testing purposes

- "/" This is the accountPage that shows the user account details after successful login

- "/h2-console" this is an client DB app for the H2 DB. I opened access (.antMatchers("/h2-console/**").hasAnyRole())
   for tests purposes, but normally this endpoint should be restricted.
   Authentication details: (needs login from Spring security)
        Driver Class: org.h2.Driver
        JDBC URL: jdbc:h2:mem:testdb
        User Name: sa
        Password: (no password)


As a Java 8 new feature I've used a functional interface (CommandlineRunner to populate the DB at startup).
I've created an integration test where I inserted an User in the DB and afterwards I read the new row from the DB.
and compared it to the object I've inserted.

I've added the compiled app (JAR) to GitHub in case you want to run it locally.

More details are present in the code's comments and in the Github commit messages
GitHub page: https://github.com/LiviuOrl/ATMDemo