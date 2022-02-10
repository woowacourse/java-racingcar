package racingcargame.view;

import racingcargame.model.CarVO;

import java.util.List;

public class OutputView {
    private static final String CAR_NAMES_INPUT_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_INPUT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RACE_PROGRESS_GUIDE_MESSAGE = "실행 결과";
    private static final String RACE_PROGRESS_OUTPUT_SEPARATOR = " : ";

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
        for (int count = 0; count < moveCount; count++) {
            move.append("-");
        }
        return move.toString();
    }
    
    private static void print(String message) {
        System.out.println(message);
    }

    private static void newLine() {
        System.out.println();
    }
}
