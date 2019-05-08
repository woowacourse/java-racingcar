package domain;

public class Car {
    private static int MIN_MOVE_NUMBER = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public int judgeMove(int number) {
        if (number >= MIN_MOVE_NUMBER) {
            position++;
        }
        return position;
    }

    
}
