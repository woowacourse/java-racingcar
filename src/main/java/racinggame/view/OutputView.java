package racinggame.view;

import java.util.List;
import java.util.Map;

/**
 * OutputView 클래스는 메세지를 콘솔에 출력하 부분만 담당하는(MVC 구조에 View를 담당하는) 클래스이다.
 * OutputView 인스턴스를 만드는 것을 고려하지 않고 설계하였다.
 */
public class OutputView {
    private static final String NAME_FORMAT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";
    private static final String REPEAT_FORMAT = "시도할 회수는 몇회인가요?";
    private static final String RESULT_FORMAT = "\n실행 결과";
    private static final String WINNER_FORMAT = "가 최종 우승했습니다.";
    private static final String LOG_DELIMITER = " : ";
    private static final String POSITION_CHARACTER = "-";

    /**
     * 생성자 메서드는 호출되지 않는 것이 정상이므로 private으로 설정하였다.
     *
     * @throws AssertionError : 잘못된 선언이 발생할 경우 예외처리한다.
     */
    private OutputView() {
        throw new AssertionError();
    }

    public static void printWinners(List<String> names) {
        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println(WINNER_FORMAT);
    }

    /**
     * printNameFormat 은 이름을 입력받을 때 정해진 메세지를 출력해 주는 메서드이다.
     * InputView를 통해 호출된다.
     */
    public static void printNameFormat() {
        System.out.println(NAME_FORMAT);
    }

    /**
     * printRepeatFormat 은 게임 횟수를 입력받을 때 정해진 메세지를 출력해 주는 메서드이다.
     * InputView를 통해 호출된다.
     */
    public static void printRepeatFormat() {
        System.out.println(REPEAT_FORMAT);
    }

    /**
     * printResultFormat 은 게임의 진행과정을 출력하기 전에 메세지를 출력해주는 메서드이다.
     * RacingGame의 play 메서드에서 호출되고, 이후 printLog가 반복적으로 호출된다.
     */
    public static void printResultFormat() {
        System.out.println(RESULT_FORMAT);
    }

    public static void printLog(Map<String, Integer> status) {
        for (Map.Entry<String, Integer> entry : status.entrySet()) {
            int position = entry.getValue();
            System.out.print(entry.getKey() + LOG_DELIMITER);
            for (int i = 0; i < position; i++) {
                System.out.print(POSITION_CHARACTER);
            }
            System.out.println("");
        }
    }
}
