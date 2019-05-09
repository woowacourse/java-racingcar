package domain;

public class Car {
    private static int MIN_MOVE_NUMBER = 4;
    private static int MAX_MOVE_NUMBER = 9;
    private static int MIN_STOP_NUMBER = 0;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int judgeMove(int number) {
        if (number > MAX_MOVE_NUMBER || number < MIN_STOP_NUMBER) {
            return -1;
        }

        if (number >= MIN_MOVE_NUMBER) {
            position++;
            return 1;
        }

        return 0;
    }

    public int getBiggerPosition(int compareNum) {
       return Math.max(position, compareNum);
    }

    public boolean isMaxPosition(int compareNum) {
        return compareNum == position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name + " : " + new String(new char[position]).replace("\0", "-");
    }
}
