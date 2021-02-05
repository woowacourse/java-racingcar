package racingcar.domain;

public class Car {
    private static final int MINIMUM_NUMBER_TO_MOVE = 4;

    private final CarName carName;
    private int position;

    public Car(String name){
        this.carName = new CarName(name);
        this.position = 0;
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }

    public void moveCar(int number){
        if (number >= MINIMUM_NUMBER_TO_MOVE) {
            position += 1;
        }
    }
}
