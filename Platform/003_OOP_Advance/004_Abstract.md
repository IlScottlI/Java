<table width="100%">
    <tr>
        <td><a href="./003_Interface.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./005_Pokemon.md">Next</a></td>
    </tr>
</table>

#

#   Abstract
### __Objectives:__
*   Introduction and implementation of abstract classes
*   Understanding the use case of abstract class
*   Abstract classes versus interfaces
#
Abstract classes are very similar to interfaces. They cannot be instantiated, and methods may or may not have the implementation. However, in abstract classes, fields are not static and final by default. Therefore, fields are not constants. Moreover, methods may have all three levels of visibility: public, protected and private. Unlike interfaces, where a class can implement multiple interfaces, a class can only extend one class, whether it is abstract or not.

### __Why Abstract?__
Think about some of the code you previously wrote. You wrote a `Mammal` class at one point, but only so that other classes could extend it. In a large system, you may find yourself designing other such classes that should not themselves be instantiated. These are exactly what abstract classes are for - to prevent the ambiguous "Mammal" thing, whatever that would be, from being instantiated in our code!

### __Defining an Abstract Class__
An abstract class is defined with the abstract keyword in the class definition. An abstract class may or may not contain abstract methods - methods without implementation. But if a class contains an abstract method, the class itself must be abstract.

### __AbstractClass.java__
```Java
public abstract class AbstractClass {
    public void randomMethod() {
        System.out.println("This is a random method that is implemented in this class");
    }
    // abstract method
    public abstract void abstractMethod();
}
```
### __SubClassOne.java__
```java
public class SubClassOne extends AbstractClass{
    // we must implement the abstract method otherwise we will get an error.
    public void abstractMethod() {
        System.out.println("This is our method from subclass one");
    }
}
```
### __SubClassTwo.java__
```java
public class SubClassTwo extends AbstractClass{
    // we must implement the abstract method otherwise we will get an error.
    public void abstractMethod() {
        System.out.println("This is our method from subclass two");
    }
}
```
### __Abstract class that implements an Interface__
When an interface is implemented, a regular class must implement all methods from the interface. However, if an abstract class implements an interface, it can implement some methods and leave it to the subclass to implement the rest of the methods.

### __InterfaceDemo.java__
```java
public interface InterfaceDemo {
    void methodOne();
    void methodTwo();
}
```

### __AbstractDemo.java__
```java
public abstract class AbstractDemo implements InterfaceDemo {
    public void methodOne() {
        System.out.println("Hello from the abstract demo");
    }
}
```
### __ClassDemo.java__
```java
public class ClassDemo extends AbstractDemo {
    public void methodTwo() {
        System.out.println("Hello from the class demo");
    }
}
```
### __AbstractTester.java__
```java
class AbstractTester {
    public static void main(String[] args) {
        ClassDemo c = new ClassDemo();
        c.methodOne();
        c.methodTwo();
    }
}
```
Output:

    Hello from the abstract demo
    Hello from the class demo
Abstract vs Interfaces
The Java documentation lists some points when to use abstract class versus interfaces. We will just list them below:

Consider using abstract classes if any of these statements apply to your situation:

*   You want to share code among several closely related classes.
*   You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
*   You want to declare non-static or non-final fields. This enables you to define methods that can access and modify the state of the object to which they belong.

Consider using interfaces if any of these statements apply to your situation:

*   You expect that unrelated classes would implement your interface. For example, the interfaces Comparable and Cloneable are implemented by many unrelated classes.
*   You want to specify the behavior of a particular data type, but aren't concerned about who implements its behavior.
*   You want to take advantage of multiple inheritances of type.
### __Useful Links__
*   [Abstract Classes](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./003_Interface.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./005_Pokemon.md">Next</a></td>
    </tr>
</table>