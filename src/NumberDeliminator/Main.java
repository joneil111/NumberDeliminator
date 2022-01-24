package NumberDeliminator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        NumberDeliminator n = new NumberDeliminator();


        String s = n.summarizeCollection(n.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31"));
        System.out.println(s);
    }
}
/*
* -20,-14,-13,-12,-11,-5, -4, -2, 0 ,1,2,   3,5,6   ,8,12,13,14,16,19,22,23,25,26
* */