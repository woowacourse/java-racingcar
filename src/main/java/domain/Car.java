package domain;

public class Car {

    private static final int THRESHOLD = 4;
    private static final int DEFAULT_INITIAL_POSITION = 0;
    private static final int CAR_NAME_LENGTH_LOWER_BOUND_INCLUSIVE = 1;
    private static final int CAR_NAME_LENGTH_UPPER_BOUND_INCLUSIVE = 5;

    private static final String CAR_NAME_LENGTH_ERROR = "자동차명은 1 ~ 5 글자로 입력해야합니다.";

    private final String name;
    private int distance;

    public Car(String name) {
        this(name, DEFAULT_INITIAL_POSITION);
    }

    public Car(String name, int distance) {
        String validCarName = validateCarNamesLength(name);
        this.name = validCarName;
        this.distance = distance;
    }

    private String validateCarNamesLength(String name) {
        name = name.trim();

        if (!(CAR_NAME_LENGTH_LOWER_BOUND_INCLUSIVE <= name.length()
                && name.length() <= CAR_NAME_LENGTH_UPPER_BOUND_INCLUSIVE)) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }

        return name;
    }

    public void move(int power) {
        if (power >= THRESHOLD) {
            this.distance++;
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }

    public boolean isSameDistance(int distance) {
        return this.distance == distance;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Car
                && ((Car) object).getName()
                .equals(this.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
