<table width="100%">
    <tr>
        <td><a href="./007_Annotations.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./009_Calculator_Part_1.md">Next</a></td>
    </tr>
</table>

#

#   POJOs and JavaBeans
##  __Objectives:__
*   Introduction to JavaBeans
*   Plain Old Java Objects versus JavaBeans
*   Defining a JavaBean
#
Believe it or not, you have been using what is called, in Java, POJOs; or "plain old Java objects." These POJOs are exactly what they sound like: just normal objects instantiated from a class; why the special name?

"We wondered why people were so against using regular objects in their systems and concluded that it was because simple objects lacked a fancy name. So we gave them one, and it's caught on very nicely." - Martin Fowler

That does not need much explanation, though you should know what the name represents. This is, by the way, in opposition to "Entity Beans" which are Java EE components (specifically Enterprise Java Beans) that persist data in a datastore (database); we will not be exploring the EE ecosystem in depth, and will not be using any "Enterprise Java Beans."

On the other hand, you do need to be familiar with Java Beans. JavaBeans are POJOs that conform to a series of rules:

*   Member variables must be private, but accessible using `get` and `set`
*   Must have a zero argument constructor
*   Must implement the serializable interface

As you should already be using private properties with `getPropertyName` and `setPropertyName`, you should just need to implement a zero argument constructor and implement the serializable interface.

That means that the following code:
```java
class Human {
    private String name;
    
    public Human(String name){
        this.name = name;
    }
    
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
}
```
Would need to become:
```java
class Human implements java.io.Serializable {
    private String name;
    public Human(){
    }
    public Human(String name){
        this.name = name;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
}
```
That's all you need to do. Of course, if it's invalid to have a Human without a name, you would want to provide a default in the "no arg" constructor, but other than that, there would not be any necessary changes.

#

[]()
<table width="100%">
    <tr>
        <td><a href="./007_Annotations.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./009_Calculator_Part_1.md">Next</a></td>
    </tr>
</table>