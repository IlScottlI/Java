<table width="100%">
    <tr>
        <td><a href="./012_Arrays.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./014_Maps.md">Next</a></td>
    </tr>
</table>

#

#   Loops
### __Objectives:__
*   For loops and while loops in java
#
Now that you know how to make some basic array structures, set values, and get values out of them, it would be good to know some more advanced manipulation of them. It would be a sad day for a programmer if they had a list of 100 items and they had to write code like this:
```java
System.out.println(myArray[0]);
System.out.println(myArray[1]);
System.out.println(myArray[2]);
System.out.println(myArray[3]);
System.out.println(myArray[4]);
System.out.println(myArray[5]);
// ...
System.out.println(myArray[99]);
```
Fortunately, computers are really good at doing some task over and over again. In programming languages, we can use loops to repeat blocks of code over and over as long as a certain condition holds true. There are two main types of loops: the while loop and the for loop. It is important to understand that these two loops are the same. Whatever we can do with the while loop we can do with a regular for loop and vice versa. However, there are different use cases for these two types of loops. We should use a while loop when we don't know beforehand how many times an operation must repeat, but we know we have to repeat until a certain condition has turned false. We can think of a for loop as a specialized while loop that we should use if we know exactly how many times we have to iterate.

There is also the enhanced for loop, which can't do everything that the other two can do, but does provide a nice convenience.

### __While loop__
It is important for us to understand the while loop before we understand the for loop because a for loop is just a specialized while loop. To create a while loop, we have to specify the condition we will check after each loop whether if it is true or not and the block of code to execute if the condition is true. If the condition specified never turns false, then the loop will go on forever leading to an infinite loop. Therefore it is important to make sure that we are modifying some aspect in the program that will eventually make the condition turn false. Let's take a simple look at a while loop that will print something to the screen as long as a particular variable is less than 7.
```java
int i = 0;
while(i < 7)
{
    System.out.println("foo");
    i++;
}
```
Java will first check if the variable `i` is less than 7. If it is, it will execute the block of code surrounded by curly braces. Then Java will check if the variable `i` is less than 7 again...and so on. Notice how we were modifying the `i` value inside of our while loop so that eventually our loop will stop. Now, this is not the best use for a while loop because we know before hand that we want this block of code to execute 7 times because if we increment `i` by 1 after each iteration, the loop will be iterated 7 times. This concept of repeating something for a specified interval is so common that the for loop was invented to handle specific cases like this.

### __For Loop__
In our previous example, we did a few things. First, we initialized a variable called i to hold onto starting number. Second, we determined the termination condition to check after each iteration. Third, we specified the body of the while loop with a code block to execute on each iteration. Fourth we made sure to modify the variable i in the code block. We can do this exact same thing with a for loop.

The most common `for` statement you'll see is comprised of 4 key parts: the initialization; the termination; the increment; and the body statements. Let's put a face to the name:
```java
for (int i = 0; i < 7; i++){
    System.out.println("bar");
}
```
```java
for (initialization; termination; increment){
    body statements
}
```
Here is what this code translates into:
```java
int i = 0;
while(i < 7)
{
    System.out.println("bar");
    i+
    +;
}
```
Using the for loop, we can easily iterate over an array, since we will always know its length; for example:
```java
ArrayList<String> dynamicArray = new ArrayList<String>();
dynamicArray.add("hello");
dynamicArray.add("world");
dynamicArray.add("etc");
for (int i = 0; i < dynamicArray.size(); i++){
    System.out.println(dynamicArray.get(i));
}
```
### __Enhanced For Loop__
There are also many times where you will find you need to assign the array element to a variable and manipulate it some way, but you don't care about the current index at all. Something like this:
```java
for(int i = 0; i < dynamicArray.size(); i++){
    String name = dynamicArray.get(i);
    System.out.println("hello " + name);
    // other operations using name
}
```
Rather than forcing an awkward declaration like this, the enhanced for loop was introduced in Java 5. Translating the above code to an enhanced for loop would look like this:
```java
for(String name : dynamicArray){
    System.out.println("hello " + name);
    // other operations using name
}
```
The parts can be referenced as seen below:
```java
for(element container : collection){
    // body statements
}
```
For the collection, just know that it will work with Arrays and ArrayLists for now, and as you progress you will see more and more uses for collection.

Those are the two most common loops you will see and use.

### __Useful links:__
*   [For Loops](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html)
*   [While Loops](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/while.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./012_Arrays.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./014_Maps.md">Next</a></td>
    </tr>
</table>
