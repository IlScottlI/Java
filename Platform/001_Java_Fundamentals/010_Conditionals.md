<table width="100%">
    <tr>
        <td><a href="./009_Strings.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./011_Method_Signatures.md">Next</a></td>
    </tr>
</table>

#

#   Conditionals
### __Objectives__:
*   Learn control flow in java
#
We use conditionals in conjunction with operators to control the flow of the program. Imagine yourself being in traffic; you could use if and else statements to describe it. We use all sorts of control flow in o ur everyday life to determine what it is we are doing based on a certain condition:

    if(there is a construction going on) { 

        use detour

    } else {

        take the normal route

    }

#

How does this translate into something useful for Java developers? Well, consider this:

Someone visits your website, and you want to ask for their name, but only if it's their first time coming to your site. With an if statement, this is easy! Simply have a conditional statement to check, "Is this your first time visiting our website?". If the condition is true, then take them to the "Please input your name" page. If it's not their first time then let them view the website as normal because you have already asked for their name in the past.

Two things you need to remember when dealing with conditions in programming:

1.  A condition always returns true or false
2.  As long as something has a value (Which almost everything in Java does) it can be used in a condition
### __IF__
Let's say we are a basketball player. If a defender is guarding us closely, then we should pass. Our thought process can be represented this way in code.
```java
boolean defenderGuarding = true;
if(defenderGuarding == true) {
    System.out.println("Pass The Ball");
}
```
### __IF-ELSE__
We want to pass the ball if the defender is guarding us but what do we do if the defender isn't guarding us? If the condition is not true, we should write a block of code that will execute so that we will always have something to do whether the defender is guarding us or not.
```java
boolean defenderGuarding = true;
if(defenderGuarding == true) {
    System.out.println("Pass The Ball");
} else {
    System.out.println("Shoot The Ball");
}
```
### __IF-ELSE IF-ELSE__
We shouldn't always shoot the ball if the defender isn't guarding us. What if we are far away from the basket? In that case, instead of shooting the ball we should dribble the ball. In this case, we have three different blocks of code that we can take given a certain set of conditions. We can chain if-else if-else statements to cover all of the different scenarios. 
```java
boolean defenderGuarding = true;
boolean closeToBasket = true;
if(defenderGuarding == true) {
    System.out.println("Pass The Ball");
} else if(closeToBasket == true) {
    System.out.println("Shoot The Ball");
} else {
    System.out.println("Dribble The Ball");
}
```
__Note: Conditionals are not limited to just comparing booleans. You can compare other data types as well, including Strings and integers. But you have to make sure you are not comparing two completely different data types.__


# FizzBuzz
Write a program that will take an integer and print Fizz if the number is divisible by 3, Buzz if the number is divisible by 5, FizzBuzz if the number is divisible by 3 and 5, and the number itself for all other cases.

### __Objectives:__
*   Practice conditionals.
*   Implement a classic interview algorithm.

### __Tasks:__
*   [ ] Create a FizzBuzz class that implements the following logic:
```java
public class FizzBuzz {
    public String fizzBuzz(int number) {
        // fizzbuzz logic here
    }
}
```
Output for 3:
```
Fizz
```
Output for 5:
```
Buzz
```
Output for 15:
```
FizzBuzz
```
Output for 2:
```
2
```
*   [ ] Create a `FizzBuzzTest` class that you will use to check the outputs of the `fizzBuzz()` method.



#

[]()
<table width="100%">
    <tr>
        <td><a href="./009_Strings.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./011_Method_Signatures.md">Next</a></td>
    </tr>
</table>
