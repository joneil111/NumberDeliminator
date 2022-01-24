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
        List<Integer> s =list.stream().map(Integer::parseInt).collect(Collectors.toList());

//        for(int i : s){
//            System.out.println(i);            //Display the list to check if it is correct
//        }

        return s;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {

        String str="";
        int prev =Integer.MIN_VALUE;
        int count = 0;
        for(int i :input){

            if (prev +1 == i){
                count++;
                prev = i;
                continue;
            }

            if ( count > 1){

                str = str+"-";
                str = str+prev+",";
                count =0;
            }
            else if(prev != Integer.MIN_VALUE) {
                str = str + ",";
            }
            else if(count==1){
                str = str+prev+",";
                count = 0;
            }

            count=0;
            str = str +i;
            prev = i;

        }

        if (true && count > 1){
            str = str+"-"+prev;
        }

        return str;
    }
}
