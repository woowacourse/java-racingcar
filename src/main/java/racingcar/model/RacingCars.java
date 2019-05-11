package racingcar.model;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCars {
    private static final String RACING_CAR_DUPLICATE_MENT = "자동차의 이름은 중복될 수 없습니다.";
    private static final String RACING_CAR_SIZE_ERROR_MENT = "1개 이상의 차 이름을 입력해 주세요";
    private static final String COMMA = ",";
    private static final int RACING_CAR_SIZE_MIN_BOUND = 1;
    private static final int MAX_BOUND = 10;

    private final List<Car> racingCars;

    public RacingCars(String InputRacingCarNames) {
        List<String> racingCarNames = convertFromStringToList(InputRacingCarNames);
        validateDuplicate(racingCarNames);
        validateSize(racingCarNames);
        this.racingCars = getRacingCar(racingCarNames);
    }

    public RacingCars(List<Car> cars) {
        this.racingCars = cars;
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

    private List<String> convertFromStringToList(String racingcarNames) {
        return Arrays.asList(racingcarNames.split(COMMA));
    }

    private void validateSize(List<String> racingCarNames) {
        if (racingCarNames.size() < RACING_CAR_SIZE_MIN_BOUND) {
            throw new IllegalArgumentException(RACING_CAR_SIZE_ERROR_MENT);
        }
    }

    private void validateDuplicate(List<String> racingCarNames) {
        Set<String> nonDuplicateNames = new HashSet<>(racingCarNames);
        if (nonDuplicateNames.size() != racingCarNames.size()) {
            throw new IllegalArgumentException(RACING_CAR_DUPLICATE_MENT);
        }
    }

    private List<Car> getRacingCar(List<String> racingCarNames) {
        List<Car> cars = new ArrayList<>();
        racingCarNames.forEach(convertedRacingCarName -> cars.add(new Car(convertedRacingCarName)));
        return cars;
    }

    public Car getMaxPositionCar() {
        Collections.sort(racingCars);
        return racingCars.get(0);
    }

    public List<String> getCarNames() {
        return racingCars.stream()
                .map(car -> car.getName())
                .collect(Collectors.toList());
    }

    public RacingCars moveRacingCars() {
        for (Car racingCar : racingCars) {
            racingCar.move(getRandomNumber());
        }
        return this;
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public List<String> getCurrentPositionsOfRacingCars() {
        List<String> currentPositions = new ArrayList<>();
        for (Car racingCar : racingCars) {
            currentPositions.add(racingCar.getCurrentPosition());
        }
        return currentPositions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(racingCars, that.racingCars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingCars);
    }
}
