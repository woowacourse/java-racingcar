package racingcargame.domain;

public class Car implements Comparable<Car> {
    public static final int ZERO = 0;
    public static final int NAME_UPPER_LIMIT = 5;
    public static final int GO_CONDITION = 4;
    private String name;
    private int position;

    public Car(String name) {
        validateNull(name);
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() <= ZERO || name.length() > NAME_UPPER_LIMIT) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하로 해주세요.");
        }
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("이름은 null값이 될 수 없습니다.");
        }
    }

    public void decideGoOrStop(int randomNumber) {
        if (randomNumber >= GO_CONDITION) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car c) {
        return c.getPosition() - getPosition();
    }
}
