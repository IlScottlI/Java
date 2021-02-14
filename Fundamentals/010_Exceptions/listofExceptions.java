import java.util.*;

public class listofExceptions {
    ArrayList<Object> myList = new ArrayList<Object>();

    public ArrayList<Object> listOf() {
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
                System.out.println(castedValue);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return myList;
    }
}
