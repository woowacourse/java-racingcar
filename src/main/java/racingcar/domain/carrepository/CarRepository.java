package racingcar.domain.carrepository;

import racingcar.domain.car.Car;
import racingcar.domain.numbergenerator.NumberGenerator;

다import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRepository {

    private final List<Car> repository;

    public CarRepository(List<Car> repository) {
        this.repository = repository;
    }

    private void validate(List<Car> repository) {
        if (isOutOfSize(repository)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 2대 이상 입력되어야 합니다.");
        }
        if (hasDuplication(repository)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }

    private boolean hasDuplication(List<Car> repository) {
        return repository.stream()
                .distinct()
                .count() != repository.size();
    }

    private boolean isOutOfSize(List<Car> repository) {
        return repository.size() < 2;
    }

    public void movePosition() {
        NumberGenerator numberGenerator = new NumberGenerator();
        for (Car car : repository) {
            int randomNumber = numberGenerator.generateRandomNumber();
            judgeMovement(randomNumber, car);
        }
    }

    private void judgeMovement(int randomNumber, Car car) {
        if (randomNumber >= 4) {
            car.updatePosition();
        }
    }

    public List<Car> getRepository() {
        return repository;
    }

    public List<String> findWinner() {
        int maxPosition = repository.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(x -> x))
                .orElseThrow(NoClassDefFoundError::new);

        return repository.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
