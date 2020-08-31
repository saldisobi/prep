package amazon;

class StringCompression {
    public int compress(char[] chars) {

        int insertingIndex = 0;

        int firstPointer = 0;


        while (firstPointer < chars.length) {
            int secondPointer = firstPointer;

            while (secondPointer < chars.length && chars[secondPointer] == chars[firstPointer]) {
                secondPointer++;
            }

            chars[insertingIndex] = chars[firstPointer];

            insertingIndex++;

            if ((secondPointer - firstPointer) > 1) {
                char[] newChars = Integer.toString(secondPointer - firstPointer).toCharArray();
                for (int i = 0; i < newChars.length; i++) {
                    chars[insertingIndex] = newChars[i];
                    insertingIndex++;
                }
            }

            firstPointer = secondPointer;
        }

        return insertingIndex;


    }


}