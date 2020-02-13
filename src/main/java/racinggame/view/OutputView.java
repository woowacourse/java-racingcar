package racinggame.view;

/**
 * OutputView 클래스는 메세지를 콘솔에 출력하 부분만 담당하는(MVC 구조에 View를 담당하는) 클래스이다.
 * OutputView 인스턴스를 만드는 것을 고려하지 않고 설계하였다.
 */
public class OutputView {
    /**
     * NAME_FORMAT 는 문자열 상수 값으로, InputView에서 이름을 입력받을 때 출된다.
     */
    private static final String NAME_FORMAT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)";

    /**
     * REPEAT_FORMAT 은 문자열 상수 값으로, InputView에서 게임 횟수를 입력받을 때 출력된다.
     */
    private static final String REPEAT_FORMAT = "시도할 회수는 몇회인가요?";

    /**
     * RESULT_FORMAT 은 문자열 상수 값으로, 실행 결과(printStatusLog 실행) 출력 전에 출력되어야 하는 양식값이다.
     * RacingGame 클래스의 메인 로직을 통해 출력된다.
     */
    private static final String RESULT_FORMAT = "\n실행 결과";

    /**
     * WINNER_FORMAT 은 우승자 출력 전에 출력되는 포맷 값이다.
     * RacingGame 클래스의 메인 로직을 통해 출력된다.
     */
    private static final String WINNER_FORMAT = "가 최종 우승했습니다.";

    /**
     * 생성자 메서드는 호출되지 않는 것이 정상이므로 private으로 설정하였다.
     *
     * @throws AssertionError : 잘못된 선언이 발생할 경우 예외처리한다.
     */
    private OutputView() {
        throw new AssertionError();
    }

    /**
     * printStatusLog 는 자동차의 주행 기록을 출력하기 위한 메서드이다.
     * 문자열을 입력받은 후, 줄바꿈을 포함하여 출력해 준다.
     *
     * @param log 출력할 자동차 주행 기록을 저장한 String 인스턴스이다.
     */
    public static void printLog(String log) {
        System.out.println(log);
    }

    /**
     * printLine 은 줄바꿈 문자를 출력하는 메서드이다.
     */
    public static void printLine() {
        System.out.println();
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

    /**
     * printWinners는 게임에서 이긴 유저들의 이름을 받아 이를 출력하는 메서드이다.
     *
     * @param winnerNames 게임에서 이긴 유저들의 이름을 합친 String 인스턴스이다.
     */
    public static void printWinners(String winnerNames) {
        System.out.println(winnerNames + WINNER_FORMAT);
    }
}
