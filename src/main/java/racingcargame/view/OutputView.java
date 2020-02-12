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
        System.out.println("실행 결과");
    }

    public static void carNameAndPosition(Car car) {
        String blank = "";
        int currentPosition = car.getCarPosition();
        for (int i = 0; i < currentPosition; i++) {
            blank += MARK;
        }
        System.out.println(car.getCarName() + " : " + blank);
    }

    public static void winnerInstruction(String winnerName) {
        System.out.println(winnerName + "가 최종 우승했습니다.");
    }

    public static void newLine() {
        System.out.println();
    }

}
