<table width="100%">
    <tr>
        <td><a href="./002_BankAccount.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./004_Abstract.md">Next</a></td>
    </tr>
</table>

#

#   Interface
## __Objectives:__
*   Introduction and implementation of interfaces
*   Understanding the use case of interfaces
#
Interfaces arise out of the need for several objects to be able to interact with something in the same way. You may think that this is what a class is for, but imagine that we have both a cat and a dog: they will be separate classes, but what if there is some functionality they share? What if they are both house pets? Then wouldn't they both need to be able to `giveOwnerAffection()` and `sleepInside()`? They would also each need to implement this code differently, as they will not be doing the same things. We cannot create new classes for both, and we should not create a class for both of them to inherit from just because they will share method signatures (not functionality).

In this instance, we will create an interface for each class to implement. This means that if the `HousePet` interface declares that there should be the methods `giveOwnerAffection()` and `sleepInside()`, then anything conforming to that interface will have those methods. This also means that if anything in the future wants to become a `HousePet`, we just implement it in that class to make sure that it conforms to the contract, declare it to implement `HousePet` and it will be used where any `HousePet` is usable.

To reiterate: an interface is not a class, and while writing an interface is similar to writing a class, they are two different concepts. A class describes the attributes and behaviors of an object. An interface states __behaviors__ that a class must implement.

In an interface, you can not specify a specific implementation (only its "interface"). More specifically, this means you can only specify methods, but __not__ implement them. Java 8 has added a few exceptions to this rule that we discuss below.

In its most common form, an interface is a group of related methods with empty bodies. A bicycle's behavior, if specified as an interface, might appear as follows:

### __OperateBicycle.java__
```java
public interface OperateBicycle {
    void speedUp(int increment);
    void applyBrakes(int decrement);
}
```
### __An interface is similar to a class in the following ways:__

*   An interface can contain any number of methods.
*   An interface is written in a file with a .java extension, with the name of the interface matching the name of the file.
*   The bytecode of an interface appears in a .class file.
*   Interfaces appear in packages, and their corresponding bytecode file must be in a directory structure that matches the package name.
### __However, an interface is different from a class in several ways, including:__

*   You cannot instantiate an interface.
*   An interface does not contain any constructors.
*   An interface cannot contain instance fields. The only fields that can appear in an interface must be declared both static and final.
*   An interface is not extended by a class; it is implemented by a class.
*   An interface can `extend` multiple interfaces; a class can only extend from one class, but it can implement multiple interfaces.
### __Interface Methods__
There are 3 types of interface methods: default, static and abstract.

1.  New in Java 8, `default` methods allow developers to create default methods that do not need implementation.
2.  `Static` methods are interface member methods. Also new to Java 8, they are implemented on the interface level and are called on the interface, not the class. Therefore, you cannot override static interface methods. You can only call them directly on the interface that they were declared.
3.  `Abstract` methods are methods that are declared without implementation. We saw an example of that in the OperateBicycle example above.

Default methods are declared with `default`, and static methods with the static keyword; abstract methods are implicit, and you do not include a method type. Below are all implicit declarations:

*   `Abstract` is the implicit method type; without declaration of either Static or default the method will be Abstract
*   `public` is the implicit access modifier.
An interface can contain constant declarations as well (i.e. static final class variables). All constant values defined in an interface are implicitly public, static, and final. Therefore, you are free to omit these modifiers.

### __OperateBicycle.java__
```java
public interface OperateBicycle {
    // constant that is public, static, and final
    double myConstant = 3.0;
    
    // default method that does not need implementation
    default void sayHello() {
        System.out.println("Hello everybody");
    }
    
    // static method that does not need implementation
    static void staticMethod() {
        System.out.println("Hello from the static method of the interface");
    }
    void speedUp(int increment);
    void applyBrakes(int decrement);
}
```
### __Implementing an Interface__
To implement any interface, we must use the keyword `implements` in our class definitions. However, there is one rule. A class that implements an interface must implement all methods that were defined in the interface definition besides `default` and `static`.

### __Bicycle.java__
```java
class Bicycle implements OperateBicycle {        
    private int speed;
    public Bicycle() {
        speed = 0;
    }
    // a static method that calls on the interface static method
    public static void staticMethod() {
        OperateBicycle.staticMethod();
    }
    // implementing speedUp
    public void speedUp(int increment) {
        speed += increment;
    }
    // implementing applyBrakes
    public void applyBrakes(int decrement) {
        speed -= decrement;
    }
    public int getSpeed() {
        return speed;
    }
}
```
### __BicycleTest.java__
```java
class BicycleTest {
    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        // print constant
        System.out.println(Bicycle.myConstant);
        b.sayHello();
        Bicycle.staticMethod();
        b.speedUp(3);
        b.applyBrakes(2);
        System.out.println(b.getSpeed());
    }
}
```
### __Output:__
```java
3.0
Hello everybody
Hello from the static method of the interface
1
```
### __Useful Links__
*   [Intefaces](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)
*   [Default & Static methods](https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html#static)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./002_BankAccount.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./004_Abstract.md">Next</a></td>
    </tr>
</table>