<table width="100%">
    <tr>
        <td><a href="./002_Joins.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./004_Self_Join.md">Next</a></td>
    </tr>
</table>

#

#   Countries the JPA version
In this assignment, you will create the queries for MySQL Countries but using JPA. If you do not have the world database yet, download it here, [world](http://s3.amazonaws.com/General_V88/boomyeah/company_209/chapter_3569/handouts/chapter3569_5432_world.sql), and run it in workbench.

<img src="./../../000_img/Screen-Shot-2013-10-09-at-3.16.31-PM.png">

### __Topics:__
● Custom Queries

● Joins

● Relationships

● JPA

### __Tasks:__
1.  What query would you run to get all the countries that speak Slovene? Your query should return the name of the country, language, and language percentage. Your query should arrange the result by language percentage in descending order.

2.  What query would you run to display the total number of cities for each country? Your query should return the name of the country and the total number of cities. Your query should arrange the result by the number of cities in descending order.

3.  What query would you run to get all the cities in Mexico with a population of greater than 500,000? Your query should arrange the result by population in descending order.

4.  What query would you run to get all languages in each country with a percentage greater than 89%? Your query should arrange the result by percentage in descending order.

5.  What query would you run to get all the countries with Surface Area below 501 and Population greater than 100,000?

6.  What query would you run to get countries with only Constitutional Monarchy with a surface area of more than 200 and a life expectancy greater than 75 years?

7.  What query would you run to get all the cities of Argentina inside the Buenos Aires district and have the population greater than 500, 000? The query should return the Country Name, City Name, District, and Population.

8.  What query would you run to summarize the number of countries in each region? The query should display the name of the region and the number of countries. Also, the query should arrange the result by the number of countries in descending order.

### __Set Up__
First, create a brand new Spring Boot project named countries. In this project, you will have one controller with one handler method annotated with `@RequestMapping('/')`, and one service called the ApiService. This service will have all the repository dependencies that you need. It is your job to create the repositories and the domain models. For each query, all you need to change is the service method (which will fire the query) that the handler calls upon a get request for the root route. Below is a table for you to use as a reference.

MySql Type      |   	Java Type
  ---           |       ---
Char            |	    String
VARCHAR	        |       String
LONGVARCHAR	        |       String
NUMERIC	        |       java.math.BigDecimal
DECIMAL     |       	java.math.BigDecimal
BIT     |       	boolean
TINYBIT     |       	byte
SMALLINT	        |       short
INTEGER	        |       int
BIGINT	        |       long
REAL	        |       float
FLOAT	        |       double
DOUBLE	        |       double


#

[]()
<table width="100%">
    <tr>
        <td><a href="./002_Joins.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./004_Self_Join.md">Next</a></td>
    </tr>
</table>