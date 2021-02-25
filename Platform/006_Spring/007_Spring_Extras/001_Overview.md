<table width="100%">
    <tr>
        <td><a href="./../006_Spring_Security/011_WaterBnB.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./002_JUnit.md">Next</a></td>
    </tr>
</table>

#

#   Overview
The following modules will give a brief overview of Test Driven Development in both Java and Spring.  We will be using the Book model created in the Spring Data I chapter.

#   Introduction to Test Driven Development
You've been assigned the task to update the registration for an existing project to include Facebook login. After finishing your work, you try to register some users manually only to find various bugs. You immediately fix them and other parts of your code start to break. Then you fix those, and the cycle repeats until you are satisfied with your feature.

There are a couple of problems with this approach. First, it's impossible to predetermine every different way that users may end up interacting with your application. Therefore, manually testing every feature ends up taking a lot of time and resources. Second, the changes to the code base that you made, while working fine in the scope of your feature, might have negatively affected another feature in the application even though they may not appear related.

Expanding on the second issue, let's go back to our example. After fixing all the obvious bugs in your code, you test your code manually and, satisfied, you pushed it into production. Days later some new users are complaining that one of the main features of your application is not working. After hours of searching, you realize that the feature is breaking because it is dependent on a user filling out his hometown during registration. Something that Facebook doesn't require you to fill out. 

Mistakes like these used to occur way too often in the industry especially as teams and code bases grew. In an attempt to ensure the quality of the code pushed to production, Test Driven Development was born.

_"Red, Green, Refactor". This is the motto that Test Driven Development stands on._

*   Red: Create a test and make it fail.
*   Green: Make the test pass by any means necessary.
*   Refactor: Change the code to remove duplication in your project and to improve the design while ensuring that all tests still pass.

Scenarios, as described above, are why some programmers often avoid making changes to code bases. A small code change can have very severe repercussions. With TDD, every time we make changes to our code, all of the features will be tested to ensure that everything is still working. This way, programmers can confidently code in large code bases without fear. Testing provides constant feedback that each component is still working.

With that said, TDD is a hard skill to master. The goal of this section is to introduce different TDD techniques and get you comfortable doing it on your own. Initially, we will provide the tests, and your goal will be to make them pass. And at the end of this section, you will be writing the tests and the code to make them pass.


#

[]()
<table width="100%">
    <tr>
        <td><a href="./../006_Spring_Security/011_WaterBnB.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./002_JUnit.md">Next</a></td>
    </tr>
</table>