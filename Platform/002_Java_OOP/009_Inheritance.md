<table width="100%">
    <tr>
        <td><a href="./008_getIDE.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./010_Packages.md">Next</a></td>
    </tr>
</table>

#

# Inheritance
## __Objectives:__
*   Inheritance in java
*   Overriding inherited methods
#
Inheritance is one of the most important features of object oriented programming. It prevents us from having to rewrite a significant amount of code, as well as to use classes written by other people without changing that class!

## __Superclass, subclass, and extending__
Let's say that you have a `Mammal` class that you've written out. It has and does everything that you want a mammal to do, but you also want to create another class `Human`. Now the problem with this is that you don't want to have to re-write every method and attribute you've written out for `Mammal`. You've painstakingly made sure that the `startSleep()` and `regulateTemperature()` methods were flawless. What do you do?

You tell the compiler that your Human class will be an extension of the Mammal class, and will, therefore, get everything that you wrote on the Mammal class for free. You would write something like this:
```java
public class Human extends Mammal{
    
}
```
In this case, `Human` would be a subclass of `Mammal`, and `Mammal` would be the superclass of `Human`. The `extends` keyword tell our compiler of the relationship, and now the `Human` class has inherited all the members from its superclass (except it won't have access to private member variables, unless they were exposed through getters and setters).

Let's see this in action!

### __Mammal.java__
```java
class Mammal{
    private boolean sleeping = false;
    public void regulateTemperature() {
        System.out.println("My temperature is just right now.");
    }
    public void startSleeping() {
        sleeping = true;
        System.out.println("ZzZz");
    }
    public boolean isSleeping(){
        return sleeping;
    }
}
```
### __Human.java__
```java
class Human extends Mammal {
    
    public void goToWork(){
        System.out.println("I'm going to work, something only humans can do.");
    }
}
```
### __HumanTest.java__
```java
class HumanTest {
    public static void main(String[] args) {
        Human h = new Human();
        h.regulateTemperature();
        h.startSleeping();
        h.goToWork();
        boolean sleeping = h.isSleeping();
        
        if (sleeping){
            System.out.println("The human is sleeping!");
        }
    }
}
```
### __Results:__
    My temperature is just right now.
    ZzZz
    I'm going to work, something only humans can do.
    The human is sleeping!
Already, you should see where this could be extremely useful: what if you needed to change how all mammals breathe? You wouldn't need to rewrite any code in the `Human` class; it would automatically extend the `Mammal` class for you!

What if you didn't want every method to be the same? Then you would be able to override the method from the superclass using the `override`.

### __Overriding Method__
You can change or extend the method of a superclass by just writing a method that has the same method signature and return type as the parent method. Then the new method will be called on the subclass whenever it is invoked. From our example above, we could overwrite the sleep method for example:

### __Human.java__
```java
class Human extends Mammal {
    // ...
    public void startSleeping() {
        System.out.println("Toss and turn");
    }
}
```
Now humans will only "toss and turn" when they try to start sleeping. What if we want to give them some rest and just extend our parent class? Then we can use the `super` keyword to invoke the superclass method in our own:

### __Human.java__
```java
class Human extends Mammal {
    // ...
    public void startSleeping() {
        System.out.println("Toss and turn");
        super.startSleeping();
    }
}
```
Ah, finally, our humans will get some sleep now.

### __Useful Links:__
* [Overriding and Hiding Methods](https://docs.oracle.com/javase/tutorial/java/IandI/override.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./008_getIDE.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./010_Packages.md">Next</a></td>
    </tr>
</table>