package racing.domain;

public class Car implements Comparable<Car> {

    private static final int MOVE_CONDITION = 4;

    private final String name;
    private int position = 0;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름이 "+ name.length()+"자 입니다. "+"이름은 5자 이하로 가능합니다.");
        }
    }

    public void move(int number) {
        if (number >= MOVE_CONDITION) {
            addPosition();
        }
    }

    private void addPosition() {
        position++;
    }

    public boolean isSamePosition(Car other) {
        return this.position == other.position;
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
