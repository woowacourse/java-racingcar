package racingcar.utils;

public class PrintUtils {

    public static void printInfo(String info) {
        System.out.println(info);
    }

    public static void printResult(String result) {
        System.out.println(result);
        printLine();
    }

    public static void printWinner(String[] winnerNames) {
        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }

    public static void printLine() {
        System.out.println();
    }

}
