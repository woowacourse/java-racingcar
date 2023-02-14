package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {
    private static final int MINIMUM_CARS_COUNT = 2;
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        validateCarsCount(cars.size());
        this.cars = new ArrayList<>(cars);
    }

    public void moveCars(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator));
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    /**
     * TODO: RacingCar 생성자에서 List<Car>을 인자로 전달받을때 방어적 복사를 통해 저장하였습니다.
     * <p>
     * 또, Stream의 collect(Collectors.toUnmodifiableList()) 의 경우,
     * Collections.unmodifiableList() 메서드가 원본 객체 잠조를 그대로 가져오는 것에 반해
     * 스트림의 요소들로 새로운 ArrayList<>를 생성하는 것과 같이 원본 객체에 대한 참조가 끊겼습니다.
     * <p>
     * <p>
     * 그럼에도 불구하고  pickWinnerCarNames()메서드가 List를 반환할 때, 아래와 같이 새 리스트를 생성하는 방어적 복사를 하는 것이 적합할까요?
     * 아니면 반환값을 받는 메서드에서 방어적 복사를 하라는 말인가요?
     * <p>
     * 또, List<> 형태로 반환하는 메서드는 모두 방어적 복사를 이용해야 하는 것인지요?
     */
    public List<String> pickWinnerCarNames() {
        Car winner = pickMaxPositionCar();

        List<String> winnerCarNames = cars.stream()
                .filter(car -> car.isSamePosition(winner))
                .map(Car::getName)
                .collect(Collectors.toUnmodifiableList());

        return new ArrayList<>(winnerCarNames);
    }

    private Car pickMaxPositionCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("비교할 자동차가 없습니다."));
    }

    private void validateCarsCount(int size) {
        if (size < MINIMUM_CARS_COUNT) {
            throw new IllegalArgumentException("자동차 수는 2대 이상이어야 합니다.");
        }
    }
}
