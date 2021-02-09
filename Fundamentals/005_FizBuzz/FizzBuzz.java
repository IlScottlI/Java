public class FizzBuzz {
    public String fizzBuzz(int number) {
        String resFizz = "";
        String resBuzz = "";
        String output;
        if(number % 3 == 0)
        {
            resFizz = "Fizz";
        }
        if(number % 5 == 0)
        {
            resBuzz = "Buzz";
        }
        output = resFizz.concat(resBuzz);
        if (resFizz.length() < 1){
            if(resBuzz.length() < 1){
                output = Integer.toString(number);
            }
        }
        
        return output;
    }
}