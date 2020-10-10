package countdown.strings;

public class OneAway {

    public boolean oneAway(String s1, String s2) {

        if(Math.abs(s1.length()-s2.length())>1){
            return false;
        }

        int i = 0;

        int j = 0;

        int error = 0;

        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else if (error == 0) {
                error++;
                if (s1.length() == s2.length()) {
                    i++;
                    j++;
                } else if (s1.length() > s2.length()) {
                    i++;
                } else {
                    j++;
                }
            } else {
                return false;
            }
        }

        return true;

    }

    public static void main(String args[]) {
        System.out.println(new OneAway().oneAway("pale", "ple"));
        System.out.println(new OneAway().oneAway("pales", "pale"));
        System.out.println(new OneAway().oneAway("pale", "bale"));
        System.out.println(new OneAway().oneAway("pale", "bake"));
    }
}
