package countdown.strings;

public class StringCompression {

    private char[] compressString(char[] input) {
        char current = input[0];

        int currentCounter = 0;

        int insertingIndex = 0;


        char[] result = new char[input.length];

        int counter = 0;

        while (counter < input.length) {
            if (input[counter] == current) {
                currentCounter++;
            } else {
                result[insertingIndex] = current;
                insertingIndex++;

                char[] nums = (currentCounter + "").toCharArray();

                for (int i = 0; i < nums.length; i++) {
                    insertingIndex = insertingIndex + i;
                    result[insertingIndex] = nums[i];
                }

                insertingIndex++;

                current = input[counter];
                currentCounter = 1;
            }

            counter++;
        }

        result[insertingIndex] = current;
        insertingIndex++;

        char[] nums = (currentCounter + "").toCharArray();

        for (int i = 0; i < nums.length; i++) {
            insertingIndex = insertingIndex + i;
            result[insertingIndex] = nums[i];
        }


        return result;
    }


    private String compressString(String input) {
        int currentCounter = 1;

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < input.length() - 1; i++) {

            if (input.charAt(i) == input.charAt(i + 1)) {
                currentCounter++;
            } else {
                res.append(input.charAt(i));
                res.append(currentCounter);
                currentCounter = 1;
            }

        }

        res.append(input.charAt(input.length() - 1));
        res.append(currentCounter);

        return res.toString();
    }

    public static void main(String args[]) {
        System.out.println(new StringCompression().compressString("aabcccccaaa".toCharArray()));
        System.out.println(new StringCompression().compressString("aabcccccaaa"));
    }


}
