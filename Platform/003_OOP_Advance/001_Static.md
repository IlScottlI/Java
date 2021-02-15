<table width="100%">
    <tr>
        <td><a href="../002_Java_OOP/014_Object_Master_2.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./002_BankAccount.md">Next</a></td>
    </tr>
</table>

#

#   Static
##  __Objectives:__
*   Introduction and implementation of static variables
*   Introduction and implementation of static methods
#
In this lesson, we will learn about the 'static' keyword to create attributes and methods that belong to the class, instead of the instance of the class. Member variables are a way for all of our objects to have their own unique attributes. However, sometimes, you want variables that are shared across all objects. We achieve that by creating class variables. These variables are in one fixed location in memory, and all objects have access to it. It is also accessible without even creating any instances of the class. For example, suppose that we want to keep track of how many objects from the Person class we have created. We need to use a class variable to hold on to the current count of person objects created.

### __Person.java__
```JAVA
public class Person {
    private int age;
    private String name;
    public static int numberOfPeople = 0;
    public Person(int ageParam, String nameParam) {
        age = ageParam;
        name = nameParam;
        numberOfPeople++;
    }
}
```
### __PersonTest.java__
```java
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person(10, "Person1");
        Person person2 = new Person(5, "Person2");
        System.out.println(Person.numberOfPeople);
    }
}
```
Output:

    2
In the example above, the static variable `numberOfPeople` is incremented by one each time a Person object is created. So, when we call `Person.numberOfPeople`, we are getting the total count of objects.

## __Static Methods__
When we create static variables, it is common practice to create static methods to access the said variables. Let's refactor the example above with static methods.

### __Person.java__
```java
public class Person {
    private int age;
    private String name;
    // the variable is now private
    private static int numberOfPeople = 0;
    public Person(int ageParam, String nameParam) {
        age = ageParam;
        name = nameParam;
        numberOfPeople++;
    }
    
    public static int peopleCount() {
        return numberOfPeople;
    }
}
```
### __PersonTest.java__
```java
public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person(10, "Person1");
        Person person2 = new Person(5, "Person2");
        System.out.println(Person.peopleCount());
    }
}
```
    2
It is important to note that class methods cannot access instance variables or instance methods directly. In addition, class methods cannot use the `this` keyword as there is no instance for this to refer to.

### __Useful links__
*   [Static](https://docs.oracle.com/javase/tutorial/java/javaOO/classvars.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="../002_Java_OOP/014_Object_Master_2.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./002_BankAccount.md">Next</a></td>
    </tr>
</table>