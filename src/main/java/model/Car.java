package model;

public class Car {

    private static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이는 1~5 글자여야 합니다.";
    private final String name;

    public Car(String name) {

        this.name = name;
    }

    static void validateName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }

    }


//    private String name;
//    private static final int MAX_NAME_LENGTH = 5;
//    private static final int ONE_STEP = 1;
//    private int position = 0;
//
//    public Car(String name) {
//        this.name = name;
//    }
//
//    public static void validateName(String name) {
//        try {
//            if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
//                throw new IllegalArgumentException(ValidationView.NAME_LENGTH_ERROR_MESSAGE);
//            }
//        } catch (NullPointerException e) {
//            ValidationView.printNullPointerException();
//        }
//    }
//
//
//    public void move() {
//        position += ONE_STEP;
//    }
//
//    public boolean isMaxPosition(int MaxPosition) {
//        return MaxPosition == position;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPosition() {
//        return position;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Car car = (Car) o;
//        return Objects.equals(name, car.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
