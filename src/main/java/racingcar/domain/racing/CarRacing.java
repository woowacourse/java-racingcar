package racingcar.domain.racing;


import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarRepository;
import racingcar.dto.CarRacingRequestDto;
import racingcar.numbergenerator.NumberGenerator;

public class CarRacing {
    private final CarRepository carRepository;
    private final NumberApplicatorToCar numberApplicatorToCar;
    private final int totalRacingTryTime;
    private int currentRacingTime;

    public CarRacing(CarRacingRequestDto carRacingRequestDto, NumberGenerator numberGenerator) {
        this.carRepository = new CarRepository();
        this.numberApplicatorToCar
            = new NumberApplicatorToCar(carRepository, numberGenerator);
        this.totalRacingTryTime = carRacingRequestDto.getRacingTryTime();
        this.currentRacingTime = 0;
        setCarsBeforeRacing(carRacingRequestDto.getCarNames());
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

    public List<Car> getCars() {
        return carRepository.getAllCars();
    }

    public List<Car> getWinners() {
        List<Car> allCars = carRepository.getAllCars();
        int maxPosition = getMaxPosition(allCars);

        return allCars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(IllegalArgumentException::new);
    }
}
