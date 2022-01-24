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

        return list.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        StringBuilder str= new StringBuilder();
        int prev =Integer.MIN_VALUE;
        int count = 0;
        for(int i :input){
            //System.out.println(count);
            if (prev +1 == i){
                count++;
                prev = i;
                continue;
            }

            if ( count > 1){

                str.append("-");
                if (prev<0){
                    str.append("(").append(prev).append(")").append(", ");
                }
                else{
                    str.append(prev).append(", ");
                }

            }

            else if(count==1){
                str.append(", ").append(prev).append(", ");

            }

            else if(prev != Integer.MIN_VALUE) {
                str.append(", ");
            }
            count=0;
            str.append(i);
            prev = i;

        }

        if ( count > 1){

            str.append("-");
            str.append(prev);
        }

        else if(count==1){
            str.append(", ").append(prev);
        }

        return str.toString();
    }
}
