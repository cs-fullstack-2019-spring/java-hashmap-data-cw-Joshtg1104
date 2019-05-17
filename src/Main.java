import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, String> dictionary = new HashMap<String, String>();
    public static void main(String[] args) {
        File myDict = new File("src/dict.txt");
        Scanner scanDict = null;
        try {
            scanDict = new Scanner(myDict);
            while(scanDict.hasNextLine()){
                String txt = scanDict.nextLine();
                String[] parts = txt.split(",");
                dictionary.put(parts[0],parts[1]);
            }
//            for(String d : dictionary.keySet()){
//                System.out.println(d+" : "+dictionary.get(d));
//            }

            Scanner read =new Scanner(System.in);
            System.out.println("Enter the word you are looking for: ");
            String word = read.nextLine().trim().toLowerCase();
            String response = dictionary.get(word) != null?dictionary.get(word): "Word Not Found!";
            System.out.println(response);

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
