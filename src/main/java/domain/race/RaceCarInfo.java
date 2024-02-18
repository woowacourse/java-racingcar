package domain.race;

import domain.name.Name;
import domain.car.Car;

public class RaceCarInfo {
    private final Name name;
    private final int position;

    private RaceCarInfo(Name name, Integer position) {
        this.name = name;
        this.position = position;
    }


    public static RaceCarInfo from(Car car) {
        return new RaceCarInfo(car.getName(), car.getPosition());
    }

    public int getPosition() {
        return position;
    }

    public Name getName() {
        return name;
    }
}
