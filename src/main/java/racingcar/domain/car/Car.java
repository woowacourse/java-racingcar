package racingcar.domain.car;

public class Car {

    private final Name name;
    private final Position position;
    private final GasTank gasTank;

    private Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
        this.gasTank = new GasTank();
    }

    public static Car enrollWithName(final String name) {
        return new Car(name);
    }

    public void fillUpGas(final int gas) {
        gasTank.fillUpGas(gas);
    }

    public void forward() {
        if (gasTank.isEnoughGas()) {
            position.forward();
        }
    }

    public String getName() {
        return name.toString();
    }

    public String getPosition() {
        return position.toString();
    }

    public boolean isWinner(int maxPosition) {
        return position.isWinner(maxPosition);
    }
}
