package educative.twopointers;

public class BackSpaceCompare {

    int s1Pointer;
    int s2Pointer;

    public boolean isBackspaceEqual(String s1, String s2) {
        s1Pointer = s1.length() - 1;
        s2Pointer = s2.length() - 1;

        while (s1Pointer > 0 || s2Pointer > 0) {
            if (getNextValidCharacterIndex(s1, s1Pointer, true) != getNextValidCharacterIndex(s2, s2Pointer, false)) {
                return false;
            }
        }

        return true;

    }

    private int getNextValidCharacterIndex(String s, int index, boolean isS1) {

        int skipCount = 0;

        for (int i = index; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                skipCount++;
            } else if (skipCount > 0) {
                skipCount--;
            } else {
                if (isS1) {
                    s1Pointer = i;
                } else {
                    s2Pointer = i;
                }
            }

        }

        if (isS1) {
            return s1Pointer;
        } else {
            return s2Pointer;
        }
    }


    public static void main(String args[]) {
        System.out.println(new BackSpaceCompare().isBackspaceEqual("#", "a"));
    }
}
