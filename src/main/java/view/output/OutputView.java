package view.output;

public class OutputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_COUNT = "시도할 회수는 몇회인가요?";

    public static void printInputCarName() {
        System.out.println(INPUT_CAR_NAME);
    }

    public static void printCount() {
        System.out.println(INPUT_COUNT);
    }
}
