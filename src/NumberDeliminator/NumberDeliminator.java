package NumberDeliminator;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NumberDeliminator implements NumberRangeSummarizer {



    @Override
    public Collection<Integer> collect(String input) {

        String[] split = input.split("\s*,\s*");//this regex will split the numbers by the , regardless of a space before or after the ,
        List<String> list = Arrays.asList(split);

//        for(int i : s){
//            System.out.println(i);            //Display the list to check if it is correct
//        }
        List<Integer> list2 = null;
        try{
            //this line of code maps the string value in the list to the appropriate integer, sorts the integers in natural order and adds the all to the new list
            list2 = list.stream().map(Integer::parseInt).sorted().collect(Collectors.toList());

        }catch (NumberFormatException e){//if a decimal number is detected return error message.
            System.out.println("Please enter only integer Values");
        }


        return list2;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        //input = input.stream().sorted().collect(Collectors.toList());
        //string to hold our comma delimited list
        StringBuilder str= new StringBuilder();
        //starting value for previous num
        int prev =Integer.MIN_VALUE;
        int count = 0;// count to see if we need to make a range
        for(int i :input){
            //System.out.println(count);
            //if the previous number is one below the current then we will increment the count
            if (prev +1 == i){
                count++;
                prev = i;
                continue;
            }
            //if there is a duplicate we will skip it
            else if(prev == i){
                continue;
            }

            //if the count is greater than one then we will have a range of at least 3 numbers so we can use -
            if ( count > 1){

                str.append("-");
                //if the number is a negative we will put it in brackets so it is easier to see
                if (prev<0){
                    str.append("(").append(prev).append(")").append(", ");
                }
                else{
                    str.append(prev).append(", ");
                }

            }
            //if the count is 1 then we know the range is 2 numbers and we don't need to use -
            else if(count==1){
                str.append(", ").append(prev).append(", ");

            }
            //if our previous is not the base value we can add a , to the end
            else if(prev != Integer.MIN_VALUE) {
                str.append(", ");
            }
            //finally we reset the count and append the number to the string
            count=0;
            str.append(i);
            prev = i;

        }

        //if the loop is done and we still have a count above one we need to add a range
        if ( count > 1){

            str.append("-");
            str.append(prev);
        }
        //if the loop ends and we have a count of one we need to add the previous number to the string
        else if(count==1){
            str.append(", ").append(prev);
        }

        //return the completed string
        return str.toString();
    }
}
