package NumberDeliminator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        NumberDeliminator n = new NumberDeliminator();


        String s = n.summarizeCollection(n.collect("1,2,   3,5,6   ,8,12,13,14,16,19,22,23,25,26"));
        System.out.println(s);
    }
}
