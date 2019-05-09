package racingcar.dto;

import java.util.Random;

public class Car {
    private final static int RANDOM_NUMBER_OFFSET = 10;
    private final static int MOVE_OFFSET = 4;
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (isPossibleMove()) {
            this.position++;
        }
    }

    public void move(int num) { //테스트 코드를 위한 코드
        if (isPossibleMove(num)) {
            this.position++;
        }
    }

    protected boolean isPossibleMove(int num) { //테스트 코드를 위한 코드
        return num > MOVE_OFFSET;
    }

    protected boolean isPossibleMove() {
        return generateRandomNumber() > MOVE_OFFSET;
    }

    protected int generateRandomNumber() {
        return new Random().nextInt(RANDOM_NUMBER_OFFSET);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
