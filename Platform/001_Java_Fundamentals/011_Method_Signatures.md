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

[]()
<table width="100%">
    <tr>
        <td><a href="./010_Conditionals.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./012_Arrays.md">Next</a></td>
    </tr>
</table>
