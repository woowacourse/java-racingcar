package domain;

import validation.CarValidator;
import validation.ValidateResult;
import validation.exception.ContainsInvalidWordException;
import validation.exception.InvalidCarNameException;

public class Car {

    private final Name name;
    private int drivenDistance = 0;

    public Car(String name, int order) {
        ValidateResult validateResult = CarValidator.validate(name);
        if (validateResult == ValidateResult.FAIL_INVALID_LENGTH) {
            throw new InvalidCarNameException();
        }
        if (validateResult == ValidateResult.FAIL_CONTAIN_IDENTIFIER) {
            throw new ContainsInvalidWordException();
        }
        this.name = new Name(name, order);
    }

    public void drive(int distance) {
        drivenDistance += distance;
    }

    public int getDrivenDistance() {
        return drivenDistance;
    }

    public String getName() {
        return name.getName();
    }

    public int getIdentifier() {
        return name.getIdentifier();
    }
}
