package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final int NO_CARS_IN_GAME = 0;
    private static final int NO_DUPLICATE = 0;

    private ArrayList<Car> carsInGame = new ArrayList<Car>();

    public Cars(String[] carNames) {
        this(carNames, new int[carNames.length]);
    }

    public Cars(String[] carNames, int[] distance) {
        validateCarNames(carNames);
        for (int i = 0; i < carNames.length; i++) {
            carsInGame.add(new Car(carNames[i], distance[i]));
        }
    }
    
    private void validateCarNames(final String[] carNames) {
        validateCarNamesEmpty(carNames);
        validateCarNamesDuplicate(carNames);
    }

    private void validateCarNamesEmpty(final String[] carNames) {
        if (carNames.length == NO_CARS_IN_GAME) {
            throw new IllegalArgumentException("[Error] 최소 하나의 자동차 이름을 입력하세요.\n");
        }
    }

    private void validateCarNamesDuplicate(final String[] carNames) {
        List<String> checkDuplicate = Arrays.asList(carNames);
        int duplicate = checkDuplicate.stream()
                .filter(i -> Collections.frequency(checkDuplicate, i) > 1)
                .collect(Collectors.toSet()).size();

        if (duplicate != NO_DUPLICATE) {
            throw new IllegalArgumentException("[Error] 자동차 이름이 중복됩니다.\n");
        }
    }

    public ArrayList<Car> getCars() {
        return carsInGame;
    }

    public String getWinner(final int maxDistance) {
        ArrayList<String> winners = new ArrayList<String>();
        carsInGame.stream()
                .filter(it -> it.isWinner(maxDistance))
                .forEach(it -> winners.add(it.getCarName()));
        return String.join(",", winners);
    }
}


