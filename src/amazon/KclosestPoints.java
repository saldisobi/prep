package amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

class KclosestPoints {
    class Point{
        int xCoordinate;

        int yCoordinate;

        int distance;

        public Point(int x, int y){
            this.xCoordinate = x;
            this.yCoordinate = y ;

            distance = (int) Math.sqrt((Math.pow(x,2)) + Math.pow(y,2));

        }
    }
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<Point> pq = new PriorityQueue(Comparator.comparingInt((Point a) -> a.distance));

        int[][] result = new int[K][2];

        for (int i = 0; i < points.length; i++) {
            pq.offer(new Point(points[i][0], points[i][1]));
        }

        for (int i = 0; i < K; i++) {
            Point point = pq.poll();

            result[i][0] = point.xCoordinate;

            result[i][1] = point.yCoordinate;
        }

        return result;

    }
}