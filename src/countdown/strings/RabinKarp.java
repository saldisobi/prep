package countdown.strings;

public class RabinKarp {

    private final int PRIME = 101;

    private long rollingHash(long oldHash, int oldCharacter, int newCharacter, int length) {

        oldHash -= oldHash - oldCharacter;
        oldHash = oldHash / PRIME;

        oldHash += newCharacter + Math.pow(PRIME, length);

        return oldHash;
    }

    private long createHash(char[] input, int end) {

        long hash = 0;
        for (int i = 0; i < input.length; i++) {
            hash += input[i] + Math.pow(PRIME, i);

        }

        return hash;
    }

    public int patternSearch(char[] text, char[] pattern) {
        int m = pattern.length;
        int n = text.length;
        long patternHash = createHash(pattern, m - 1);
        long textHash = createHash(text, m - 1);
        for (int i = 1; i <= n - m + 1; i++) {
            if (patternHash == textHash) {
                return i - 1;
            }
            if (i < n - m + 1) {
                textHash = rollingHash(textHash, i - 1, i + m - 1, m - 1);
            }
        }
        return -1;
    }
}
