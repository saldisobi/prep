package educative.mergeintervals;

import java.util.Arrays;

public class AttendMeeting {


    public boolean canAttendMeetings(int[][] appointments) {

        Arrays.sort(appointments,(a,b)->Integer.compare(a[0],b[0]));

        for (int i = 1; i < appointments.length - 1; i++) {
            if (appointments[i][0] < appointments[i - 1][1]) {
                return false;
            }
        }

        return true;

    }

    public static void main(String args[]){
        System.out.println(new AttendMeeting().canAttendMeetings(new int[][]{{1,4},{4,5},{7,9}}));
    }
}
