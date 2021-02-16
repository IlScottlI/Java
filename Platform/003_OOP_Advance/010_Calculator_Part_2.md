<table width="100%">
    <tr>
        <td><a href="./009_Calculator_Part_1.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./../004_Data_Structures/001_Doubly_Linked_Lists.md">Next</a></td>
    </tr>
</table>

#

#   Calculator Part II
The client has requested a change in spec: they need the calculator to process multiple values, as well as have some more complex abilities. They need the possibility for you to add several numbers in a row: this requires a change in our interface as we can't be sure how many total operands the client will be using. Now they expect this to work:

● `performOperation(10.5)`

● `performOperation("+")`

● `performOperation(5.2)`

● `performOperation("*")`

● `performOperation(10)`

● `performOperation("=")`

● `getResults()`

where the result would be `62.5`. They want to be able to do this for an arbitrary number of numbers, as well as add in the capability to multiply and divide. You can assume that all inputs will be valid. Notice that the calculator must correctly perform the order of operations.

### __Objectives:__
● Practice classes and objects.

● Implement a calculator in java.

### __Tasks:__
● Create the `Calculator` bean that will allow for the user to set operands and operations, then perform them and get the results.

● Have logic for adding, subtracting, dividing, and multiplication.

### __Notes:__
● You may want to use helper boolean properties to indicate if an operation or operand has been set or used yet.

#

[]()
<table width="100%">
    <tr>
        <td><a href="./009_Calculator_Part_1.md">Back</a></td>
        <td><a href="../Index.md">Index</a></td>
        <td><a href="./../004_Data_Structures/001_Doubly_Linked_Lists.md">Next</a></td>
    </tr>
</table>