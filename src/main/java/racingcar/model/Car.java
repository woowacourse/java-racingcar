package racingcar.model;

import org.junit.platform.commons.util.StringUtils;

import java.util.List;
import java.util.Objects;

public class Car {
    private static final int POSSIBLE_MOVE = 4;
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("공백 이름은 사용할 수 없습니다.");
        }

        this.name = name.trim();
    }

    /* 테스트를 위한 생성자 */
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= POSSIBLE_MOVE) {
            position++;
        }
    }

    public void addWinners(List<String> winnerList, int maxPosition) {
        if (this.getPosition() == maxPosition) {
            winnerList.add(this.getName());
        }
    }

    public int getMaxPosition(int maxPosition) {
        return Integer.max(this.position, maxPosition);
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
