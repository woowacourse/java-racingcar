package racingcargame.model;

public class RaceCount {
    private static int count;

    private RaceCount() {
    }

    static void initCount(int number) {
        count = number;
    }

    static void reduceCount() {
        count--;
    }

    static int getCount() {
        return count;
    }
}
