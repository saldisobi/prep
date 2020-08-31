package amazon;

import java.util.Stack;

class AsteroidCollission {
    public int[] asteroidCollision(int[] asteroids) {


        Stack<Integer> asteroidStack = new Stack();

        int i = 0;

        while (i < asteroids.length) {
            if (asteroids[i] > 0) {
                asteroidStack.push(asteroids[i]);
            } else {


                while (!asteroidStack.isEmpty() && asteroidStack.peek() > 0 && asteroidStack.peek() < asteroids[i]) {

                    asteroidStack.pop();
                }
                if (asteroidStack.isEmpty() || asteroidStack.peek() < 0) {
                    asteroidStack.push(asteroids[i]);
                } else if (asteroidStack.peek() == Math.abs(asteroids[i])) {
                    asteroidStack.pop();
                }


            }

            i++;
        }


        int[] res = new int[asteroidStack.size()];

        for (
                int j = asteroidStack.size() - 1;
                j >= 0; j--) {
            res[j] = asteroidStack.pop();

        }

        return res;

    }

    public static void main(String args[]) {
        System.out.println(new AsteroidCollission().asteroidCollision(new int[]{5, 10, -5}).length);
    }
}