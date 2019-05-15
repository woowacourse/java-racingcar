package racingcar;

import java.util.Random;

public class RacingGame {

    private final Cars cars = new Cars();
    private int totalRound;

    private final static int FORWARD_CRITERION = 4;
    private final static int BOUNDARY_ZERO_TO_NINE = 10;
    private final static Random RANDOM = new Random();

    public void start() {
        addCars(InputView.inputCarNames());
        totalRound = InputView.inputTotalRound();
        OutputView.printStartMessage();
        play();
        OutputView.printFinalWinner(cars.getWinnerList());
    }

    public Cars getCars() {
        return cars;
    }

    public void addCars(String[] carNames) {
        for(String carName : carNames){
            cars.addCar(new Car(carName));
        }
    }

    private void play() {
        for(int i = 0; i < totalRound; i++){
            playOneRound();
        }
    }

    private void playOneRound() {
        for (Car car : cars) {
            car.randomForward(isMove(), cars);
            OutputView.printCar(car);
        }

        OutputView.printNewline();
    }

    private boolean isMove() {
        return (RANDOM.nextInt(BOUNDARY_ZERO_TO_NINE) >= FORWARD_CRITERION);
    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        racingGame.start();
    }
}
