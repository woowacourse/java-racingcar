package racingcar.dto;

import java.util.Random;

public class Car {
    private final static int RANDOM_NUMBER_OFFSET = 10;
    private final static int MOVE_OFFSET =4;
    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if(isPossibleMove(generateRandomNumber())){
            this.position++;
        }
    }

    protected boolean isPossibleMove(int num) {
        //return generateRandomNumber() > MOVE_OFFSET;
        return num > MOVE_OFFSET;
    }

    protected int generateRandomNumber() {
        return new Random().nextInt(10);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}
