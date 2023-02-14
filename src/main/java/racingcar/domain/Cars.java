package racingcar.domain;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarDto;
import racingcar.util.IntGenerator;
import racingcar.util.RandomIntGenerator;

public class Cars {

    private static final int SINGLE_GENERATOR_SIZE = 1;

    private static final int INITIAL_WINNER_COUNT = 0;
    public static final String CAR_NAMES_AND_GENERATOR_NUMBER_MISMATCH_ANNOUNCEMENT = "[ERROR] 숫자 생성기가 1개가 아니라면, 자동차 이름의 수와 생성기의 수가 일치해야합니다.";

    private final List<Car> cars;

    public Cars(List<String> carNames, List<IntGenerator> intGenerators) {
        this.cars = new LinkedList<>();
        if (haveJustOneGenerator(intGenerators)) {
            carNames.forEach(carName -> cars.add(new Car(carName, new RandomIntGenerator())));
            return;
        }
        if (haveSameNumberOfGenerators(carNames, intGenerators)) {
            carNames.forEach(carName -> cars
                    .add(new Car(carName, intGenerators
                            .get(carNames
                                    .indexOf(carName)))));
            return;
        }
        throw new IllegalArgumentException(CAR_NAMES_AND_GENERATOR_NUMBER_MISMATCH_ANNOUNCEMENT);
    }

    private static boolean haveSameNumberOfGenerators(List<String> carNames, List<IntGenerator> intGenerators) {
        return carNames.size() == intGenerators.size();
    }

    private static boolean haveJustOneGenerator(List<IntGenerator> intGenerators) {
        return intGenerators.size() == SINGLE_GENERATOR_SIZE;
    }

    public void requestMoveEachCar() {
        cars.forEach(Car::tryMove);
    }

    public List<CarDto> getStatuses() {
        List<CarDto> carDtos = new LinkedList<>();
        cars.forEach(car -> carDtos.add(new CarDto(car)));
        return carDtos;
    }

    public List<CarDto> getWinner() {
        int winnerCount = cars.stream()
                .map(Car::getMovedCount)
                .max(Integer::compareTo)
                .orElse((INITIAL_WINNER_COUNT));
        List<CarDto> winners = cars.stream()
                .filter(car -> car.getMovedCount() == winnerCount)
                .map(CarDto::new)
                .collect(Collectors.toList());
        return winners;
    }




}
