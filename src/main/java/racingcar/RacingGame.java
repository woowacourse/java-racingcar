package racingcar;

import view.InputView;
import view.OutputView;

import java.util.Random;

public class RacingGame {

    private final Cars carList = new Cars();
    private int totalRound;

    private final static int FORWARD_CRITERION = 4;
    private final static int BOUNDARY_ZERO_TO_NINE = 10;
    private final static int NAME_LENGTH_LIMIT = 5;
    private final static Random RANDOM = new Random();

    public void start() {
        addCars(getCarNames());
        totalRound = getTotalRound();
        OutputView.printStartMessage();
        play();
        OutputView.printFinalWinner(carList.getWinnerList());
    }

    public Cars getCars() {
        return carList;
    }

    public void addCars(String[] carNames) {
        for(String carName : carNames){
            carList.addCar(new Car(carName));
        }
    }

    private void play() {
        for(int i = 0; i < totalRound; i++){
            playOneRound();
        }
    }

    private void playOneRound() {
        for(Car car : carList){

            car.randomForward(isMove(), carList);
            OutputView.printCar(car);
        }

        OutputView.printNewline();
    }

    public boolean checkStringLengthLimit(String string) {
        return string.length() <= NAME_LENGTH_LIMIT;
    }

    public String[] getCarNames() {
        String[] carNames = InputView.inputCarNames().split(",\\s*");

        for(String carName : carNames){
            if(!checkStringLengthLimit(carName)){
                OutputView.printNameLimit();
                return getCarNames();
            }
        }
        return carNames;
    }

    private int getTotalRound() {
        return Integer.parseInt(InputView.inputTotalRound());
    }

    private boolean isMove() {
        return (RANDOM.nextInt(BOUNDARY_ZERO_TO_NINE) >= FORWARD_CRITERION);
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }
}
