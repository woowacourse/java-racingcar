package racingcar.view;

import racingcar.domain.CarDTO;
import racingcar.domain.CarsDTO;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * OutputView.java
 * 입력을 제외한 출력을 담당하는 View 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
    private static final String POSITION_FORMAT = "%s : %s";
    private static final String WINNERS_LIST = "최종 우승자 : ";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final char POSITION_CHARACTER = '-';

    public static void printErrorMessage(Exception e) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
    }

    public static void printResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public static void printCarsPosition(CarsDTO carsDTO) {
        carsDTO.toList().forEach(OutputView::printCarPosition);
        System.out.println();
    }

    private static void printCarPosition(CarDTO carDTO) {
        StringBuffer positionStringBuffer = new StringBuffer();
        for (int i = 0; i < carDTO.getPosition(); i++) {
            positionStringBuffer.append(POSITION_CHARACTER);
        }
        System.out.print(String.format(POSITION_FORMAT, carDTO.getName(), positionStringBuffer));
        System.out.println();   // 개행
    }

    public static void printWinners(List<String> winners) {
        Collections.sort(winners);
        System.out.print(WINNERS_LIST);

        Iterator<String> iterator = winners.iterator();
        System.out.print(iterator.next());
        while(iterator.hasNext()) {
            System.out.print(", " + iterator.next());
        }
    }
}
