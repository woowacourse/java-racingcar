package racingcar.domain;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int position = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car from(String name) {
        if (MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException("자동차 이름의 길이는 " + MAX_NAME_LENGTH + "자를 넘어가서는 안 됩니다.");
        }
        return new Car(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Car paramObj = (Car) obj;
        return this.name.equals(paramObj.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
