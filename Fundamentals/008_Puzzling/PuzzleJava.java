import java.util.*; 

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

    public String[] shuffleArray(String[] arr){
        ArrayList<Object> newArr = new ArrayList<Object>();

        Random r = new Random();

        for (int i = 0; i < arr.length; i++) {
            String item = arr[r.nextInt(arr.length)];
            System.out.println(item);
            if(item.length() > 5){
                newArr.add(item);   
            }            
        }

        String [] returnArr = new String [newArr.size()];

        for (int i = 0; i < newArr.size(); i++) {
            returnArr[i] = newArr.get(i).toString(); 
        }
        return returnArr;
    }

    public String alphabetShuffle() {
        ArrayList<Object>  all26 = new ArrayList<Object>(); 
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        char c;
        int i = 0;
        for(c = 'A'; c <= 'Z'; ++c, i++ ){
            all26.add(c);          
        }
        
        Collections.shuffle(all26);
        char lastLetter = all26.get(25).toString().charAt(0);
        char firstLetter = all26.get(0).toString().charAt(0);
        System.out.println(firstLetter);
        System.out.println(lastLetter);

        String message =  "";
        for (char item : vowels) {
           if(firstLetter == item){
               message = "First Letter is a Vowel";
           }
        }
        return message;
    }


    public int[] randomNumbers55_100(){
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100-55) + 55;
        }
        return arr;
    }

    public ArrayList<Integer>  randomNumbers55_100_sorted(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int item = r.nextInt(100-55) + 55;
            arr.add(item);
        }
        Collections.sort(arr);
        return arr;
    }


    public String getFiveString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = new Random();
    
        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();
    
        return generatedString;
    }

    public ArrayList<Object> getFiveStringArray(){
        ArrayList<Object>  arr = new ArrayList<Object>();

        for (int i = 0; i < 10; i++) {
            arr.add(this.getFiveString());            
        }
        return arr;
    }
}