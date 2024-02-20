package model;

import message.Exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private final List<MoveStatus> statuses;

    public Car(String name) {
        validateNullAndEmpty(name);
        validateNameLength(name);
        this.name = name;
        this.statuses = new ArrayList<>();
    }

    public static List<Car> convertToCar(List<String> carsName) {
        validateNotDuplicate(carsName);
        return carsName.stream().map(Car::new).toList();
    }

    private static void validateNotDuplicate(List<String> carsName) {
        int originCount = carsName.size();
        int distinctCount = (int) carsName.stream().distinct().count();
        if (originCount != distinctCount) {
            throw new IllegalArgumentException(Exception.DUPLICATE.getMessage());
        }
    }

    private void validateNullAndEmpty(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException(Exception.CAR_NAME_NULL_BLANK.getMessage());
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(Exception.CAR_NAME_LENGTH.getMessage());
        }
    }

    public void forward() {
        statuses.add(MoveStatus.FORWARD);
    }

    public void stop() {
        statuses.add(MoveStatus.STOP);
    }

    public int getForwardCount() {
        return (int)
                statuses.stream().filter(carStatus -> carStatus.equals(MoveStatus.FORWARD)).count();
    }

    public List<MoveStatus> getStatuses() {
        return new ArrayList<>(statuses);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(statuses, car.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, statuses);
    }
}
