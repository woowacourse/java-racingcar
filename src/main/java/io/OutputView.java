package io;

import domain.Car;

import java.util.List;
import java.util.StringJoiner;

/**
 * TODO: 매직 리터럴 제거(O)
 * 출력되는 메시지 이외에 "-", " ,", "%s : %s"와 같은 딜리미터는 매직 리터럴로 간주됨
 * 메시지는 "실행 결과" 등과 같이 어떤 내용을 출력하는 지 문자열의 값 자체에서 표시하고 있지만
 * delimiter 등에 해당하는 -와 , 등의 문자는 어떤 의미를 가지는 지 네이밍을 통해 알려주면 가독성에 도움이 되겠다고 생각됨.
 */
public class OutputView {
    private static final String CAR_POSITION_MESSAGE = "%s : %s";
    private static final String CAR_POSITION_BAR = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printMoveResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printCarsPosition(final List<Car> cars) {
        for (Car car : cars) {
            String positionBar = createPositionBar(car.getPosition());
            System.out.println(String.format(CAR_POSITION_MESSAGE, car.getName(), positionBar));
        }
        System.out.println();
    }

    private String createPositionBar(int position) {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < position; i++) {
            positionBar.append(CAR_POSITION_BAR);
        }
        return positionBar.toString();
    }

    public void printWinners(List<String> winners) {
        StringJoiner winnerJoiner = new StringJoiner(WINNER_DELIMITER);
        for (String winner : winners) {
            winnerJoiner.add(winner);
        }

        System.out.println(String.format("%s가 최종 우승했습니다.", winnerJoiner));
    }
}
