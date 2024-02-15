package domain;

public class Car {
    private static final int MOVE_BOUND_NUMBER = 4;

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
        if (numberGenerator.generate() >= MOVE_BOUND_NUMBER) {
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
