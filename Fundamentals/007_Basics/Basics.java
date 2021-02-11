import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Collections;

public class Basics {
    public void print1_255() {
        for (int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }
    public void print1_255_Odd() {
        for (int i = 1; i <= 255; i++){
            if(i % 2 != 0){
                System.out.println(i);
            } 
        }
    }
    public void printSum() {
        int sum = 0;
            for (int i = 0; i <= 255; i++){
                sum = sum + i;
                System.out.println("New number: " + i + " Sum: " + sum);
        }
    }
    public void iteratingArray(int [] arr) {
        for (int number : arr){
            System.out.println(number);
          }
    }

    public void findMax(int [] arr){
        IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        System.out.println(stat.getMax());
    }

    public void getAverage(int [] arr){
        IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        System.out.println(stat.getAverage());
    }

    public void print1_255_Odd_Array() {
        ArrayList<Object> y = new ArrayList<Object>();
        for (int i = 1; i <= 255; i++){
            if(i % 2 != 0){
                y.add(i);
            } 
        }
        System.out.println(y);
    }
    public void greaterThanY(int[] arr, int y) {
        int sum = 0;
        for (int i : arr) {
            if(i > y){
            sum ++;
            }
        }
        System.out.println(sum);
    }

    public void eliminateNeg(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if( arr[i] < 0){
                arr[i] = 0;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public void minMaxAvg(Integer[] arr){
        int total = 0;
        for(int i=0; i<arr.length; i++){
        	total = total + arr[i];
        }
        int min = Collections.min(Arrays.asList(arr));
        int max = Collections.max(Arrays.asList(arr));
        int avg = total / arr.length;
        int[] newArr = {max,min,avg};
        System.out.println(Arrays.toString(newArr));
    }

    public void shiftArray(int[] arr){
        int[] newArr;
        newArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {  
            if(i < arr.length - 1 ) {
                newArr[i] = arr[i+1];
            }            
        } 
        System.out.println(Arrays.toString(newArr));
    }
}