import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Arrays;
public class PuzzleJava {

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

}