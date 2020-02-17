package controller;

import model.Car;
import model.Round;
import model.Winner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameManager {

    private static final String NO_NAME_ERROR_MESSAGE = "이름 입력값이 없습니다.";
    private static final String INVALID_NAME_ERROR_MESSAGE = "유효하지 않은 이름입니다.";
    private static final String NOT_INTEGER_ERROR_MESSAGE = "숫자가 아니라 문자입니다.";
    private List<Car> cars = new ArrayList<>();
    private Winner winner = new Winner();
    private Round round;

    public GameManager(String carNames, String round) {
        validateInput(carNames, round);
        initiateCars(carNames.split(","));
        this.round = new Round(Integer.parseInt(round));
    }

    private void initiateCars(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    static void validateInput(String carNames, String round) {
        checkCarNames(carNames);
        checkRound(round);
    }

    private static void checkRound(String round) {
        isInteger(round);
    }

    private static void isInteger(String round) {
        try {
            Integer.parseInt(round);
        } catch (Exception e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR_MESSAGE);
        }
    }

    private static void checkCarNames(String carNames) {
        ArrayList<String> tempCarNames = new ArrayList<>(Arrays.asList(carNames.split(",")));
        checkNameEmpty(tempCarNames);
    }

    private static void checkNameEmpty(ArrayList<String> tempCarNames) {
        if (tempCarNames.isEmpty()) {
            throw new IllegalArgumentException(NO_NAME_ERROR_MESSAGE);
        }
        tempCarNames.stream()
                .filter(x -> x.isEmpty())
                .forEach(x -> {
                    throw new IllegalArgumentException(INVALID_NAME_ERROR_MESSAGE);
                });
    }
//    private List<Car> cars = new ArrayList<>();
//    private Winner winner = new Winner();
//    private int round;
//    private static final int MIN_MOVE_NUMBER = 4;
//    static final int ZERO = 0;

//    private static String[] inputCarName() {
//        return InputView.inputCarName();
//    }
//
//    public void startGame() {
//        init();
//        run();
//        award();
//    }
//
//    public static void moveOrStay(Car car, int RandomNumber) {
//        if (RandomNumber >= MIN_MOVE_NUMBER) {
//            car.move();
//        }
//    }
//
//    private void init() {
////        setCarList(inputCarName());
////        setRound();
//    }
//
//    private void race(List<Car> cars) {
//        for (Car car : cars) {
//            moveOrStay(car, Dice.makeRandomNumber());
//        }
//    }
//
//    private void run() {
//        OutputView.printBeginResult();
//        for (int i = ZERO; i < round; i++) {
//            race(cars);
//            OutputView.printScore(cars);
//        }
//    }
//
//    private void award() {
//        winner.setWinner(cars);
//        OutputView.printWinners(winner.getWinners());
//    }
//
//    public List<Car> getCarList() {
//        return this.cars;
//    }
//
//    private void setRound() {
//        this.round = InputView.inputRound();
//    }
//
//    void setCarList(String[] carNames) {
//        for (String carName : carNames) {
//            this.cars.add(new Car(carName));
//        }
//    }
}
