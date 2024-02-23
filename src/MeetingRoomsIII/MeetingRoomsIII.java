package MeetingRoomsIII;

import java.util.*;

public class MeetingRoomsIII {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(arr -> arr[0]));
        int[] roomUses = new int[n];
        PriorityQueue<Integer> openRooms = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) openRooms.add(i);
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>(n, Comparator.comparingInt(arr -> arr[1]));

        for (int[] meeting : meetings) {
            while (!busyRooms.isEmpty() && meeting[0] >= busyRooms.peek()[1]) {
                openRooms.add(busyRooms.poll()[0]);
            }
            int room, endTime = meeting[1];
            if (openRooms.isEmpty()) {
                int[] nextEndingMeeting = busyRooms.poll();
                room = nextEndingMeeting[0];
                endTime += nextEndingMeeting[1] - meeting[0];
            } else {
                room = openRooms.poll();
            }
            busyRooms.add(new int[] { room, endTime });
            roomUses[room]++;
        }

        int roomMostUsed = 0;
        for (int i = 1; i < n; i++)
            if (roomUses[i] > roomUses[roomMostUsed]) roomMostUsed = i;
        return roomMostUsed;
    }
}
