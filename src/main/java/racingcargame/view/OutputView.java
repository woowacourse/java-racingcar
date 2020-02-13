package racingcargame.view;

import racingcargame.domain.Car;

public class OutputView {

    public static final String MARK = "-";

    public static void inputNameInstruction() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void inputRepeatInstruction() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void resultInstruction() {
        System.out.println("\n실행 결과");
    }

    public static void carNameAndPosition(Car car) {
        StringBuilder sb = new StringBuilder();

        sb.append(car.getCarName());
        sb.append(" : ");
        for (int i = 0; i < car.getCarPosition(); i++) {
            sb.append(MARK);
        }
        System.out.println(sb);
    }

    public static void winnerInstruction(String winnerName) {
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }

    public static void newLine() {
        System.out.println();
    }

    public static void errorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println("프로그램을 다시 실행해 주세요.");
    }

}
