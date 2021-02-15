<table width="100%">
    <tr>
        <td><a href="./001_OOP.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./003__Methods.md">Next</a></td>
    </tr>
</table>

#

#   Objects and Classes
## __Objectives:__
*   Understanding the relationship between classes and objects
#   
Object oriented programming, as you might guess, is all about objects.

An __Object__ is a collection of behaviors and properties that all revolve around the same concept; this collection of behaviors and properties are called instance members. Objects were originally used to model real-world objects or situations, but can and are used for all sorts of applications. They are reusable and are created from blueprints known as classes.

For example, if someone wanting to model the behavior of a solar system might create objects to represent the stars, planets, moons, and asteroids involved. Each object would be able to have fields, also known as attributes, to store data about the object as well as methods, which are the actions the object can perform. A planet might have fields such as mass, rotationSpeed, and currentPosition, as well as methods like `determineNewPosition()`.

Now, objects wouldn't be that useful if we had to create each one individually - that'd be a lot of repeating ourselves. So the designers of OOP languages built a way to create blueprints that can be used to create and customize lots of objects of a particular type. These blueprints are known in Java as Classes, and should be named with a noun (e.g. instead of a `HelloWorld` class, you might have it be a `Greeter` class).

You create a __Class__ in Java by starting with the keyword `class` and the name of the class followed by opening and closing curly braces `{ }`. The convention in Java is to name your classes using __PascalCase__: you capitalize the first letter of every word in the variable and do not use dashes or spaces to separate them.

In Java, you can have multiple classes in the same file, but only one class that is public. That public class needs to be named identically to the file's name, and should be named using a noun. Let's rename our `HelloWorld` and `HelloWorldTest` classes using the proper naming conventions. In this case, a more appropriate name might be `Greeter`:
### __Greeter.java__
```java
public class Greeter {
    // ...
}
```
### __GreeterTest.java__
```java
public class GreeterTest {
    // ...
}
```
Now that we've renamed them, we can create `Greeter` objects which are just run-time entities created from a class. The object is a particular instance of a class, and each object is unique.

Over the next few tabs, we will learn more about how to create and use objects from a class.

#

[]()
<table width="100%">
    <tr>
        <td><a href="./001_OOP.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./003__Methods.md">Next</a></td>
    </tr>
</table>