<table width="100%">
    <tr>
        <td><a href="./021_Ninja_Gold_Game.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./023_Thymeleaf.md">Next</a></td>
    </tr>
</table>

#

#      Dependency Injection
You may have noticed in your code that we have parameters that we never provide arguments for. We declare the type and name them, and then just hope that something will provide the expected input (E.g. `Model model`). We are able to do this because of Dependency Injection. This is a powerful design pattern that inverts the usual control flow of a program (where your class would instantiate the classes that it needs). This process is called "Inversion of Control," or "IoC". Together IoC and DI are a large part of modern Java frameworks.

The way it works is a container (the IoC container) finds all the dependencies, instantiates them, and injects them where required. An example that you've used is the `Model model` in your controller methods:
```java
// ...
@RequestMapping("/")
public String index(Model model) {
    model.addAttribute("dojoName", "Burbank");
    return "index";
}
// ...
```
You never instantiate `model` anywhere, but somehow it is there for us to use - that is because of the IoC Container.

This process decouples the class construction from the construction of its dependencies, which results in cleaner, more modular, and more maintainable code. It also makes testing, when you get there, much easier.

If you want to dive into the plumbing of how it works, check out the [Inversion of Control Container Docs](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html)

### __Useful Links__
*   [IoC Container](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html)

#

[]()
<table width="100%">
    <tr>
        <td><a href="./021_Ninja_Gold_Game.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./023_Thymeleaf.md">Next</a></td>
    </tr>
</table>