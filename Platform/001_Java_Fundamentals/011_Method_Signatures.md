<table width="100%">
    <tr>
        <td><a href="./010_Conditionals.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./012_Arrays.md">Next</a></td>
    </tr>
</table>

#

#   Methods
### __Objectives:__
*   Define method signatures
*   Overloading methods
#
Due to the object oriented nature of Java, you will only be dealing with methods, and never stand-alone functions. Though the term "function" may be used, it is always referring to a method.

### __Method declaration__
Methods are just functions that are attached to an object. Each method will have a code body and a method declaration, which includes the access level, return type, name, and parameter variables.

The code body will be the block of code that you want to be repeated whenever you invoke or call, your method.

You may want to return some value from your method after it is done processing: this is the return value and must either be a class, a primitive, or void.

The parameter variables are the possible inputs for your method. When calling it in the future, the arguments supplied must match the order and type in your method declaration.

For now, all of your methods should have the access level `public`.

### __Method Signatures__:
Every method has what we call a "signature". In your "FizzBuzz" assignment, you should have had the following method:
```java
    // ...
    public String fizzBuzz(int number) {
    // ...
```
This method has a signature of `fizzBuzz(int)`. Notice that the only information contained in the signature is the 1) name and 2) parameter type. If we implemented another method like this:
```java
    public void fooBar(int someNumber, String someString) {
```
Then it would have the signature `fooBar(int, String)`. This is the case for every single method, and this allows us to do something called overloading methods.

### __Overloading Methods__
Method overloading is when we call two methods the same name. For example, we might have the following two methods in the same class:
```java
    // ...
    public String fizzBuzz(int number) {
    // ...
    public String fizzBuzz(String number, int numberTwo) {
    // ...
```
Which code would be invoked when we call the `fizzBuzz` method? It depends on the argument type and the method signature! Due to Java's type system, if we try to call `fizzBuzz` with a string and int, it will know that we are trying to invoke the `fizzBuzz` method with the signature `fizzBuzz(String, int)`. This allows us to handle different cases of method invocation based on our inputs. You may not use this in the beginning of your Java journey, but knowing that Java allows this and identifies methods like this is extremely important.

### __Useful Links:__
*   [Methods](https://docs.oracle.com/javase/tutorial/java/javaOO/methods.html)

#

#   String Manipulation
You've been asked to implement a series of string manipulation methods. To do these, you will need to utilize built in string methods. Use the `StringManipulator` and `StringManipulatorTesting` classes. Below are the method signatures and a short description of the method to be implemented.

### __Objectives:__
*   Practice method signatures by implementing the tasks below.
*   Implement some of the most used string methods.

### __Tasks:__
Create a `StringManipulator` class that implements the following methods:

*   `String trimAndConcat(String, String )`: Trim both input strings and then concatenate them. Return the new string. Feel free to use the `trim` method of the `String` class.
```java
StringManipulator manipulator = new StringManipulator();
String str = manipulator.trimAndConcat("    Hello     ","     World    ");
System.out.println(str); // HelloWorld 
```
*   `Integer getIndexOrNull(String, char)`: Get the index of the character and return either the index or null. If the character appears multiple times, return the first index. Feel free to use the `indexOf` method of the `String` class.
```java
StringManipulator manipulator = new StringManipulator();
char letter = 'o';
Integer a = manipulator.getIndexOrNull("Coding", letter);
Integer b = manipulator.getIndexOrNull("Hello World", letter);
Integer c = manipulator.getIndexOrNull("Hi", letter);
System.out.println(a); // 1
System.out.println(b); // 4
System.out.println(c); // null
```
*   `Integer getIndexOrNull(String, String)`: Get the index of the start of the substring and return either the index or null. Feel free to use the `indexOf` method of the `String` class.
```java
StringManipulator manipulator = new StringManipulator();
String word = "Hello";
String subString = "llo";
String notSubString = "world";
Integer a = manipulator.getIndexOrNull(word, subString);
Integer b = manipulator.getIndexOrNull(word, notSubString);
System.out.println(a); // 2
System.out.println(b); // null
```
*   `String concatSubstring(String, int, int, String)`: Get a substring using a starting and ending index, and concatenate that with the second string input to our method. Feel free to use the `substring` method of the `String` class.
```java
StringManipulator manipulator = new StringManipulator();
String word = manipulator.concatSubstring("Hello", 1, 2, "world");
System.out.println(word); // eworld
```
Then create a `StringManipulatorTest` to test all these methods.

#

[]()
<table width="100%">
    <tr>
        <td><a href="./010_Conditionals.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./012_Arrays.md">Next</a></td>
    </tr>
</table>
