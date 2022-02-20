package racingcar.model;

import racingcar.utils.generator.NumberGenerator;
import racingcar.utils.validator.NameValidator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        NameValidator.validateName(name);
        this.name = name;
    }

    public void forward(NumberGenerator numberGenerator) {
        int number = numberGenerator.generate();
        if (number >= 4) {
            this.position += 1;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isSamePositionWith(int position) {
        return this.position == position;
    }
}
