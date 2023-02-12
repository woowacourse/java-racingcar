package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.domain.RandomNumberGenerator.generateNumber;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars(String carNames) {
        String[] splitCarNames = stripStringArray(carNames);
        validation(splitCarNames);
        // TODO: 스트림으로 바꾸기
        for (String name : splitCarNames) {
            cars.add(new Car(name));
        }
    }

    public String[] stripStringArray(String names) {
        return names.split(",");
    }

    public void moveCars() {
        for (Car car : this.cars) {
            car.tryMove(generateNumber(0, 9));
        }
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private void validation(String[] names) {
        if (isDuplication(names)) {
            throw new IllegalArgumentException("자동차 이름은 중복이 불가능 합니다.");
        }
        if (isNotInRange(names)) {
            throw new IllegalArgumentException("자동차는 두개 이상 입력해야 합니다.");
        }
    }

    private boolean isDuplication(String[] names) {
        return Arrays.stream(names).distinct().count() != names.length;
    }

    private boolean isNotInRange(String[] names) {
        return names.length < 2;
    }

}
