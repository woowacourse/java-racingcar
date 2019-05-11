package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

import java.util.Objects;

public class Car {
    private static final int POSSIBLE_MOVE = 4;
    private static final int VALID_NAME_LENGTH = 5;
    /* String matches에 사용할 알파벳 REGEX 정의 */
    private static final String ALPHABET_REGEX = "^[a-zA-Z]*$";

    private final String name;
    private int position = 0;

    public Car(String name) {
        if (!this.isValidName(name)) {
            throw new IllegalArgumentException("이름이 잘 못 되었습니다.");
        }
        this.name = name.trim();
    }

    /* 테스트를 위한 생성자 */
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    private static boolean isValidName(String name) {
        return isNameNotBlank(name)
                && isNameConsistOfAlphabet(name.trim())
                && isNameRightLength(name.trim());
    }

    private static boolean isNameNotBlank(String name) {
        return !StringUtils.isBlank(name);
    }

    private static boolean isNameRightLength(String name) {
        return name.length() <= VALID_NAME_LENGTH;
    }

    private static boolean isNameConsistOfAlphabet(String name) {
        return name.matches(ALPHABET_REGEX);
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    public void move(int randomNumber) {
        if (randomNumber >= POSSIBLE_MOVE) {
            position++;
        }
    }

    int getMaxPosition(int maxPosition) {
        return Integer.max(this.position, maxPosition);
    }

    void checkWinner(WinningCars winningCars, int maxPosition) {
        if (isMaxPosition(maxPosition)) {
            winningCars.addWinner(this.name);
        }
    }

    public boolean isMaxPosition(int maxPosition){
        return this.position == maxPosition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" : ");
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return (position == car.position) &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
