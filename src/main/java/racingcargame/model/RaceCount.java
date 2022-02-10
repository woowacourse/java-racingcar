package racingcargame.model;

public class RaceCount {
    private static int count;

    private RaceCount() {
    }

    public static void storeCount(int number) {
        count = number;
    }

    public static void reduceRaceCount() {
        count--;
    }

    public static int getCount() {
        return count;
    }
}
