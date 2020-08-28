package amazon;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {

        if(n == 0 ||n == Integer.MIN_VALUE)
            return false;
        return (n & -n) == n;

    }
}
