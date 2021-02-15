<table width="100%">
    <tr>
        <td><a href="./002_Objects_Classes.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./003_Member_Variables.md">Next</a></td>
    </tr>
</table>

#

# Methods
### __Objectives:__
*   Defining what a method is and implementing them
*   Defining syntax terms of a method
 
#
A `method` is just a function that belongs to a class. It is a sequence of statements that are grouped together to perform a certain task. A method can do things like print, get, set, or delete information, or anything else you can think of. We name methods after verbs, like 'getHeight' or 'setSpeed' or 'isValid'.

One of the most important concepts relating to OOP is that objects only share certain aspects about themselves publicly. The idea is that we can create objects with public methods that deal with how to interact with the object, but we keep all the details about the logic we are performing inside those functions private. This gives us a lot of control over what sort of information we broadcast, and it also allows us to write code that is more flexible and ready for change.

For a real-world analogy, let's think of an old-fashioned stereo. We would want anyone to be able to access the buttons and switches on the outside of the stereo, to turn it on or change the volume or what station we are listening to. However, we would not share information about the algorithm we use to translate the sound input into something the speakers produce. Sharing that information would not only make the object harder to use, but also prevent us from being able to update the internals to a newer and better version while keeping the interface the same.

In this same vein, think about our `Greeter` class. What needs to be public and what needs to be private? How could we design the `Greeter` class to only expose publicly the essentials? The `greet` methods should remain public, but what about what they actually do? We could first pull out the raw essentials and create a private method such as `createGreeting`:
```java
private String createGreeting(String toBeGreeted){
    return "Hello " + toBeGreeted;
}
```
This could then be used by both of our `greet` methods, as well as by any future greet method, such as one taking in a first name and a last name:
```java
public String greet(){
    return createGreeting("World");
}
public String greet(String firstName, String lastName){
    return createGreeting(firstName + " " + lastName)
}
```
This design would allow us to change how we greet (in this case, with the word "hello") very quickly, for example to "Greetings":
```java
private String createGreeting(String toBeGreeted){
    return "Greetings " + toBeGreeted;
}
```
In the next tab, we will look at how we can change this more easily, but first let's explore the parts of a method.

### __Defining Terms:__
Every method has the following parts: modifiers, return type, method name, and method body. Let's break down the new `createGreeting` method in more detail and look at each of its parts:

*   __modifiers:__ `private` is the access modifier that defines the access type of the method. The above method will only be visible to the object itself and cannot be called from other classes. There are also other modifiers, such as `static` which we will explore later. The access modifiers are:
    *   `private`: Only the class in which it is declared can see and access the method. This is the most restrictive access level.
    *   `protected`: Protected access gives subclasses a chance to use the method, while preventing a nonrelated class from trying to use it.
    *   `public`: Every class everywhere has access to the method.
*   __return type:__ `String` is a return type that is used to declare that a method returns a `String` type. Other return types are the data type of whatever your method returns, like `int`, `String`, `double`, `boolean`, or `void`. In Java, you must specify what data type your method will return; otherwise, it will result in an error.
*   __method name:__ createGreeting is the method name. The convention for choosing a name for your method depends on what return type the method has. If the method returns a boolean, the convention is to ask a question in the name; that way, the names are read like they would have a question mark at the end. Is the collection empty? Is the user logged in?  Does this element have items? We use lowerCamelCase for method names. For non-boolean methods we will use either verbs or get and set for property values, e.g.:getValue(); setValue(); greet(); addToList(); createGreeting();
    ```css
    isEmpty();
    isLoggedIn();
    hasItems();
    ```
*   __parameter list:__ - This is common to all programming languages. Whatever is enclosed in the opening and closing parenthesis are called parameters. In the `createGreeting` method, notice that we specifically declare a datatype again for our `toBeGreeted` variable. Declaring the datatype is required when there are parameters.
*   __method body:__ - The line `return "Greetings " + toBeGreeted`; in the `createGreeting` is part of the method body. The method body defines the instructions that are to be executed when the method is called. It is all the code between the curly braces, `{ }`.

*   __method type:__  `static` defines the method to be a __class method__ that is invoked without reference to an object.

*   __static modifier:__ This is the most common modifier you will see that is not an access modifier. This modifier defines the method as a class method, which means it can be invoked without reference to a particular object. Static methods can be called without creating an object. Have you wondered why we write the static keyword when defining main? It is because program execution begins from main and no object has been created yet. Class methods are useful for creating constants and class fields that need to be used throughout a program. One rule-of-thumb: ask yourself "does it make sense to call this method, even if an object has not been constructed yet?" If so, that method should be static. One good example is the Math class. You do not need to instantiate it; you just have to call its methods. For example:
    ```java
    public class MathTest {
        public static void main(String[] args) {
            System.out.println(Math.sin(25));
        }
    }
    ```
#

[]()
<table width="100%">
    <tr>
        <td><a href="./002_Objects_Classes.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./003_Member_Variables.md">Next</a></td>
    </tr>
</table>