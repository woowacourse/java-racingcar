package racingcar.input;

public class InputPrinter {

    private InputPrinter() {
    }

    public static void printCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printRacingTryTimeInputMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }
}
