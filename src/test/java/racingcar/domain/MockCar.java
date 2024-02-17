package racingcar.domain;

public class MockCar extends Car {

    private int position = 0;

    public MockCar() {
        super("name");
    }

    public MockCar(final int position) {
        super("name");
        this.position = position;
    }

    @Override
    public void move(final boolean isMove) {
        if (isMove) {
            position++;
        }
    }

    @Override
    public boolean isPositionedAt(final int position) {
        return this.position == position;
    }

    @Override
    public String getName() {
        return "name";
    }

    @Override
    public int getPosition() {
        return position;
    }
}
