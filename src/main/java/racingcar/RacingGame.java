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

    public RacingGame() {
        addCars();
        totalRound = getTotalRound();
        OutputView.printStartMessage();
        play();
        OutputView.printFinalWinner(carList.getWinnerList());
    }

    public void addCars(){
        String[] carNames = getCarNames();
        for(String carName : carNames){
            carList.addCar(new Car(carName));
        }
    }

    public void play(){
        for(int i = 0; i < totalRound; i++){
            playOneRound();
        }
    }

    public void playOneRound(){
        for(Car car : carList){

            car.randomForward(isMove());
            int position = car.getPosition();
            OutputView.printCar(car);

            if(carList.getMaxPosition() < position){
                carList.setMaxPosition(position);
            }
        }

        OutputView.printNewline();
    }

    public boolean checkStringLengthLimit(String string){
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

    public int getTotalRound() {
        return Integer.parseInt(InputView.inputTotalRound());
    }

    public boolean isMove() {
        return (RANDOM.nextInt(BOUNDARY_ZERO_TO_NINE) >= FORWARD_CRITERION);
    }

    public static void main(String[] args) {
        new RacingGame();
    }
}
