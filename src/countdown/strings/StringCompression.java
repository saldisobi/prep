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

    public static void main(String args[]) {
        System.out.println(new StringCompression().compressString("aabcccccaaa".toCharArray()));
    }


}
