package game;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        String[] carNames = game.carNameGenerator();
        List<Car> carList = game.createCarObject(carNames);
        int gameCount = game.inputGameCount();


    }

}
