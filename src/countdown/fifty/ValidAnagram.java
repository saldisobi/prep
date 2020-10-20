package countdown.fifty;

public class ValidAnagram {

    public boolean isValidAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int[] s1Char = new int[26];
        int[] s2Char = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Char[s1.charAt(i) - 'a'] = 1;
        }

        for (int i = 0; i < s2.length(); i++) {
            s2Char[s2.charAt(i) - 'a'] = 1;
        }

        for (int i = 0; i < s1Char.length; i++) {
            if (s1Char[i] != s2Char[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        ValidAnagram validAnagram = new ValidAnagram();

        System.out.println(validAnagram.isValidAnagram("car", "arc"));

        System.out.println(validAnagram.isValidAnagram("sobi", "saldi"));
    }
}
