package racingcar.view;

public class OutputView {

    public static void printCarNamesInputRequestMessage() {
        print("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printTotalRoundsInputRequestMessage() {
        print("시도할 회수는 몇회인가요?");
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
