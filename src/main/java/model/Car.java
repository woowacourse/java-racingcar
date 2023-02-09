package model;

public class Car {

    private final String name;
    private int position;
    private final CarMoveManager carMoveManager;


    public Car(String name, CarMoveManager carMoveManager) {
        this.name = name;
        this.position = 0;
        this.carMoveManager = carMoveManager;
    }

    public void move() {
        if (carMoveManager.isMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }

}
