package racingcar.domain;

public class MovableImpl implements Movable {

    @Override
    public int randomNumber() {
        return (int)(Math.random() * 100) % 10;
    }
}
