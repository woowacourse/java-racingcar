package racingcar.domain;

public class Car {
    public static final String NAME_MUSTBE_1TO5 = "이름은 1자 이상 5자 이하여야 합니다.";
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException(NAME_MUSTBE_1TO5);
        }
        this.name = name;
    }

    public void proceed() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
