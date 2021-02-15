<table width="100%">
    <tr>
        <td><a href="./014_Maps.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./../002_Java_OOP/001_OOP.md">Next</a></td>
    </tr>
</table>

#

#   Exception Handling
### __Objectives:__
*   Try and catch blocks in java
#
Sometimes it is impossible to avoid errors. That is the nature of having to operate within a larger system. Since our applications will almost never be self-contained, we will eventually have to venture out of our code and make some risky calls. We might be making a call to a database, trying to read or write to a file, or even just using a class written by someone else - all of these are exceptional situations that could cause errors that would bring our program to a stop. However, most code you will interact with is kind enough to know when a risky operation is happening and will declare that it might throw an exception of a certain type.

It is a little like if you were to ask a friend if they could deliver a message for you, and they said, "sure, but my car might run out of gas - if it does, I'll call you and tell you." In that scenario, your friend delivering the message is the risky operation, the car running out of gas is the exceptional situation, and their calling you is the throwing of the exception - which is the message that they ran out of gas!

In this scenario, the letter might be important enough that it must be delivered. If the message must be delivered, then once your friend alerts you to the situation, you can figure out how to deal with the situation, rather than letting everything fall apart.

What about our program? How can we make sure that it continues to run?

### __Try/Catch__
In Java, we can utilize what is called the `try` statement. This will "try out" some risky code, and then catch any "exceptional" events that arise. Turning the analogy above into actual Java code, we get:
```java
class DeliverMessage{
    public static void main(String[] args){
        UnreliableFriend friend = new UnreliableFriend();
        try{
            friend.deliverMessage();
            System.out.println("The message was delivered!");
        } catch (OutOfGasException e){
            System.out.println("Hey, uh, so, I ran out of gas..");
            // back-up plan here.
        }
    }
}
```
This first creates a new `UnreliableFriend` for us, then tries to deliver a message. Since we know that `UnreliableFriends` might run out of gas, we come up with a back-up plan if that happens. So we `try` out delivering the message through our friend, and we `catch` any `exceptions` that the friend `throws`.

This is exactly how it would work, except it would be some sort of database connection, file writing or reading, or some other sort of call that could result in an error. Keep in mind that these are for __exceptional__ situations, and even though some language might encourage the use of `try`/`catch` blocks for control flow, Java is not one of them!

### __Example Code:__
If you would like to try the code from above for yourself and are wondering how it is done - here is some sample code (you shouldn't know this code yet); just place this above your class `DeliverMessage`. This code is not meant to reflect code you should be writing as this situation does not warrant throwing an exception - it is for educational purposes only.
```java
import java.util.Random;
class OutOfGasException extends Exception{}
class UnreliableFriend {
    public boolean deliverMessage() throws OutOfGasException{
        Random r = new Random();
        boolean hasGas = r.nextBoolean();
        if (hasGas){
            return true;
        }
        throw new OutOfGasException();
    }
}
```
### __Useful Links:__
*   [More on Exceptions](https://docs.oracle.com/javase/tutorial/essential/exceptions/index.html)
*   [Another Exception perspective](http://www.oracle.com/technetwork/java/effective-exceptions-092345.html)


# Lists of Exceptions
Your new PM knows you don't know Java too well. She wants you to familiarize yourself with generics and exceptions and figure out exactly how they work. First, she wants you to make an `ArrayList` with both numbers and strings in it.
```java
ArrayList<Object> myList = new ArrayList<Object>();
myList.add("13");
myList.add("hello world");
myList.add(48);
myList.add("Goodbye World");
```
You will loop through the list and try assigning each item to an int variable. To do this, you will also need to cast your list item as an Integer; you can do this like this:
```java
for(int i = 0; i < myList.size(); i++) {
    Integer castedValue = (Integer) myList.get(i);
}
```
After you have set up this code, try running it. It should throw a `ClassCastException`. Change the program above to utilize exception handling to print out the error messages, the index of the ArrayList where the error occurred, and the value of the object that triggered the error. The program should continue after printing this to the console.

### __Objectives__:
*   Implement exception handling.
### __Tasks:__
*   Create ArrayList
*   Try to cast each element to an `Integer`
*   Use try/catch blocks to handle the exceptions


#

[]()
<table width="100%">
    <tr>
        <td><a href="./014_Maps.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./../002_Java_OOP/001_OOP.md">Next</a></td>
    </tr>
</table>
