package racingCar.domain.car;

import java.util.Objects;
import racingCar.domain.car.Engine.Engine;

public class Car {

    private final Name name;
    private final Engine engine;
    private Position position;


    public Car(String name, Engine engine){
        this(name, new Position(0), engine);
    }

    public Car(String name, Position position, Engine engine) {
        this.name = new Name(name);
        this.engine = engine;
        this.position = position;
    }

    public void run() {
        if (engine.isMove()) {
            this.position = position.goForward();
        }
    }

    public boolean isOn(int max) {
        return position.getPosition() == max;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName(){
        return name.getName();
    }

    @Override
    public boolean equals(Object o) {
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
}
