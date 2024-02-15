package domain;

import util.Constants;

import java.util.Comparator;

import static util.Constants.MIN_FORWARD_NUMBER;
import static util.Exceptions.MAX_NAME_EXCEPTION;

public class Car implements Comparable<Car> {
    private final String name;
    private int forward;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
        this.forward = 0;
    }

    private void validateCarNameLength(String name) {
        if (name.length() > Constants.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_NAME_EXCEPTION.getMessage());
        }
    }

    // TODO: getName 삭제 제거 고려해보기
    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

    //TODO:number 변수명 변경하기
    public void drive(int number) {
        if (checkForward(number)) {
            forward += 1;
        }
    }

    private boolean checkForward(int number) {
        return number >= MIN_FORWARD_NUMBER;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(forward);
    }

    @Override
    public int compareTo(Car c) {
        return Integer.compare(c.forward, forward);
    }
}
