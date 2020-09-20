package educative.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {

    public int findMinimumMeetingRooms(int[][] meetings) {
        if (meetings == null || meetings.length == 0) {
            return 0;
        }

        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));


        PriorityQueue<int[]> meetingRooms = new PriorityQueue<>(meetings.length, (a, b) -> Integer.compare(a[1], b[1]));
        meetingRooms.add(meetings[0]);
        for (int i = 1; i < meetings.length; i++) {
            int[] currentMeeting = meetings[i];
            int[] earliestFinishing = meetingRooms.remove();

            if (currentMeeting[0] >= earliestFinishing[1]) {
                earliestFinishing[1] = currentMeeting[1];
            } else {
                meetingRooms.add(currentMeeting);
            }

            meetingRooms.add(currentMeeting);
        }

        return meetingRooms.size();
    }

    public static void main(String args[]) {
        System.out.println(new MeetingRooms().findMinimumMeetingRooms(new int[][]{{1, 2}, {2, 3}, {2, 5}}));
    }
}
