package racingcar.domain.racing;


import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.numbergenerator.RandomNumberGenerator;

public class CarRacing {
    private final CarRepository carRepository;
    private final NumberApplicatorToCar numberApplicatorToCar;
    private final int totalRacingTryTime;
    private int currentRacingTime;

    public CarRacing(List<String> carNames, int totalRacingTryTime) {
        this.carRepository = new CarRepository();
        this.numberApplicatorToCar
            = new NumberApplicatorToCar(carRepository, new RandomNumberGenerator());
        this.totalRacingTryTime = totalRacingTryTime;
        this.currentRacingTime = 0;
        setCarsBeforeRacing(carNames);
    }

    private void setCarsBeforeRacing(List<String> carNames) {
        List<Car> cars = createCars(carNames);
        carRepository.saveAll(cars);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
            .map(Car::new)
            .collect(Collectors.toList());
    }

    public void raceOneTime() {
        numberApplicatorToCar.apply();
        currentRacingTime++;
    }

    public boolean isEnd() {
        return currentRacingTime == totalRacingTryTime;
    }
}
