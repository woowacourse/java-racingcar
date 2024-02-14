package model;

public class Car {

    private static final int MOVE_NUMBER = 4;
    private static final String STEP = "-";
    private final String name;
    private int movement;

    public Car(String name) {
        this.name = name;
        this.movement = 0;
    }

    public void move(int number) {
        if (number >= MOVE_NUMBER) {
            this.movement++;
        }
    }

    public String getCarName(){
        return name;
    }

    public String generateMovement() {
        return STEP.repeat(movement);
    }

    public int getMovement() {
        return movement;
    }
}
