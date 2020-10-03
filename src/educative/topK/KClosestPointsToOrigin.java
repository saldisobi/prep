package educative.topK;

import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    static class Point {
        int X;
        int Y;

        Point(int xCor, int yCor) {
            this.X = xCor;
            this.Y = yCor;
        }

        public int getDistanceFromOrigin() {
            return X * X + Y * Y;
        }
    }

    public PriorityQueue<Point> getKNearestPoints(List<Point> points, int k) {
        PriorityQueue<Point> minHeap = new PriorityQueue<Point>((a, b) -> a.getDistanceFromOrigin() - b.getDistanceFromOrigin());

        for (int i = 0; i < points.size(); i++) {
            if (i < k) {
                minHeap.add(points.get(i));
            } else {
                if (minHeap.peek().getDistanceFromOrigin() < points.get(i).getDistanceFromOrigin()) {
                    minHeap.remove();
                    minHeap.add(points.get(i));
                }
            }
        }

        return minHeap;
    }

    public static void main(String args[]){

        Point point = new Point(1,2);
        //bf time cut off
    }
}
