package model;

public class RandomCarMoveManager implements CarMoveManager {

    @Override
    public boolean isMove() {
        int randomNumber = (int) (Math.random() * 9);
        return randomNumber >= 4;
    }
}
