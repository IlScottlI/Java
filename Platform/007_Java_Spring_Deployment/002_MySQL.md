<table width="100%">
    <tr>
        <td><a href="./001_AWS_EC2.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./003_Apache.md">Next</a></td>
    </tr>
</table>

#

#   MySQL Installation
In this lesson, we are going to install MySQL
```
sudo apt update
sudo apt install mysql-server -y
sudo mysql
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
FLUSH PRIVILEGES;
exit;
```
__Important__: set the password to the one you want to use when connecting to your project.

To test that this is working try logging in to mysql using `mysql -u root -p`  and using "root" or whatever password you set to get in. Assuming this all worked we can create the schema that we'll be using for our project. Inside of you `application.properties` file you can locate the line that looks like...
```
spring.datasource.url=jdbc:mysql://localhost:3306/belt_exam_db?useSSL=false
```
the `belt_exam_db` part is what we want to create... 
```
CREATE SCHEMA belt_exam_db;
exit;
```
Assuming that all worked, we're now good to continue on with the rest of the deployment.

#

[]()
<table width="100%">
    <tr>
        <td><a href="./001_AWS_EC2.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./003_Apache.md">Next</a></td>
    </tr>
</table>