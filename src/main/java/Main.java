import controller.GamePlay;
import domain.Cars;
import genertor.NumberGenerator;
import genertor.RandomNumberGenerator;
import service.CarFactory;
import view.InputView;

public class Main {

    public static void main(String[] args) {
        Cars cars = new Cars(CarFactory.buildCars(InputView.inputCarNames()));
        NumberGenerator numberGenerator = new RandomNumberGenerator();

        GamePlay gamePlay = new GamePlay(cars, numberGenerator);
        gamePlay.gameStart();
    }
}
