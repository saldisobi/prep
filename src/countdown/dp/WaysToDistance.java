package countdown.dp;

public class WaysToDistance {


    int getWaysToDistance(int distance) {

        if (distance > 0) {
            return getWaysToDistance(distance - 1) + getWaysToDistance(distance - 2) + getWaysToDistance(distance - 3);
        } else if (distance == 0) {

            return 1;
        } else return 0;

    }

    int getWaysToDistanceBottomUp(int distance) {

        int[] lookUp = new int[distance + 1];
        lookUp[0] = 1;
        lookUp[1] = 1;
        lookUp[2] = 2;

        for (int i = 3; i <= distance; i++) {
            lookUp[i] = lookUp[i - 1] + lookUp[i - 2] + lookUp[i - 3];
        }

        return lookUp[distance];

    }

    public static void main(String args[]) {
        System.out.println(new WaysToDistance().getWaysToDistance(3));

        System.out.println(new WaysToDistance().getWaysToDistanceBottomUp(3));
    }

}
