package domain;

public class Car {
    public static final int MAX_NAME_LEN = 5;

    private final String name;
    private int position;

    public Car(String name, int position) {
        if (name == null) {
            throw new IllegalArgumentException("name 이 null 입니다.");
        }
        if (name.length() == 0) {
            throw new IllegalArgumentException("name 이 빈문자열입니다.");
        }
        if (MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException(
                    String.format("입력된 이름의 길이가 너무 깁니다. %d 자 이하로 입력해주세요. (in: %s)", MAX_NAME_LEN, name));
        }

        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    public MovedCar move() {
        position++;
        return new MovedCar(name, position);
    }

    public MovedCar getMovedCar() {
        return new MovedCar(name, position);
    }

    public String getName() {
        return name;
    }
}
