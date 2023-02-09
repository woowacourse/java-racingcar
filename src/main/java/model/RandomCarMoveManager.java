package model;

public class RandomCarMoveManager implements CarMoveManager {

    public static final int MAX_NUMBER = 9;
    public static final int BOUNDARY_VALUE = 4;

    @Override
    public boolean isMove() {
        int randomNumber = (int) (Math.random() * MAX_NUMBER);
        return randomNumber >= BOUNDARY_VALUE;
    }
}
