package racingCar.view;

public class OutputView {
    private static final String RESULT_HEAD = "실행 결과";

    public static void printTitle() {
        System.out.println(RESULT_HEAD);
    }

    public static void printEachRound(String string) {
        System.out.println(string);
    }

    public static void printWinners(String string) {
        System.out.println("우승자는 " + string + " 입니다.");
    }

    public static void printRound(int round) {
        System.out.println(round + "회차");
    }

    public static void printInvalidInputCheck() {
        System.out.println("이름 입력 조건: 길이는 1부터 5까지, 중복 허용X");
    }
}
