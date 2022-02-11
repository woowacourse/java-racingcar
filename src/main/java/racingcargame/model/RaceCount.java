package racingcargame.model;

public class RaceCount {
    private static int count;

    private RaceCount() {
    }

    static void storeCount(int number) {
        count = number;
    }

    static void reduceRaceCount() {
        count--;
    }

    static int getCount() {
        return count;
    }
}
