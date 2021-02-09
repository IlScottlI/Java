<table width="100%">
    <tr>
        <td><a href="./006_Variables.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./008_Importing.md">Next</a></td>
    </tr>
</table>

#

#  Type Casting
## __Objectives:__
*   Introduction to casting. How to change types in java
*   Learn when to use primitive types versus object types

As we know, Java is a statically typed language. Once you specify the type of a variable, it will always be that type. To allow programming flexibility, Java has type casting. Before we learn how to cast types, we must learn the ranges of values that our data types can hold.

Type    |	Size in Bytes   |	Range
-----|-----|-----
byte    |	1 byte  |	-128 to 127
short   |	2 bytes |	-32,768 to 32,767
int     |	4 bytes |	-2,147,483,648 to 2,147,483, 647
long    |	8 bytes	|   -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
float   |	4 bytes	|   approximately ±3.40282347E+38F
double	|   8 bytes	|   approximately ±1.79769313486231570E+308
char	|   2 bytes	|   0 to 65,536
boolean	|   n/a	    |   true of false

When type casting, it is the programmer's duty to be aware of the memory allocation for each type. You should be aware when casting down. Meaning, from a bigger range to a smaller range. This can often cause unexpected results.

### __Explicitly Casting__
Explicit casting is when we declare the type that we want to convert to in our source code. For example:

__javaFun/Casting.java__
```java
class Casting {
    public static void main(String[] args) {
        double d = 35.25;
        double dd = 35.99;
        
        // casting the double d into a int
        int i = (int) d;
        
        // casting the double dd into a int
        int ii = (int) dd;
        System.out.println(i);
        System.out.println(ii);
    }
}
```
Output:
```java
35
35
```
As you can see, we have explicitly cast our doubles into int types.

### __Implicit Casting__
Depending on the context, Java will implicitily cast types for us. For example:

__javaFun/Casting.java__
```java
class Casting {
    public static void main(String[] args) {
        int i = 35;
        float f = i;
        System.out.println("The number is: " + f);
    }
}
```
Output:
```java
The number is: 35.0
```
In this example, we have casted our int to a float. We have also casted our float into a string type so that we can concatenate into the string inside `System.out.println()`. Java will allow implicit conversions as long as the target type has a range large enough for the conversion.

### __Primitive vs Object types__
In the previous lesson, we briefly talked about `primitive` and `object` types. But when should we use one over another? Here are a couple of reasons for you:

1.  __Performance__: `Object` types are an instance of a class. They usually hold data and methods. Therefore, their memory capacity is much bigger than their `primitive` counterpart. Let's look an example:
__TestSum.java__
```java
public static void main(String[] args) {
    long start = System.currentTimeMillis();
    Integer sum = 0;
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
        sum += i;
    }
    System.out.println("Sum: " + sum);
    long end = System.currentTimeMillis();
    double total = (double) (end - start) / 1000;
    System.out.println("Time of execution: " + total + " seconds");
}
```
In our system, we get the following result (you will probably have a different 
result in your system):

    Sum: 1073741825 
    Time of execution: 6.477 seconds

Now, that's a lot of seconds just to get the sum of integers. Why is it taking so long? Well, we naively set the `sum` variable to `Integer` type. Therefore, in our for-loop, every time we add i to sum, we are actually creating an instance of `Integer` with the value of `i`. Totally unnecessary. All we have to do is declare sum to be an int from the beginning.

__TestSum.java__
```java
public static void main(String[] args) {
    long start = System.currentTimeMillis();
    int sum = 0;
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
        sum += i;
    }
    System.out.println("Sum: " + sum);
    long end = System.currentTimeMillis();
    double total = (double) (end - start) / 1000;
    System.out.println("Time of execution: " + total + " seconds");
}
```
Ahhhh. Much better. Now we get the following:

    Sum: 1073741825
    Time of execution: 0.763 seconds
`null` __values__: `Primitive` data types can only hold data. However, `Object` types are pointers to where the data is stored. This means that this pointer can point to nothing (`null`), while `primitive` types cannot.
__TestNull.java__
```java
public class TestNull {
    public static void main(String[] args) {
        Integer a = 10;
        int b = 10;
        a = null;
        b = null;
    }
}
```
If you try the code above, you will get the following compiling error: `incompatible types: <null> cannot be converted to int`



### __Useful Links__:
*   [Variables Doc](https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html)
*   [Type Conversion Doc](https://docs.oracle.com/javase/specs/jls/se8/html/jls-5.html) 


#


<table width="100%">
    <tr>
        <td><a href="./006_Variables.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./008_Importing.md">Next</a></td>
    </tr>
</table>
