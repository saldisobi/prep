package countdown.strings;


public class Regex {

    public String removePunctuation(String s) {
        s = s.replaceAll("[^a-zA-Z ]", "");

        return s;

    }

    public static void main(String args[]) {
        System.out.println(new Regex().removePunctuation("hi, my name is Sourabh. 123 I love coding!!"));
    }
}
