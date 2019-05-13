package racing.model;

public class Random {
    public static int getIntegerValue(int start, int end) {

        return (int)(Math.random() * (start - end + 1) + start);

    }
}
