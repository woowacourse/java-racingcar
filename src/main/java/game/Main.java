package game;

import game.input.UserInput;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String[] carNames;
        List<Car> cars;
        int maxInstance;

        do {
            carNames = game.splitWithComma(UserInput.inputCarNames());
        } while (!game.checkCarNamesLength(carNames));

        cars = game.createCarObject(carNames);
        maxInstance = UserInput.inputGameCount();


    }
}
