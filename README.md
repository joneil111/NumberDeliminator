# NumberDeliminator
@author Jo-Neil Naicker
 
 This program will take any list of numbers and sort them in acceding order and display a summarized form to the user
 It will display a range when the numbers are sequential by using a "-" to separate them
 I have designed the program to only use valid integer values therefore if any decimal values and/or alphabetical characters are used it will skip that list and move on to the next one
 
 Since my program can accept integer values, I place negatives in brackets when they are the upper bound of the range making it clearer to the user as not to get confused.
 
 ie.  -4-(-1) indicates a range from -4 to -1
      -1-5 indicates a range from -1 to 5
      3-6 indicates a range from 3 to 6

 If you would like to add more unit tests please add them to the input.txt file and run the program to see the results.

 The program has extra functionality in place to take care of any errors in the input list.
 ie.  As long as the integer values are separated, in the input list, by a "," it will work regardless of spacing issues
      Errors involving non integer values will not crash the program
      Duplicate values are removed as they are not required by the summarizer