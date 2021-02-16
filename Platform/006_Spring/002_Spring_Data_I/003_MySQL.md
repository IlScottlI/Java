<table width="100%">
    <tr>
        <td><a href="./002_JPA.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./004_Domain_Model.md">Next</a></td>
    </tr>
</table>

#

#   MySQL

In this lesson, we will be going over how to set up your project to access your MySQL database. As mentioned, we will be using a MySQL data source. You should have already supplied the dependencies in a previous lesson.

### __Requirements__
You will need a MySQL server running to proceed. On OSX and Windows, this is commonly supplied via MAMP.

You will need to have familiarity with MySQL queries.

### __MySQL Server Set-up__
All that you need to do for MySQL is create the schema that you intend to use. For this lesson, we will create an example database called `book-schema`.

Note: Make sure your MySQL server is running.

### __Project Set-up__
To configure our application to connect to our data source, we need to add the following to our application.properties file:

### __application.properties__
<pre>
spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA>>
spring.datasource.username=<<dbuser>>
spring.datasource.password=<<dbpassword>>
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
</pre>
The first setting updates our schema with any changes we make to our domain model. There are other options you can explore, but it is an easy default to start with. Just remember that you need to have the schema created beforehand, and if you make mistakes in setting up, you may need to drop your schema.

That's it! You're connected now; if you try and start your project, it will throw an error if you don't have it set up correctly (provided you have the right dependencies).

### __*Notes__
Common error:

<pre>
java.sql.SQLException: The server time zone value 'PDT' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the serverTimezone configuration property) to use a more specifc time zone value if you want to utilize time zone support.
</pre>

Fix by appending timezone information on the end of your mysql url:
<pre>
spring.datasource.url=jdbc:mysql://localhost:3306/books?serverTimezone=UTC
</pre>
Depending on what version you are using you may see a deprecation warning:

<pre>
Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.</pre>

You may safely remove this setting

<pre>
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
</pre>

### __Useful Links:__
*   [MAMP](https://www.mamp.info/en/)
*   [SQLZoo](https://sqlzoo.net/)
*   [Hibernate Database Design Language Docs](https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#configurations-hbmddl)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./002_JPA.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./004_Domain_Model.md">Next</a></td>
    </tr>
</table>