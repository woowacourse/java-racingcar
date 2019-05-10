package domain;

import java.util.Comparator;

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

    public String getName() {
        return name;
    }

    public String getStatusString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" : ");

        for (int i = 0; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }

    public static Comparator<Car> compareByPosition = new Comparator<Car>() {
        @Override
        public int compare(Car o1, Car o2) {
            return o1.position - o2.position;
        }
    };

    public void move() {
        position++;
    }
}
