package domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        validate(name);
        position = 0;
        this.name = name;
    }

    private static void validate(String name) {
        // TODO: 자동차 이름 검증
    }

    public void execute(int number) {
        if (number >= 4) {
            this.move();
        }
    }

    private void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

}
