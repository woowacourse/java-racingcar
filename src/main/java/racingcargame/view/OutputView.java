package racingcargame.view;

import racingcargame.model.CarVO;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OutputView {
    private static final String CAR_NAMES_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACE_PROGRESS_GUIDE_MESSAGE = "실행 결과";
    private static final String RACE_PROGRESS_OUTPUT_SEPARATOR = " : ";
    private static final String GAME_WINNER_MESSAGE = "가 최종 우승했습니다.";
    private static final String RACE_MOVE = "-";
    private static final String WINNERS_OUTPUT_DELIMITER = ", ";
    private static final int EMPTY = 1;

    private OutputView() {
    }

    public static void showCarNamesInputGuideMessage() {
        print(CAR_NAMES_INPUT_GUIDE_MESSAGE);
    }

    public static void showRaceCountInputGuideMessage() {
        print(RACE_COUNT_INPUT_GUIDE_MESSAGE);
    }

    public static void showRaceProgressGuideMessage() {
        print(RACE_PROGRESS_GUIDE_MESSAGE);
    }

    public static void showRaceProgress(List<CarVO> carsInformation) {
        for (CarVO carVO : carsInformation) {
            print(carVO.getName() + RACE_PROGRESS_OUTPUT_SEPARATOR + showMove(carVO.getPosition()));
        }
        newLine();
    }

    public static String showMove(int moveCount) {
        StringBuilder move = new StringBuilder();
        move.append(RACE_MOVE.repeat(Math.max(0, moveCount)));
        return move.toString();
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void newLine() {
        System.out.println();
    }

    public static void showGameWinner(List<String> winners) {
        Queue<String> winner = new LinkedList<>();
        winners.forEach(wr -> winner.add(wr));

        while (winner.size() > EMPTY) {
            System.out.print(winner.poll() + WINNERS_OUTPUT_DELIMITER);
        }
        System.out.print(winner.poll() + GAME_WINNER_MESSAGE);
    }
}
