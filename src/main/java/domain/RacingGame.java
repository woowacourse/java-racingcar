package domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    private final static int MIN_MOVE_NUMBER = 4;
    private final static int GAME_OVER_COUNT = 0;

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;
    
    private int gameTrial;
    

    public RacingGame(List<Car> cars, int gameTrial, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.gameTrial = gameTrial;
        this.numberGenerator = numberGenerator;
    }

    public List<Car> run() {
        start();
        finish();
        return cars;
    }

    private void start() {
        cars.stream()
                .filter(car -> car.canMove(numberGenerator.generate(), MIN_MOVE_NUMBER))
                .forEach(car -> car.move());
    }

    private void finish() {
        gameTrial--;
    }

    public List<Car> getWinners() {
        int maxMoveCount = getMaxMoveCount();
        return cars.stream()
                .filter(car -> car.isWinner(maxMoveCount))
                .collect(Collectors.toList());
    }

    public boolean canContinue() {
        return gameTrial == GAME_OVER_COUNT;
    }

    private int getMaxMoveCount() {
        return cars.stream()
                .mapToInt(car -> car.getMoveCount())
                .max()
                .getAsInt();
    }
}
