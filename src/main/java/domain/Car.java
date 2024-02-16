package domain;

public class Car {
    private static final int MOVE_BOUND_NUMBER = 4;
    private static final int MIN_NUMBER_RANGE = 0;
    private static final int MAX_NUMBER_RANGE = 9;

    private final Name name;
    private int position;

    public Car(Name name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car from(String name) {
        return new Car(Name.from(name), 0);
    }

    public void move(NumberGenerator numberGenerator) {
        if (numberGenerator.generateRangeOf(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE) >= MOVE_BOUND_NUMBER) {
            position++;
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
