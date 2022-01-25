
package NumberDeliminator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Scanner;
/**
 * @author Jo-Neil Naicker
 *
 *  This program will take any list of numbers and sort them in acceding order and display a summarized form to the user
 *  It will display a range when the numbers are sequential by using a "-" to separate them
 *  I have designed the program to only use valid integer values therefore if any decimal values and/or alphabetical characters are used it will skip that list and move on to the next one
 *
 *  Since my program can accept integer values, I place negatives in brackets when they are the upper bound of the range making it clearer to the user as not to get confused.
 *
 *  ie.  -4-(-1) indicates a range from -4 to -1
 *       -1-5 indicates a range from -1 to 5
 *       3-6 indicates a range from 3 to 6
 *
 *  If you would like to add more unit tests please add them to the input.txt file and run the program to see the results.
 *
 *  The program has extra functionality in place to take care of any errors in the input list.
 *  ie.  As long as the integer values are separated, in the input list, by a "," it will work regardless of spacing issues
 *       Errors involving non integer values will not crash the program
 *       Duplicate values are removed as they are not required by the summarizer
 *
 */
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

                //if the collection variable is null we know that there was an error with the input list so we dont need to display anything
                if (collection !=null){
                    //call the summarizecollection method and display the summarised list
                    String s = numDel.summarizeCollection(collection);
                    System.out.print(count+")\t");
                    count++;
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