package MeetingRoomsIII;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MeetingRoomsIIITest {

    @Test
    void mostBooked1() {
        assertEquals(1, new MeetingRoomsIII().mostBooked(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}));
    }

    @Test
    void mostBooked2() {
        assertEquals(0, new MeetingRoomsIII().mostBooked(2, new int[][]{{0,10},{1,2},{12,14},{13,15}}));
    }

    @Test
    void mostBooked3() {
        assertEquals(1, new MeetingRoomsIII().mostBooked(3, new int[][]{{0,10},{1,9},{2,8},{3,7},{4,6}}));
    }

    @Test
    void mostBooked4() {
        assertEquals(1, new MeetingRoomsIII().mostBooked(2, new int[][]{{43,44},{34,36},{11,47},{1,8},{30,33},{45,48},{23,41},{29,30}}));
    }
}