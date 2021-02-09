<table width="100%">
    <tr>
        <td><a href="./004_Hello_World.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./006_Variables.md">Next</a></td>
    </tr>
</table>

#

#   OOP Preview

## Objectives:
*   Review your first java program
*   Get familiarity with the java syntax

In this lesson, we will quickly introduce Object Oriented Programming (OOP) with Java. Since Java is an object oriented language, it is important that we understand enough about it to get started. We will go deeper in the OOP section. In the previous tab, we were able to run our first Java program by writing a simple piece of code:
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```
Here are a few things that you need to know:

1.  `HelloWorld` is a class. Java uses object-oriented programming for everything. In fact, it is not even possible to write a function that doesn't belong to a class. We'll dig in more with Java OOP right after dealing with data types and loops. It is important that your file name is __exactly the same__ as your class name.

2.  `main` is a method that defines the entry point for an exectuable Java file; it is required for any file that is intended to be run from the command line. A method is just a name for a function that belongs to a class; since everything in Java must belong to a class, all functions in Java are methods. Your methods will contain the functionality that you want your class to have.

3.  `System.out.println("")` is the bit of code that enabled us to output something to our command prompt or terminal. It is equivalent to Javascript's `console.log()` or Python's `print()`.

## Syntax
In writing Java code, it is important to keep in mind the following points:

*   __Case Sensitivity__: Java is case sensitive, which means __"Hello"__ and ***"hello"*** have a different meaning.
*   __Class Names__: Class names are written in PascalCase, also known as UpperCamelCase. Each word is capitalized, and there are no spaces between them.
    ```java
    class MyFirstJavaClass {}
    ```
*   __Method Names__: All method names should start with a lower case letter. If there are multiple words in the method, they should be written in lowerCamelCase. Typically, we use verbs as method names, rather than noun statements.
    ```java
    public void getValues() {}
    ```
*   __Program Filename__: The name of the program file should match the class name exactly. 

When saving the file, you should save it using the class name (remember, Java is case sensitive) and append `.java` as the filetype. If you have a class named `MyFirstJavaProgram`, then the file should be saved as `MyFirstJavaProgram.java`.

*   __Mandatory Method__: Java program processing starts from the __main()__ method which is a mandatory part of every executable Java program. It should look like this:
    ```java
    public static void main(String[] args){
        // your code
    }
    ```
__Hello World Syntax__
    ```java
    public class HelloWorld {
        public static void main(String[] args){
            System.out.println("Hello World");
        }
    }
    ```
*   Every application begins with a __class__ definition. A class can contain multiple methods (which should be enclosed between the class opening and closing curly brace tag).
*   The entry point (for an executable Java file) is the main() method so it is important that you have a __main() method__. The method signature for the main() method contains three modifiers:
    *  __public__: This is known as an access modifier. Any __public__ method we write is accessible from any other class or method in our project.
    *   __static__:  means that the method belongs to and is called from the class itself rather than from an instance of the class.
    *   __void__: indicates that the main() method doesn't return anything.
  
We will cover all these terms in more depth later, but this should give you a working understanding for now.
#

#   Your Own Java Program

In this assignment, you will create your own Java Program that will print your name, age, and hometown. Once you run your bytecode, you should see the following output:
```
My name is Coding Dojo
I am 100 years old
My hometown is Burbank, CA
```
Objectives:
*   Learn about the java program life cycle.

*   Start coding java right away.

Tasks:
* [ ] Create a new source file inside of your javaFun directory.

* [ ] In the main method, implement the code to print your name, age, and hometown in different lines.

* [ ] Compile your code without errors.

* [ ] Run your .class file.


#

<table width="100%">
    <tr>
        <td><a href="./004_Hello_World.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./006_Variables.md">Next</a></td>
    </tr>
</table>
