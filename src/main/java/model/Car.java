package model;

import dto.RacingCarStateDto;
import dto.WinnerCarDto;
import model.wrapper.Name;
import model.wrapper.Position;
import utils.RacingNumberGenerator;

public class Car implements Comparable<Car> {

    private final Name name;
    private final Position position;
    private final RacingNumberGenerator generator;

    public Car(String name, RacingNumberGenerator generator) {
        this.name = new Name(name);
        this.position = new Position();
        this.generator = generator;
    }

    public RacingCarStateDto race() {
        position.move(generateMovableNumber());
        return mapToRacingCarStateDto();
    }

    private int generateMovableNumber() {
        return generator.generate();
    }

    public boolean isSamePosition(Car otherCar) {
        return this.position.isSamePosition(otherCar.position);
    }

    private RacingCarStateDto mapToRacingCarStateDto() {
        return new RacingCarStateDto(name.getName(), position.getPosition());
    }

    public WinnerCarDto mapToWinnerCarDto() {
        return new WinnerCarDto(name.getName());
    }

    @Override
    public int compareTo(Car otherCar) {
        return this.position.compareTo(otherCar.position);
    }
}
