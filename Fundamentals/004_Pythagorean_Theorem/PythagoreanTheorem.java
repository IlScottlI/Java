import java.lang.Math; 

public class PythagoreanTheorem {
    public double calculateHypotenuse(int legA, int legB) {
        double c = (double) ((legA*legA) + (legB*legB)) ; 
        return Math.sqrt(c);
    }
}