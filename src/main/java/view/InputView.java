package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    private static final String INPUT_N_TRIAL_MSG = "시도할 회수는 몇 회인가요?";
    private static final String INPUT_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_MISMATCH_MSG = "올바르지 않은 입력입니다. 다시 입력해주세요.";
    private static final String NEGATIVE_VALUE_MSG = "입력값이 음수입니다. 음이 아닌 정수로 입력해주세요.";
    private static final String NEXT_LINE = "\n";

    private static int readNumber() {
        return sc.nextInt();
    }

    private static int readNumberWithMsg(String msg) {
        OutputView.printMassage(msg);
        return readNumber();
    }

    private static String readLine() {
        return sc.nextLine();
    }

    private static String readLineWithMsg(String msg) {
        OutputView.printMassage(msg);
        return readLine();
    }

    public static String inputCarNames() {
        return readLineWithMsg(INPUT_CAR_NAME_MSG + NEXT_LINE);
    }

    public static int inputNTrials() {
        try {
            return validNTrial(readNumberWithMsg(INPUT_N_TRIAL_MSG + NEXT_LINE));
        } catch (IllegalArgumentException e) {
            OutputView.printMassage(e.getMessage());
            return inputNTrials();
        } catch (InputMismatchException ie) {
            OutputView.printMassage(INPUT_MISMATCH_MSG + NEXT_LINE);
            return inputNTrials();
        }
    }

    private static int validNTrial(int nTrial) {
        if (nTrial < 0) throw new IllegalArgumentException(NEGATIVE_VALUE_MSG + NEXT_LINE);
        return nTrial;
    }
}
