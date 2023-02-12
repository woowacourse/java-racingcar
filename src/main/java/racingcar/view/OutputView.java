package racingcar.view;

import racingcar.domain.record.GameResultOfCar;
import racingcar.view.message.Message;

import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {

    private static final int DEFAULT_ROUND = 0;

    public void printCarNameInputGuide() {
        print(Message.CAR_NAME_INPUT_GUIDE.getMessage());
    }

    public void printGameRoundGuide() {
        print(Message.GAME_ROUND_INPUT_GUIDE.getMessage());
    }

    public void printResultGuide() {
        print(Message.GAME_RESULT_GUIDE.getMessage());
    }

    public void printAllGameResults(Set<GameResultOfCar> gameResultOfAllCars) {
        printResultGuide();
        int gameRound = getFirstGameRound(gameResultOfAllCars);
        for (GameResultOfCar gameResultOfCar : gameResultOfAllCars) {
            printBlankLineBy(gameRound, gameResultOfCar);

            print(makeResultMessage(gameResultOfCar.getCarName(), gameResultOfCar.getPosition()));

            gameRound = gameResultOfCar.getGameRound();
        }
    }

    private int getFirstGameRound(Set<GameResultOfCar> gameResultOfAllCars) {
        return gameResultOfAllCars.stream()
                .map(GameResultOfCar::getGameRound)
                .min(Integer::compareTo)
                .orElse(DEFAULT_ROUND);
    }

    private void printBlankLineBy(int gameRound, GameResultOfCar gameResultOfCar) {
        if (gameRound != gameResultOfCar.getGameRound()) {
            print(Message.EMPTY_MESSAGE.getMessage());
        }
    }

    private String makeResultMessage(String carName, int position) {
        return String.format(Message.RESULT_DELIMITER.getMessage(), carName, makePositionMessage(position));
    }

    private String makePositionMessage(int position) {
        String positionMarker = Message.POSITION_MARKER.getMessage();
        return positionMarker.repeat(position);
    }

    public void printWinners(Set<GameResultOfCar> gameResultOfWinners) {
        print(makeWinnersMessage(gameResultOfWinners, Message.WINNER_DELIMITER.getMessage()));
    }

    private String makeWinnersMessage(Set<GameResultOfCar> gameResultOfWinners, String delimiter) {
        return String.format(Message.WINNER_GUIDE.getMessage(), makeWinnerNames(gameResultOfWinners, delimiter));
    }

    private String makeWinnerNames(Set<GameResultOfCar> gameResultOfWinners, String delimiter) {
        return gameResultOfWinners.stream()
                .map(GameResultOfCar::getCarName)
                .collect(Collectors.joining(delimiter));
    }

    private void print(String message) {
        System.out.println(message);
    }
}
