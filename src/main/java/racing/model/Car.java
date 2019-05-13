package racing.model;


import java.util.Objects;

public class Car {
    private static final int BOUNDARY = 4;
    private static final int NAME_LENGTH_LIMIT_TOP = 5;
    private static final int NAME_LENGTH_LIMIT_BOTTOM = 1;

    private String name;
    private int position = 0;

    public Car(String name) throws Exception {
        if (name.length() > NAME_LENGTH_LIMIT_TOP || name.length() < NAME_LENGTH_LIMIT_BOTTOM)
            throw new Exception();
        this.name = name;
    }

    public void move(int randomNumber) {
        if (randomNumber >= BOUNDARY)
            position++;
    }

    public String statusString() {
        String carPositionString = name + " : ";
        for (int i = 0; i < position; i++) {
            carPositionString += '-';
        }

        return carPositionString;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


    public int compareTo(Car o2) {
        if (this.position == o2.position) {
            return 0;
        }
        if (this.position > o2.position) {
            return 1;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
