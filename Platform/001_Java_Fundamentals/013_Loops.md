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

# Basics
Now that you've familiarized yourself with Java a bit, you decided you really wanted to try and find an internship working with Java. After applying, you were sent the following code challenge:

### __Objectives:__
*   Implement the Basic 13 algorithms in java.
*   Practice `Array` and `ArrayList`.
*   Practice `loops`.

### __Tasks:__
Solve the below challenges. Use either an `Array` or `ArrayList` when an array is necessary, depending on what you think is appropriate. The class name should be `BasicJava`; you will need to create methods for each of the tasks below and test them in the `main` method.

### __Print 1-255__
Write a method that prints all the numbers from 1 to 255.

```java
public void print1_255() {
        for (int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }
```

### __Print odd numbers between 1-255__
Write a method that prints all the odd numbers from 1 to 255.

```java
public void print1_255_Odd() {
    for (int i = 1; i <= 255; i++){
        if(i % 2 != 0){
            System.out.println(i);
        } 
    }
}
```
### __Print Sum__
Write a method that prints the numbers from 0 to 255, but this time print the sum of the numbers that have been printed so far. For example, your output should be something like this:
```
New number: 0 Sum: 0
New number: 1 Sum: 1
New number: 2 Sum: 3
New number: 3 Sum: 6
...
New number: 255 Sum: ___
```
Do NOT use an array to do this exercise.
```java
public void printSum() {
    int sum = 0;
    for (int i = 0; i <= 255; i++){
        sum = sum + i;
        System.out.println("New number: " + i + " Sum: " + sum);
    }
}
```
### __Iterating through an array__
Given an array X, say [1,3,5,7,9,13], write a method that would iterate through each member of the array and print each value on the screen. Being able to loop through each member of the array is extremely important.

```java
public void iteratingArray(int [] arr) {
    for (int number : arr){
        System.out.println(number);
    }
}
```

### __Find Max__
Write a method (sets of instructions) that takes any array and prints the maximum value in the array. Your method should also work with a given array that has all negative numbers (e.g. [-3, -5, -7]), or even a mix of positive numbers, negative numbers and zero.

```java
public void findMax(int [] arr){
    IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
    System.out.println(stat.getMax());
}
```

### __Get Average__
Write a method that takes an array, and prints the AVERAGE of the values in the array. For example for an array [2, 10, 3], your method should print an average of 5. Again, make sure you come up with a simple base case and write instructions to solve that base case first, then test your instructions for other complicated cases.

```java
public void getAverage(int [] arr){
        IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        System.out.println(stat.getAverage());
    }
```


### __Array with Odd Numbers__
Write a method that creates an array 'y' that contains all the odd numbers between 1 to 255. When the method is done, 'y' should have the value of [1, 3, 5, 7, ... 255].

```java
public void print1_255_Odd_Array() {
    ArrayList<Object> y = new ArrayList<Object>();
    for (int i = 1; i <= 255; i++){
        if(i % 2 != 0){
            y.add(i);
        } 
    }
    System.out.println(y);
}
```

### __Greater Than Y__
Write a method that takes an array and returns the number of values in that array whose value is greater than a given value y. For example, if array = [1, 3, 5, 7] and y = 3, after your method is run it will print 2 (since there are two values in the array that are greater than 3).

```java
public void greaterThanY(int[] arr, int y) {
    int sum = 0;
    for (int i : arr) {
        if(i > y){
        sum ++;
        }
    }
    System.out.println(sum);
}
```

### __Square the values__
Given any array x, say [1, 5, 10, -2], write a method that multiplies each value in the array by itself. When the method is done, the array x should have values that have been squared, say [1, 25, 100, 4].

```java
public void squareValues(int[] arr){
    int [] newArr;
    newArr = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
        newArr[i] =  arr[i] * arr[i];
    }
    System.out.println(Arrays.toString(newArr));
}
```

### __Eliminate Negative Numbers__
Given any array x, say [1, 5, 10, -2], write a method that replaces any negative number with the value of 0. When the method is done, x should have no negative values, say [1, 5, 10, 0].

```java
public void eliminateNeg(int[] arr){
    for (int i = 0; i < arr.length; i++) {
        if( arr[i] < 0){
            arr[i] = 0;
        }
    }
    System.out.println(Arrays.toString(arr));
}
```

### __Max, Min, and Average__
Given any array x, say [1, 5, 10, -2], write a method that returns an array with the maximum number in the array, the minimum value in the array, and the average of the values in the array. The returned array should be three elements long and contain: `[MAXNUM, MINNUM, AVG]`

```java
public void minMaxAvg(Integer[] arr){
    int total = 0;
    for(int i=0; i<arr.length; i++){
        total = total + arr[i];
    }
    int min = Collections.min(Arrays.asList(arr));
    int max = Collections.max(Arrays.asList(arr));
    int avg = total / arr.length;
    int[] newArr = {max,min,avg};
    System.out.println(Arrays.toString(newArr));
}
```


### __Shifting the Values in the Array__
Given any array x, say [1, 5, 10, 7, -2], write a method that shifts each number by one to the front. For example, when the method is done, an x of [1, 5, 10, 7, -2] should become [5, 10, 7, -2, 0]. Notice that the last number is 0. The method does not need to wrap around the values shifted out of bounds.

```java
public void shiftArray(int[] arr){
    int[] newArr;
    newArr = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {  
        if(i < arr.length - 1 ) {
            newArr[i] = arr[i+1];
        }            
    } 
    System.out.println(Arrays.toString(newArr));
}
```

#   Puzzling
After you passed the first challenge, the company decided they wanted to give you a few puzzles to solve. As they put it: "The first challenge was just to check your familiarity with the language, now we want to see your problem-solving skills."

For this assignment, we are going to introduce two new classes: `Collections` and `Random`. We are going to use the former to shuffle and sort a collection, and the latter to get a random output. For example:

CodeExample.java
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class CodeExample {
    public static void main() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        
        Collections.shuffle(numbers);
        System.out.println(numbers); // [1, 5, 2, 4, 3]
        Collections.sort(numbers);
        System.out.println(numbers); // [1, 2, 3, 4, 5]
                
        Random r = new Random();
        System.out.println(r.nextInt()); // without bounds
        System.out.println(r.nextInt(5)); // with bounds 0 to 5
    }
}
```
### __Objectives:__
*   Implement different algorithms in java.

*   Practice `Array` and `ArrayList`.

*   Practice `loops`.

*   Learn and use the `Collections` and `Random` classes.

### __Tasks:__
Work on the puzzles below. Make your code as clean as possible. The class name should be `PuzzleJava`; you will need to create methods for each of the tasks below and test them in the `main` method.

*   Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)

    ```java
        public ArrayList printTenUp(int[] arr){
            ArrayList<Object> newArr = new ArrayList<Object>();
            int sum = 0;
            for (int item : arr) {
                sum = sum + item;
                if(item >= 10){
                    newArr.add(item);
                }
            }    
            System.out.println("Print Sum: "+sum);
            return newArr;
        }
    ```

*   Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
    ```java
    public String[] shuffleArray(String[] arr){
            ArrayList<Object> newArr = new ArrayList<Object>();

            Random r = new Random();

            for (int i = 0; i < arr.length; i++) {
                String item = arr[r.nextInt(arr.length)];
                System.out.println(item);
                if(item.length() > 5){
                    newArr.add(item);   
                }            
            }

            String [] returnArr = new String [newArr.size()];

            for (int i = 0; i < newArr.size(); i++) {
                returnArr[i] = newArr.get(i).toString(); 
            }
            return returnArr;
        }
    ```
*   Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.

    *   To shuffle a collection, you can use the `shuffle` method of the `Collections` class. [Collections Class documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Collections.html)
    ```java
    public String alphabetShuffle() {
        ArrayList<Object>  all26 = new ArrayList<Object>(); 
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        char c;
        int i = 0;
        for(c = 'A'; c <= 'Z'; ++c, i++ ){
            all26.add(c);          
        }
        
        Collections.shuffle(all26);
        char lastLetter = all26.get(25).toString().charAt(0);
        char firstLetter = all26.get(0).toString().charAt(0);
        System.out.println(firstLetter);
        System.out.println(lastLetter);

        String message =  "";
        for (char item : vowels) {
           if(firstLetter == item){
               message = "First Letter is a Vowel";
           }
        }
        return message;
    }
    ```
*   Generate and return an array with 10 random numbers between 55-100.

    *   To get a random integer, you can use the `nextInt` method of the `Random` class. [Random Class documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Random.html)
    ```java
    public int[] randomNumbers55_100(){
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100-55) + 55;
        }
        return arr;
    }
    ```
*   Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.

    *   To sort a collection, you can use the `sort` method of the `Collections` class.
    ```java
    public ArrayList<Integer>  randomNumbers55_100_sorted(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int item = r.nextInt(100-55) + 55;
            arr.add(item);
        }
        Collections.sort(arr);
        return arr;
    }
    ```
*   Create a random string that is 5 characters long.
    ```java
    public String getFiveString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
    
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
    
        return generatedString;

    }
    ```

*   Generate an array with 10 random strings that are each 5 characters long
    ```java
    public ArrayList<Object> getFiveStringArray(){
        ArrayList<Object>  arr = new ArrayList<Object>();

        for (int i = 0; i < 10; i++) {
            arr.add(this.getFiveString());            
        }
        return arr;
    }
    ```

#

[]()
<table width="100%">
    <tr>
        <td><a href="./012_Arrays.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./014_Maps.md">Next</a></td>
    </tr>
</table>
