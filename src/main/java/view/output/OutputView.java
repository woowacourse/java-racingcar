package view.output;

import domain.Car;
import util.Finder;

import java.util.List;

public class OutputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_COUNT = "시도할 회수는 몇회인가요?";

    public static void printInputCarName() {
        System.out.println(INPUT_CAR_NAME);
    }

    public static void printCount() {
        System.out.println(INPUT_COUNT);
    }

    public static void printPhrase() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printStep(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getStep(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public static void printResult(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        int winnerStep = Finder.findMaxStep(cars);
        for (Car car : cars) {
            if(car.getStep() == winnerStep){
                sb.append(car.getName()).append(", ");
            }
        }
        sb.deleteCharAt(sb.toString().length() - 1);
        sb.deleteCharAt(sb.toString().length() - 1);
        System.out.println(sb.toString() + "가 최종 우승했습니다.");
    }
}
