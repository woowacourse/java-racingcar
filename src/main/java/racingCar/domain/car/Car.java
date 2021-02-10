package racingCar.domain.car;

import static racingCar.domain.car.Position.ZERO;

import java.util.Objects;
import racingCar.domain.car.Engine.Engine;

public class Car {

    private final Name name;
    private final Engine engine;
    private Position position;


    public Car(String name, Engine engine){
        this(new Name(name), ZERO, engine);
    }

    public Car(String name, int position, Engine engine){
        this(new Name(name), new Position(position), engine);
    }

    public Car(Name name, Position position, Engine engine) {
        this.name = name;
        this.engine = engine;
        this.position = position;
    }

    public void run() {
        if (engine.isMove()) {
            this.position = position.goForward();
        }
    }

    public boolean isOn(int max) {
        return position.isEqualTo(max);
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName(){
        return name.getName();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
            Objects.equals(engine, car.engine) &&
            Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, engine, position);
    }

    public int getMaxValue(final int position) {
        return this.position.getMaxValue(position);
    }
}
