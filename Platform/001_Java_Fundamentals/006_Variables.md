<table width="100%">
    <tr>
        <td><a href="./005_OOP_Preview.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./007_Type_Casting.md">Next</a></td>
    </tr>
</table>

#

#   Variables
##  Objectives:
*   Introduction to data types
*   Introduction to primitive versus object types
#
A variable is a piece of memory to which we can assign data to make it easy to reuse. We want to use variables as tools to make our code more understandable. That means that we want to give our variables good names that represent the data they hold, not single letters (with a couple exceptions, like i and j for loops and x and y for coordinates).

Every variable requires a type declaration when we initialize it. This is to help with speed and safety. Speed, because all variables of the same type require the same amount of memory, and by declaring the type at initialization, Java is able to allocate only the proper amount. It helps with safety, in that if we try to assign a value of the wrong type to a variable, we will receive an error even before we try to run the code. This lets us catch our mistakes before the program even runs, removing one big source of bugs.

The pattern for declaring a variable in Java is `type variableName;`.

To assign a value to a variable, use `variableName = value;`

___javaFun/Variables.java___
```java
public class Variables {
    public static void main(String[] args){
        int ourInt; // we can declare a variable without setting its value
        ourInt = 400; // we can assign a value to the variable later in our code
        double pi = 3.14159265; // we can also declare and assign on the same line
        boolean bool = true;
        char singleCharacter = 'A';
        
        String multipleCharacters = "ABC";
    }
}
```
## __Data Types__
### __Primitive Types__
Here are the most-used ___primitive___ types in Java:

*   __int__: An int holds integers, like 4 or -51. It is limited to numbers between -2147483648 and 2147483647, or around 2 billion.
*   __long__: These are for larger integers up to 2^63, or around 2 quintillion.
*   __boolean__: A boolean represents one of two values: true or false.
*   __double__:  Doubles are for floating point numbers like 3.14159265. We will use double rather than float almost exclusively, because they are far more precise.
*   __char__: The char data type is used to store a single character, like '$' or 'A'.
### __Object Types__
In addition to the primitive data types, the Java programming language also has object types. Some examples:

*   __Integer__: The `Integer` class wraps a value of the primitive type `int` into an object.
*   __Long__: The `Long` class wraps a value of the primitive type `long` in an object.
*   __Boolean__: The `Boolean` class wraps a value of the primitive type `boolean` in an object.
*   __Double__: The `Double` class wraps a value of the primitive type `double` in an object.
*   __Character__: The `Character` class wraps a value of the primitive type `char` in an object.
*   __String__: Represents a sequence of characters, like a Python string.
*   __BigInteger__: Represents an integer that can be any size at all.

Notice that primitive types are lowercase, while object types are capitalized.



#

<table width="100%">
    <tr>
        <td><a href="./005_OOP_Preview.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./007_Type_Casting.md">Next</a></td>
    </tr>
</table>
