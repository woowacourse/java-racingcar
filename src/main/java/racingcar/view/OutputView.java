package racingcar.view;

/**
 * OutputView.java
 * 입력을 제외한 출력을 담당하는 View 클래스
 *
 * @author Kimun Kim / kkm97351@gmail.com
 */
public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";

    public static void printErrorMessage(Exception e) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
    }
}
