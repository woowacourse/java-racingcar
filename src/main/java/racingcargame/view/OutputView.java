package racingcargame.view;

import racingcargame.domain.Car;
import racingcargame.domain.EachRaceResultDto;

import java.util.ArrayList;
import java.util.List;

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

        sb.append(car.getName());
        sb.append(" : ");
        for (int i = 0; i < car.getCarPosition(); i++) {
            sb.append(MARK);
        }
        System.out.println(sb);
    }

    public static void winnerInstruction(List<Car> cars) {
        List<String> carName = new ArrayList<>();
        for (Car car: cars) {
            carName.add(car.getName());
        }
        System.out.println(String.join(", ", carName) + "가 최종 우승했습니다.");
    }

    public static void newLine() {
        System.out.println();
    }

    public static void errorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println("프로그램을 다시 실행해 주세요.");
    }

    public static void printEachRaceStatus(EachRaceResultDto eachRaceResultDto) {
        for (Car car: eachRaceResultDto.getCar()) {
            OutputView.carNameAndPosition(car);
        }
        OutputView.newLine();
    }

}
