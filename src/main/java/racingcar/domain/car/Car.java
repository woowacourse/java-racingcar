package racingcar.domain.car;

import racingcar.domain.car.condition.ForwardCondition;
import racingcar.domain.car.validator.CarValidator;

public class Car {

    private final String name;
    private int location;

    public Car(final String name) {
        CarValidator.validateName(name);
        this.name = name;
    }

    public boolean isPossibleToGoForward(final int number) {
        return ForwardCondition.isSatisfied(number);
    }

    public void goForward() {
        this.location++;
    }

    public boolean isLocationSameWith(final int location) {
        return this.location == location;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

}
