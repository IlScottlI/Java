<table width="100%">
    <tr>
        <td><a href="./004_Assertions.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./006_JUnit_Spring.md">Next</a></td>
    </tr>
</table>

#

#   JUnit Singly Linked List
In the previous examples, we didn't follow the TDD standard of writing the test first, and then writing the code to pass the test.  To complete this assignment, you will need to write the code, to pass the given test.

Using the Singly Linked List assignment as a guideline, recreate the SLL class to pass the following test:
```java
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class TestSLL {
    
    public SLL sll;
    @Before
    public void setUp() throws Exception {
        sll = new SLL();
    }
    @Test
    public void testHeadForNull() {
        assertNull(sll.head);
    }
    
    @Test
    public void testHeadForNode() {
        sll.add(8);
        assertNotNull(sll.head);
    }
    
    @Test
    public void testHeadNextVal() {
        sll.add(5);
        sll.add(10);
        assertTrue(sll.head.next.value == 10);
    }
    
    @Test
    public void testHeadAfterRemove() {
        sll.add(10);
        sll.removeFront();
        // write test first, then write code to pass the test.
    }
}
```
#

[]()
<table width="100%">
    <tr>
        <td><a href="./004_Assertions.md">Back</a></td>
        <td><a href="../../Index.md">Index</a></td>
        <td><a href="./006_JUnit_Spring.md">Next</a></td>
    </tr>
</table>