package racingcar.domain.racing;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.CarRacingRequestDto;
import racingcar.numbergenerator.NumberGenerator;

public class CarRacing {
    private final Cars cars;
    private final NumberApplicatorToCar numberApplicatorToCar;
    private final int totalRacingTryTime;
    private int finishedRacingTime;

    public CarRacing(CarRacingRequestDto carRacingRequestDto, NumberGenerator numberGenerator) {
        this.cars = new Cars();
        this.numberApplicatorToCar
            = new NumberApplicatorToCar(cars, numberGenerator);
        this.totalRacingTryTime = carRacingRequestDto.getRacingTryTime();
        this.finishedRacingTime = 0;
        setCarsByCarNamesBeforeRacing(carRacingRequestDto.getCarNames());
    }

    private void setCarsByCarNamesBeforeRacing(List<String> carNames) {
        cars.createCarsByCarNames(carNames);
    }

    public void raceOneTime() {
        numberApplicatorToCar.apply();
        finishedRacingTime++;
    }

    public boolean isEnd() {
        return finishedRacingTime == totalRacingTryTime;
    }

    public List<Car> getCars() {
        return cars.getAllCars();
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }
}
