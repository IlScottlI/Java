<table width="100%">
    <tr>
        <td><a href="./006_Phone.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./008_POJOs_JavaBeans.md">Next</a></td>
    </tr>
</table>

#

#      Annotations
## __Objectives:__
*   Introduction and implementation of annotations
#
In Java SE 5 (or 1.5, depending on who you ask), annotations were introduced to help developers make certain notes about the code. Of course, we already had a way to do that: comments, but these notes are not just for other humans to read, but for the compiler and build tools.

## __Annotation Usage__
To understand why we would want annotations, let's imagine that you are trying to override the `getName()` method for some reason. You might write the following code:
```java
class Human {
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }
}
```
```java
public class Developer extends Human{
    public String getName(){
        return "Developer!";
    }
}
```
Of course, you might see the error, but when it is >10,000 lines of code, are you sure you would catch it?

What if we could tell our compiler that we want to make sure we are actually overriding a method? Then we can add an `@Override` annotation:
```java
public class Developer extends Human{
    @Override
    public String getName(){
        return "Developer!";
    }
}
```
This will have our compiler tell us that we failed to override a parent method when we tried to!

In the same way, imagine that we have a method that we no longer want to use, but is tightly coupled with our application, so we "deprecate" it; that is, we want to indicate it will be phased out, but we can't quite remove it yet. Then we will use the `@Deprecated` annotation so that anyone compiling the code will be notified that the method they just used should not be used. Try adding the `@Deprecated` flag to some methods and see what the compiler tells you. Also, try compiling your code on the CLI using the `-Xlint:deprecation` flag.

## __Custom Annotations__
While it is possible to write your own annotations, it is uncommon to need to write your own (unless you become a framework designer). If you do decide to write your own, you will need to utilize the javac compiler, and the `javax` packages `annotation.processing` and `annotation.model`. As we go along, we will see framework specific annotations through the course.

### __Useful Links:__
*   [Java Annotations](http://docs.oracle.com/javase/tutorial/java/annotations/index.html)
*   [javac](http://docs.oracle.com/javase/7/docs/technotes/tools/index.html)
*   [javax annotation processing](http://docs.oracle.com/javase/7/docs/api/javax/annotation/processing/package-summary.html)
*   [javax language model](http://docs.oracle.com/javase/7/docs/api/javax/lang/model/package-summary.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./006_Phone.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./008_POJOs_JavaBeans.md">Next</a></td>
    </tr>
</table>