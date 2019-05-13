package view;

import domain.Const;
import util.Util;

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
     * <br> 이름 유효성 검사를 진행해 문제가 있으면 재귀
     *
     * @return 사용자로부터 입력받은 문장
     */
    public static String inputCarNames() {
        try {
            System.out.println(Const.INPUT_CAR_NAME);
            return Util.checkCarNames(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    /**
     * 사용자로부터 게임 횟수를 입력받고 반환
     * <br> 횟수 유효성 검사를 진행해 문제가 있으면 재귀
     *
     * @return 사용자로부터 입력받은 게임 횟수
     */
    public static int inputRoundCount() {
        try {
            System.out.println(Const.INPUT_ROUND_CNT);
            return Util.checkRoundCount(Integer.parseInt(SCANNER.nextLine()));
        } catch (Exception e) {
            System.out.println(Const.EX_ROUND_COUNT);
            return inputRoundCount();
        }
    }
}
