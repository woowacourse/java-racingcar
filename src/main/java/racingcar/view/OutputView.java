package racingcar.view;

public class OutputView {

    public static void startMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printProgress(String carName, int position) {
        String positionSign = "-".repeat(position);

        System.out.println(carName + " : " + positionSign);
    }
}
