package NumberDeliminator;

import java.util.Collection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        NumberDeliminator n = new NumberDeliminator();
        Collection<Integer> collection =n.collect("31, 3,1,1,3,3,22,24, 1, 14,13,22,24,21,7,8,6,23,15,12");
        if (collection !=null){
            String s = n.summarizeCollection(collection);
            System.out.println(s);
        }

    }
}
/*
* -20,-14,-13,-12,-11,-5, -4, -2, 0 ,1,2,   3,5,6   ,8,12,13,14,16,19,22,23,25,26
* */