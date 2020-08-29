package amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomTwo {

    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < intervals.length; i++) {
            priorityQueue.add(intervals[i][1]);

            if (intervals[i][0] < priorityQueue.peek()) {
                res++;
            } else {
                priorityQueue.poll();
            }
        }

        return res;
    }
}



