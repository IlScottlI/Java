<table width="100%">
    <tr>
        <td><a href="./004_Constructors.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./006_Project_Class.md">Next</a></td>
    </tr>
</table>

#

#   this Keyword
## __Objectives:__
*   this keyword
*   The Object superclass
#
In Java, the `this` keyword refers to the current object within the context of an instance method or constructor. The current object is the simple object whose method or constructor is being called. You can refer to any member variable of the current object by using this. For example:
```java
class Person {
    private int age;
    private String name;
    public Person(int ageParam, String nameParam) {
        this.age = ageParam;
        this.name = nameParam;
    }
}
```
It's the same as:
```java
class Person {
    private int age;
    private String name;
    public Person(int ageParam, String nameParam) {
        age = ageParam;
        name = nameParam;
    }
}
```
Both code samples do exactly the same thing. You can refer to this in any method of your class. There is one case in which you __MUST__ use `this`: if one of your parameter variables shares the same name as one of your member variables. For example:
```java
class Person {
    private int age;
    private String name;
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
        
        // this will not set the attribute value. 'age' is a local variable in the constructor method and its value is the very first argument.
        age = age 
    }
}
```
### __Constructor Overloading__
One of other uses of the `this` keyword is when you have overloaded your constructor, but don't want to have to write any repetitive code. Imagine that you have written out a constructor that takes an int, a string, and another int, but you also want there to be an empty constructor with default values. You could implement such a thing as shown:
```java
public class Person {
    private int age;
    private int cmHeight;
    private String name;
    public Person() {
        this(20, "John Doe", 171);
    }
    
    public Person(int age, String name, int cmHeight) {
        this.age = age;
        this.name = name;
        this.cmHeight = cmHeight;
    }
    // ...
```
In this case, it must be the first statement in your constructor, and it will call the other constructor for you.

### __Object Superclass__
Since this refers to your object and given that all objects are descendants of the `Object` class, this means we are able to use methods inherited from the `Object` class.

The `Object` class is considered a superclass because it is at the top of the class Hierarchy. It contains some methods that all of our objects can use, but to access them, you have to use the `this` keyword. Some of the most used methods from the `Object` class are:

*   `.getClass()`: returns a `Class` object that represents the object's current class.
*   `.equals()`: compares two objects for equality and returns a boolean.
*   `.toString()`: return a string representation of the object. If you want, you can override this method.
### __Person.java__
```java
class Person {
    private int age;
    private String name;
    public Person(int ageParam, String nameParam) {
        this.age = ageParam;
        this.name = nameParam;
    }
    public void objectMethods(Person anotherObject) {
        System.out.println("Class name: " + this.getClass().getSimpleName());
        System.out.println("toString: " + this.toString());
        System.out.println("Equals: " + this.equals(anotherObject));
    }
}
```
### __PersonTest.java__
```java
class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person(10, "Person1");
        Person person2 = new Person(5, "Person2");
        person1.objectMethods(person2);
    }
}
```
### __Output:__

    Class name: Person
    toString: Person@7852e922
    Equals: false
### __Useful Links:__
*   [this](https://docs.oracle.com/javase/tutorial/java/javaOO/thiskey.html)
*   [Object Class](https://docs.oracle.com/javase/tutorial/java/IandI/objectclass.html)
*   [Class Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./004_Constructors.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./006_Project_Class.md">Next</a></td>
    </tr>
</table>