package service;

import domain.Car;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Random;

public class GameManager {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CarRepository carRepository = new CarRepository();

    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int START_INDEX = 0;


    public void play() {
        creatCar();
        int count = checkInputCountProgram();
        outputView.resultMessage();
        for (int index = START_INDEX; index < count; index++) {
            playUnit();
            outputView.space();
        }
        outputView.printWinners(winners());
    }

    public void creatCar() {
        String[] inputCars = checkInputCarNameProgram();
        for (String carName : inputCars) {
            carRepository.saveCar(new Car(carName));
        }
    }

    private void playUnit() {
        powerInjectionAllCars();
        printStatus();
    }

    private List<String> winners() {
        return carRepository.selectWinners();
    }


    private void printStatus() {
        for (String carName : carRepository.carNames()) {
            outputView.printStatus(carName, carRepository.findPositionByName(carName));
        }
    }

    public void powerInjectionAllCars() {
        for (String carName : carRepository.carNames()) {
            carRepository.poweInjectionByName(carName, initRandomNumber());
        }
    }


    private int initRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_RANGE);
    }

    private String[] checkInputCarNameProgram() {
        while (true) {
            try {
                return inputView.inputCarsName();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int checkInputCountProgram() {
        while (true) {
            try {
                return inputView.inputCount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
