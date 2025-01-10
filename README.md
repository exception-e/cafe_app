# cafe_App&#176;

☕🍦🍨🍩🍰🧉🧁🍮🍵 🍷🍟🍕🥪🌮🥙🍚🍛🍜🍢🍣🍤🥤

Pet project (active development phase)  
build environment: JetBrains Intellij Idea

DB creation script - src/main/resources/db/initDB.sql.  
DB population script - src/main/resources/db/populateDB_hsql.sql.

## Application with REST API using Hibernate/SpringMVC/SpringSecurity/Postgres/Jackson/Maven/JUnit5 without frontend

__A voting system for deciding where to have lunch__


+ 2 types of users: admin and regular users 

+ Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)

+ Menu changes each day (admins do the updates)

+ Users can vote on which restaurant they want to have lunch at

+ Only one vote counted per user

+ If user votes again the same day:

    + If it is before 11:00 we assume that he changed his mind.  
    + If it is after 11:00 then it is too late, vote can't be changed

+ Each restaurant provides new menu each day.


Examples of available rest endpoints:

```
GET http://localhost:8080/cafeapp/rest/votes/today_winner
GET http://localhost:8080/cafeapp/rest/restaurants
GET http://localhost:8080/cafeapp/rest/admin/users

