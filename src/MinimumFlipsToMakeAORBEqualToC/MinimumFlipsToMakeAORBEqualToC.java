package MinimumFlipsToMakeAORBEqualToC;

public class MinimumFlipsToMakeAORBEqualToC {
    public int minFlips(int a, int b, int c) {
        int answer = 0;
        while (a != 0 | b != 0 | c != 0) {
            if ((c & 1) == 1) { // last c's bit is 1, so a or b's last bit must be 1
                if ((a & 1) == 0 && (b & 1) == 0) // a and b's last bit is 0
                    answer++;
            } else { // last c's bit is 0, so both a and b's last bit must be 0
                answer += (a & 1) + (b & 1);
            }
            // Right Shift - Shifts 1 bit to the right (obviously)
            // Ex: 13 == 1101 -> 0101 == 4
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return answer;
    }
}