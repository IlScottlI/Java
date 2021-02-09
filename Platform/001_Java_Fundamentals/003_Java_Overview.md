<table width="100%">
    <tr>
        <th><a href="./002_Set_Up.md">Back</a></th>
        <th><a href="../Index.md">Index</a></th>
        <th><a href="./004_Hello_World.md">Next</a></th>
    </tr>
</table>

#

# Java Fundamentals Overview

Welcome to the Java Fundamentals course. With the JDK installed, we can start writing some Java code... after we show you a quick message from James Gosling, the creator of the Java programming language.

### __James Gosling__

<iframe width="919" height="528" src="https://www.youtube.com/embed/m2c-Tji4h-k" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

While we often try to show our students why they should be excited about a particular language, Java does not require much effort on our part. If you search for 'top programming languages', Java will always be one of the top, if not, the top pick regarding usage in the industry (regardless of industry!). Java is also a great programming language to learn because of several of its features and paradigms which include:

*   Strong and Static Typing
*   Compiled language
*   Object Oriented
*   Widely Used
*   Ecosystem
*   Java's API
  
Learning these and understanding the Java language and its ecosystem will make you a far stronger developer than before, even if you choose not to program in Java!

### __Strong and Weak__
One way to group programming languages is by how they handle data types. Some, like Javascript, are weakly typed: that means that a variable's type can be changed to another type on the fly.

```javaScript
var x = [];
x = "hello";
x = 5;
x += "what?";
console.log(x);     // 1
```

1.  prints '5what?'

Note: In our code snippets we will use the comment code of that language to indicate we are not writing code. Some of the most common are: `#` for Python, `//` for Java and Javascript, and `<!-- -->` for HTML.

This is somewhat useful for Javascript, where the goal of a program is to always work for the user, but for programs where we want to catch errors early and fail fast, it is helpful to use a strongly typed language. This means that you cannot convert types on the fly, and something like the above would fail. Take Python, for example:
```java
our_int = 4
new_int = our_int + "hello"     # 1
print(new_int)                  # 2
```
1.  TypeError!!!
2.  We never get here

This would fail and prevent us from trying to add a string and integer together without an explicit code from us, which would prevent accidental mistakes from going unnoticed.

### __Dynamic and Static__
In addition to the strong-weak axis, we have two more important terms to deal with: static and dynamic. These refer to when we assign types to variables. Languages with static typing assign a type to declared variables at compile time and set aside the right amount of memory for that variable, while those with dynamic typing assign types only when the variable declaration code runs during execution and change the memory allocated for the variable as needed - this comes at the cost of program speed while it reorganizes things.

__Java__, C, and Swift are statically typed languages. Javascript, Python, and Ruby are dynamically typed.

The biggest change you will see in your code resulting from this is that when we declare variables and functions in Java, there will be type declarations before the variable name. Once a variable is tied to a type, it will only be that type for its whole life cycle.
```java
int ourInt;    // 1
String ourString = "hello world";    // 2
ourInt = "Hello world";    // 3
```
1.  We can declare variables without assigning a value because Java knows how much memory to allocate for that space
2.  We can assign the value of a variable as we declare them too!
3.  This will throw an error before we even run our code because the types do not match.

Whereas in a language like Javascript, which is dynamically typed we could do this:
```js
var ourInt;
ourInt = "hello";
```
This would not present any errors. If the new data type requires additional memory space, the variable would be reassigned to a new memory space and the data copied over.

With a statically typed language, whenever we try to assign the wrong type to a variable, we will receive an error message. Java is trying to help you write safe code that is free from errors (AKA bugs). When we start using an IDE, we will get instant feedback on these sorts of errors, and we will be in a much better position for debugging.

It is also beneficial when working with existing code bases to know exactly what data types a function needs to take in as its parameters, and this way of static typing helps us to see that without even needing to look into the body of the function!

This might be your first time encountering static typing. That's alright! It takes a little getting used to, but you'll be thankful for it before long.

### __Compiled Language__
Java is a compiled language; this means that it goes through analysis and optimization before it is run. The compiler can find repetitive code that you failed to optimize and do this for us, resulting in a faster program than we might otherwise have. The process of "compiling" your code will result in "bytecode" files that you can then execute using the JRE.

### __Object Oriented__
This paradigm changed the face of the development world, and is a must know for every single developer. As a fully object oriented programming language (OOP), it is a great language to see OOP shine.

Widely Used
Java is used across desktop, Web, Enterprise, and Mobile applications. It is used to write games, websites, enterprise applications, and just about anything you can think of.

Ecosystem
The Java ecosystem has libraries and tools for every task imaginable. It is almost guaranteed that if you are trying to do something with Java that one of the other 9,000,000 developers have tried to do it as well. There's a high chance that they either wrote about it, provided code for it, or sell a solution for it.

It also has a huge ecosystem of tools for you to use. It is so large that there is even more than one implementation of the JDK!

Java's API.
Java's API is another reason many people use Java - the standard library contains a host of useful methods that come with Java, before reaching out to the wider community.

#
<table width="100%">
<tr>
    <th><a href="./002_Set_Up.md">Back</a></th>
    <th><a href="../Index.md">Index</a></th>
    <th><a href="./004_Hello_World.md">Next</a></th>
</tr>
</table>