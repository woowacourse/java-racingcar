package racingcar.domain.racing;


import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.numbergenerator.NumberGenerator;
import racingcar.view.CarRacingInputs;

public class CarRacing {
    private final Cars cars;
    private final NumberGenerator numberGenerator;
    private final int totalRacingTryTime;
    private int finishedRacingTime;

    public CarRacing(CarRacingInputs carRacingInputs, NumberGenerator numberGenerator) {
        this.cars = new Cars();
        this.numberGenerator = numberGenerator;
        this.totalRacingTryTime = carRacingInputs.getRacingTryTime();
        this.finishedRacingTime = 0;
        setCarsByCarNamesBeforeRacing(carRacingInputs.getCarNames());
    }

    private void setCarsByCarNamesBeforeRacing(List<String> carNames) {
        cars.createCarsByCarNames(carNames);
    }

    public void raceOneTime() {
        applyGeneratedNumbersToCars();
        finishedRacingTime++;
    }

    private void applyGeneratedNumbersToCars() {
        List<Car> allCars = cars.getAllCars();
        for (Car car : allCars) {
            int generatedCar = numberGenerator.generate();
            car.goForwardDependsOnNumber(generatedCar);
        }
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
