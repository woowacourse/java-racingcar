import racingCar.Car;
import racingCar.Cars;
import utils.RandomUtils;
import view.InputView;
import view.OutputView;

public class RacingCarGameMain {
    private static final int MINIMUM_VALUE = 0;
    private static final int MAXIMUM_VALUE = 9;

    public static void main(String[] args) {
        String input = InputView.getInput();
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            Cars.carAdd(new Car(carName));
        }
        playGame(InputView.getTryNumber());
        OutputView.showResult();
    }

    private static void playGame(int count) {
        for (int i = 0; i < count; i++) {
            moveCar();
        }
    }

    private static void moveCar() {
        for (int i = 0; i < Cars.getSize(); i++) {
            Cars.getCars()
                    .get(i)
                    .move(RandomUtils.nextInt(MINIMUM_VALUE, MAXIMUM_VALUE));
        }
        OutputView.showStatus();
    }
}
