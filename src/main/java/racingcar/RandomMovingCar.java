package racingcar;

public class RandomMovingCar implements Car {

    private final String name;

    public RandomMovingCar(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
