package racingcar.domain;

import java.util.LinkedList;
import java.util.List;
import racingcar.dto.CarDto;
import racingcar.util.IntGenerator;
import racingcar.util.RandomIntGenerator;

public class Cars {

    private static final int SINGLE_GENERATOR_SIZE = 1;

    private static final int INITIAL_WINNER_COUNT = 0;
    public static final String CAR_NAMES_AND_GENERATOR_NUMBER_MISMATCH_ANNOUNCEMENT = "[ERROR] 숫자 생성기가 1개가 아니라면, 자동차 이름의 수와 생성기의 수가 일치";

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = new LinkedList<>();
    }

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
        cars.forEach(car -> carDtos.add(car.getStatus()));
        return carDtos;
    }

    public List<CarDto> getWinner() {
        List<CarDto> carStatuses = this.getStatuses();
        int winnerCount = INITIAL_WINNER_COUNT;
        List<CarDto> winnerStatuses = new LinkedList<>();
        for (CarDto carStatus : carStatuses) {
            winnerCount = getMaxMovedCount(winnerCount, carStatus.getMovedCount());
        }
        for (CarDto carStatus : carStatuses) {
            appendIfHaveSameMovedCount(winnerStatuses, carStatus, winnerCount);
        }
        return winnerStatuses;
    }

    private int getMaxMovedCount(int winnerCount, int movedCount) {
        return Math.max(winnerCount, movedCount);
    }

    private void appendIfHaveSameMovedCount(List<CarDto> winners, CarDto carDto, int winnerCount) {
        if (carDto.getMovedCount() == winnerCount) {
            winners.add(carDto);
        }
    }

}
