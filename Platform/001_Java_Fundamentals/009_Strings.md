<table width="100%">
    <tr>
        <td><a href="./008_Importing.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./010_Conditionals.md">Next</a></td>
    </tr>
</table>

#

#   Strings
### __Objectives:__
*   Learn the String class in Java
*   Practice the most popular string methods

#

__Strings__ represent a sequence of characters.

The most direct way to create a string is to write:
```java
String myVariableName = "My string's value";
```
Strings, like any other object, belong to a class. Instances of the String class are immutable, so once you create a String, it cannot be modified.

### __Methods of the String class__
Here are some commonly used methods of the String class:

*   __Length__ - Strings have a method to determine their length.
    ```java
    public class StringDemo {
        public static void main(String[] args) {
            String ninja = "Coding Dojo is Awesome!";
            int length = ninja.length();
            System.out.println( "String Length is : " + length );
        }
    }
    ```
    This will result in: `String Length is: 23`

*   __Concatenate__: A String method that allows two strings to be squashed together. Since each string is immutable, this results in a brand new string.
    ```java
    String string1 = "My name is ";
    String string2 = "Michael";
    String string3 = string1.concat(string2);
    System.out.println(string3);
    // will output My name is Michael
    ```
    The '+' sign is also overloaded to provide the same functionality:
    ```java
    "Welcome," + " ninja" + "!"; // displays "Welcome, ninja!"
    ```
*   __Format__: Another way of concatenating strings!
    ```java
    String ninja = String.format("Hi %s, you owe me $%.2f !", "Jack", 25.0);
    System.out.println(ninja);
    // Will print out Hi Jack, you owe me $25.00 !
    // Where %s is expecting a string
    // And %.2f is expecting a float data type. The value 2 will just place two values to right of the decimal point.
    ```
*   __IndexOf__: The `indexOf` method searches left-to-right inside the given string for a "target" string. The indexOf() method returns the index number where the target string is first found or -1 if the target is not found.
    ```java
    String ninja = "Welcome to Coding Dojo!";
    int a = ninja.indexOf("Coding"); // a is 11
    int b = ninja.indexOf("co"); // b is 3
    int c = ninja.indexOf("pizza"); // c is -1, "pizza" is not found
    ```
*   __Trim__: The `trim()` method removes any trailing or leading white spaces from the string.
    ```java
    String sentence = "   spaces everywhere!   ";
    System.out.println(sentence.trim())
    ```
    This will output: `spaces everywhere!`.

*   __Uppercase and Lowercase__: The String class provides methods to lowercase and uppercase strings.
    ```java
    String a = "HELLO";
    String b = "world";
    System.out.println(a.toLowerCase()); // hello
    System.out.println(b.toUpperCase()); // WORLD
    ```
*   __Equality__: We can compare the equality of a string in two ways. Do they refer to the exact same object, or do they have the same exact sequence of characters.
    ```java
    String a = new String("word");
    String b = new String("word");
    System.out.println(a == b); // false. not the same exact object.
    System.out.println(a.equals(b)); // true. same exact characters.
    ```




#

[]()
<table width="100%">
    <tr>
        <td><a href="./008_Importing.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./010_Conditionals.md">Next</a></td>
    </tr>
</table>
