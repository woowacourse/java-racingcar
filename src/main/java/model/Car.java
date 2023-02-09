package model;

import dto.CarDto;
import dto.WinnerCarDto;
import model.wrapper.Name;
import model.wrapper.Position;
import utils.RacingNumberGenerator;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void race(RacingNumberGenerator generator) {
        position.move(generator);
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public int compareTo(Car otherCar) {
        return this.position.compareTo(otherCar.position);
    }

    public boolean isSamePosition(Car otherCar) {
        return this.position.isSamePosition(otherCar.position);
    }

    public CarDto mapToCarDto() {
        return new CarDto(name.getName(), position.getPosition());
    }

    public WinnerCarDto mapToWinnerCarDto() {
        return new WinnerCarDto(name.getName());
    }
}
