<table width="100%">
    <tr>
        <td><a href="./003_Member_Variables.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./005_this.md">Next</a></td>
    </tr>
</table>

#

# Constructors and Method Overloading
## __Objectives:__
*   Introduction to constructors
*   Overloading constructors
  #
A __constructor__ method is a special function that gets called when an instance of an object is created. The differences between a constructor method and the other methods are:

*   It doesn't have a __return type__.
*   The name of the constructor __MUST__ be the same as the name of the class to which it belongs.
*   A constructor is called automatically when a new instance of an object is created.

Constructor methods are used to execute some block of code on object instantiation. For example, what if we wanted to set the color of a vehicle to a default instead of calling the setter method after we created the object?

### __Vehicle.java__
```java
class Vehicle {
    private int numberOfWheels;
    private String color;
    public Vehicle(String color) {
        // setting the color attribute to the value from the color parameter
        this.color = color;
    }
    
    // ...
    // getters and setters removed for brevity
    // ...
}
```
### __VehicleTest.java__
```java
class VehicleTest {
    public static void main(String[] args) {
        Vehicle redVehicle = new Vehicle("red");
        String color = redVehicle.getColor();
        System.out.println("The Vehicle color is: " + color);
    }
}
```
### Output:

    The Vehicle color is: red
Notice that in our `VehicleTest` file, we had to pass the string "red" when we create the object. If we were to try to create an object without passing a string as an argument, the compiler would throw an error. To allow multiple ways to instantiate our objects, we must overload the constructor method.
```java
class Vehicle {
    private int numberOfWheels;
    private String color;
    
    // ex. new Vehicle()
    public Vehicle() {
    }
    // ex. new Vehicle("someColor")    
    public Vehicle(String color) {
        // setting the color attribute to the value from the color parameter
        this.color = color;
    }
    
    // ex. new Vehicle("someColor", 4)    
    public Vehicle(String color, int num) {
        this.color = color;
        this.numberOfWheels = num;
    }
        
    // ...
    // getters and setters removed for brevity
    // ...
}
```
Overloading a method is just defining new method signatures for the same method name. Now we can instantiate objects in 3 different ways. `new Vehicle()`, `new Vehicle('someColor')`, and `new Vehicle('someColor', 4)`. Remember that the method overloading technique is not only for constructors; any method can be overloaded.

A great use case for method overloading is to set default parameter values.

### __Useful link__
*   [Constructors Doc](https://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./003_Member_Variables.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./005_this.md">Next</a></td>
    </tr>
</table>