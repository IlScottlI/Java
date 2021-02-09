<table width="100%">
    <tr>
        <td><a href="./011_Method_Signatures.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./013_Loops.md">Next</a></td>
    </tr>
</table>

#

#   Arrays
### __Objectives:__
*   Arrays in java
*   Introduction to ArrayList
#
Now that you understand the primitive data types, what about more complex data structures? There have to be ways to contain more than just a single integer or string at a time. To do this we will use one of the simplest data structures: the __Array__.

### __Array__
Arrays in Java are a fixed-size sequential collection of elements of the same type with a zero-based index. In other words, zero-based index means that accessing and setting elements is done by an integer where 0 represents the first item, and so on.

To use an array, we first need to declare it, initialize and add elements or values to it. We can either do these separately or all at once.

Declaration, initialization, and adding in separate steps:
```java
int[] myArray;
myArray = new int[5];    // Initialization
myArray[0] = 4;
myArray[1] = 8;
myArray[2] = 8;
myArray[3] = 5;
myArray[4] = 9;
```
All at once:
```java
int[] myArray = {4, 8, 8, 5, 9};
```
In the last example, the length of the array is determined by the number of elements it has.

Note: In Java an array has a fixed size (after initialization), meaning that you cannot add or remove items from an array. In the example above, we declared that this array would contain five items. You cannot decrease or increase the number of elements in this array after initialization.

Note: What will the array default to if you do not explicitly set every value?

### __ArrayList__
There may be times where you will find that you need an array that is not fixed in size. In this case, the `util` module provides us with an `ArrayList`. There are some slight changes in how you interact with an `ArrayList`, but it is still a sequential zero-based index collection of elements. It is not, however, fixed in size. We can add as many items as we need to! To create and add items to an `ArrayList` you will need to do the following:
```java
import java.util.ArrayList;
ArrayList<Integer> myArray = new ArrayList<Integer>();
```
Let's unpack this a bit:

First, what is this `<Integer>` business? This is part of what we call generics, and what you need to know is that it tells our ArrayList of the acceptable types it can hold. If we did not include this (always include it!), then we could add anything to our ArrayList - strings, integers, and all manner of things. Generics helps to keep our compiler, and us, from making mistakes that would bite us during runtime. The only major thing you need to know about generics right now is that you should be using them.

As far as how to use the ArrayList, you can add and get elements in the following manner:
```java
myArray.add(10);
int num = myArray.get(0);
```
What if you would like to add elements that are of different types? Well, all `objects` are inherited from the `Object` class. Therefore, we can have our ***generic*** as an object and add different types of objects! For example:
```java
import java.util.ArrayList;
ArrayList<Object> list = new ArrayList<Object>();
list.add(10);
list.add("Hello");
list.add(new ArrayList<Integer>());
list.add(new Double(12.0)); // adding a Double of value 12.0
        
System.out.println(list); // [10, "Hello", [], 12.0]
```
Check out the [ArrayList documentation](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html). The most used methods are: `add`, `clear`, `clone`, `contains`, `get`, `indexOf`, `isEmpty`, `remove`, `size`. Try them out and see what you can do with the `ArrayList` class.

Note: The `<> `are informally referred to as the "diamond."

### __Useful Links:__
*   [Arrays](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
*   [ArrayList](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html)
*   [Initial variable values](https://docs.oracle.com/javase/specs/jls/se8/html/jls-4.html#jls-4.12.5)
*   [Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)
*   [Generic Notes](https://docs.oracle.com/javase/8/docs/technotes/guides/language/generics.html)
*   [What are Generics?](http://www.oracle.com/technetwork/articles/java/juneau-generics-2255374.html)


#

[]()
<table width="100%">
    <tr>
        <td><a href="./011_Method_Signatures.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./013_Loops.md">Next</a></td>
    </tr>
</table>
