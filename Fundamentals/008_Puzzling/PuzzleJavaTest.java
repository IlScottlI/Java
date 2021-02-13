import java.util.Arrays;

public class PuzzleJavaTest {
    public static void main(String[] args) {
        PuzzleJava puzzle = new PuzzleJava();

        String[] arr = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        
        System.out.println(
            puzzle.printTenUp(arr)
        );
    }
}