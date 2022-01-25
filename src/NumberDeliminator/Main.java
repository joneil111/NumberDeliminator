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
        //count for the questions
        int count = 1;

        //read inputs for the file
        try{
            File myfile = new File("input.txt");
            Scanner myScan = new Scanner(myfile);
            while  (myScan.hasNextLine()){
                String data = myScan.nextLine();
                //call the collect method from the NumberDeliminator class
                Collection<Integer> collection =numDel.collect(data);
                System.out.print(count+")\t");
                count++;
                //if the collection variable is null we know that there was an error with the input list so we dont need to display anything
                if (collection !=null){
                    //call the summarizecollection method and display the summarised list
                    String s = numDel.summarizeCollection(collection);
                    System.out.println(s+"\n");

                }
            }

        }catch (FileNotFoundException e){//in case the file does not exist catch the error and show the stack trace
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