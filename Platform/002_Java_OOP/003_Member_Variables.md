<table width="100%">
    <tr>
        <td><a href="./003__Methods.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./004_Constructors.md">Next</a></td>
    </tr>
</table>

#

# Member Variables
### __Objectives:__
*   Defining member variables (attributes)
*   Implementing getters and setters
#
In the previous lesson, we learned about methods. In short, methods are actions that objects can call - the behavior of objects. We can also define object attributes. For example, an attribute of a `Car` class would be `color`. In Java, attributes are referred to as __member variables__ or __fields__. There are three types of variables in Java, and it is important to differentiate the different types of variables that can be in a Java class:

*   Member variables - object attributes or fields.
*   Local variables - variables in method/code blocks that are not member variables (these are the primary type of variable you have been using so far)
*   Parameter variables - those that are declared in your method.

Note: You will see `member variables` called `attributes`, `instance variables`, `fields`, and possibly some other things, these all refer to the same thing.

### __Getters and Setters__
Member variables are typically declared inside the class before any method and are accessed via getter and setter methods. The variables themselves should almost always be declared as `private` to prevent access directly to the `field`. Getters are methods that retrieve a field value and setters are methods that set the field value. Let's build a `Vehicle` class with the `numberOfWheels` and `color` attributes.

Note: Remember that `field`, `attribute`, and `member variable` all refer to the same thing.
```java
Vehicle.java
class Vehicle {
    private int numberOfWheels;
    private String color;
    // getter
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    
    // setter
    public void setNumberOfWheels(int number) {
        numberOfWheels = number;
    }
    // getter
    public String getColor() {
        return color;
    }
    // setter
    public void setColor(String color) {
        this.color = color;        // 1
    }
}
```
1.  The `this` keyword is necessary here to specify that we are talking about the instance variable and not the parameter variable.
### __VehicleTest.java__

```java
class VehicleTest {
    public static void main(String[] args) {
        Vehicle bike = new Vehicle();
        Vehicle car = new Vehicle();
        bike.setNumberOfWheels(2);
        bike.setColor("red");
        int bikeWheels = bike.getNumberOfWheels();
        String bikeColor = bike.getColor();
        car.setNumberOfWheels(4);
        car.setColor("green");
        int carWheels = car.getNumberOfWheels();
        String carColor = car.getColor();
        System.out.println("Bike object - Wheels: " + bikeWheels + ", Color: " + bikeColor);
        System.out.println("Car object - Wheels: " + carWheels + ", Color: " + carColor);
    }
}
```
### __Output:__
```cs
Bike object - Wheels: 2, Color: red
Car object - Wheels: 4, Color: green
```
While it may seem repetitive to write getters and setters for every field, it is part of writing good, extensible, Java code that we explicitly declare access privileges for any member variable that we want to expose to the outside world.

### __Useful Links__
*   [Classes and Objects Docs](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

#

[](./004_Constructors.md)
<table width="100%">
    <tr>
        <td><a href="./003__Methods.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./004_Constructors.md">Next</a></td>
    </tr>
</table>