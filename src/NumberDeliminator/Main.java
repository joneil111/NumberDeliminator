package NumberDeliminator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //creating instance of NumberDeliminator class.
        NumberDeliminator numDel = new NumberDeliminator();
        try{
            File myfile = new File("input.txt");
            Scanner myScan = new Scanner(myfile);
            while  (myScan.hasNextLine()){
                String data = myScan.nextLine();
                Collection<Integer> collection =numDel.collect(data);
                if (collection !=null){
                    String s = numDel.summarizeCollection(collection);
                    System.out.println(s+"\n");
                }
            }

        }catch (FileNotFoundException e){
            System.out.println("File Does Not Exist.");
            e.printStackTrace();
        }





    }
}
/*
* -20,-14,-13,-12,-11,-5, -4, -2, 0 ,1,2,   3,5,6   ,8,12,13,14,16,19,22,23,25,26
*
* 31, 3,1,1,3,3,22,24, 1, 14,13,22,24,21,7,8,6,23,15,12
* */