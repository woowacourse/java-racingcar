package racingcar;

public class Car {
    private static final int RANDOM_NUMBER_LIMIT = 10;
    private static final int FORWARD_NUM = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    int makeRandomNumber() {
        return (int) (Math.random() * RANDOM_NUMBER_LIMIT);
    }

    boolean shouldMove(int number) {
        return number >= FORWARD_NUM;
    }

    void move(boolean moveFlag) {
        position += (moveFlag) ? 1 : 0;
    }

    void play() {
        int randomNumber = makeRandomNumber();
        move(shouldMove(randomNumber));
    }

    boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}
