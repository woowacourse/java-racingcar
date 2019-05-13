package view;

import domain.Const;

import java.util.Scanner;

/**
 * 입력 View 클래스
 *
 * @author heebg
 * @version 1.0 2019-05-08
 */
public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * 사용자로부터 자동차 이름을 입력받고 반환
     *
     * @return 사용자로부터 입력받은 문장
     */
    public static String inputCarNames() {
        System.out.println(Const.INPUT_CAR_NAME);
        return SCANNER.nextLine();
    }

    /**
     * 사용자로부터 게임 횟수를 입력받고 반환
     *
     * @return 사용자로부터 입력받은 게임 횟수
     * @throws NumberFormatException 정수 이외를 입력했을 경우
     */
    public static int inputRoundCount() {
        try {
            System.out.println(Const.INPUT_ROUND_CNT);
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(Const.EX_ROUND_COUNT);
            return inputRoundCount();
        }
    }
}
