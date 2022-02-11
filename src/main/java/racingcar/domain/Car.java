package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Car {
    private static final String INFO_BETWEEN_WORD = " : ";
    private static final String POSITION_WORD = "-";
    private static final int RANDOM_MAX_RANGE = 10;
    private static final int RANDOM_CONDITION = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    private int getPosition() {
        return position;
    }

    public void goForward() {
        Random random = new Random();

        if (random.nextInt(RANDOM_MAX_RANGE) >= RANDOM_CONDITION) {
            position += 1;
        }
    }

    public static int getWinnerPosition(List<Car> cars) {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(RuntimeException::new)
                .position;
    }

    public boolean isWinner(int winnerPosition) {
        if (position == winnerPosition) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String info = name + INFO_BETWEEN_WORD;

        for (int i = 0; i < position; i++) {
            info += POSITION_WORD;
        }

        return info;
    }
}
