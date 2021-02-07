package car;

import java.util.*;

public class OutputView {

    private static final String MOVE_SYMBOL = "-";
    private static final String NULL_CHARACTER = "\0";
    private static final String FINAL_WINNERS = "가 최종 우승했습니다.";
    private static final String DELIMITER = ",";
    private static final String COLON = " : ";
    private static final String ROUND_RESULT = "실행 결과";

    public void roundStart() {
        System.out.println(ROUND_RESULT);
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            String movedDistance = repeat(car.getPosition());
            System.out.println(car.getName() + COLON + movedDistance);
        }

        System.out.println();
    }

    private String repeat(int times) {
        return new String(new char[times]).replace(NULL_CHARACTER, MOVE_SYMBOL);
    }

    public void printWinners(List<Car> cars) {
        System.out.println(findWinners(cars) + FINAL_WINNERS);
    }

    private String findWinners(List<Car> cars) {
        final Map<Integer, List<String>> scoreBoard = new HashMap<>();

        for (Car racingCar : cars) {
            final List<String> names =
                scoreBoard.computeIfAbsent(racingCar.getPosition(), ArrayList::new);
            names.add(racingCar.getName());
        }

        final int maxPosition = Collections.max(scoreBoard.keySet());

        return String.join(DELIMITER, scoreBoard.get(maxPosition));
    }
}
