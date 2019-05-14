package racinggame;

import racinggame.view.UserInput;
import racinggame.view.ResultOutput;

import java.util.ArrayList;
import java.util.List;

import static racinggame.CarsName.makeCarsName;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        List<Car> cars = new ArrayList<>();

        String[] carsName = makeCarsName();
        int gameCount = UserInput.inputGameCount();

        for (String carName : carsName) {
            cars.add(new Car(carName));
        }

        cars = game.playGames(cars, gameCount);
        Winner winners = new Winner(cars);

        ResultOutput.winnersOutput(winners.getWinners());
    }

}