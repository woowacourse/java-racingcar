package racingcar;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    static final String ONE_ROUND_RESULT;
    static final String FINAL_WINNER;
    static final String NAME_LIMIT_MESSAGE;

    static {
        ONE_ROUND_RESULT = "\n실행 결과";
        FINAL_WINNER = "가 최종 우승했습니다.";
        NAME_LIMIT_MESSAGE = "5자 이하의 이름을 입력해주세요.";
    }

    public static void printStartMessage(){
        System.out.println(ONE_ROUND_RESULT);
    }

    public static void printCar(Car car){
        System.out.println(car);
    }

    public static void printNewline() {
        System.out.println();
    }

    public static void printNameLimit(){
        System.out.println(NAME_LIMIT_MESSAGE);

    }

    public static void printFinalWinner(List<Car> winnerList) {
        List<String> winList = new ArrayList<>();

        for (Car car: winnerList) {
            winList.add(car.getName());
        }

        String result = String.join(", ", winList) + FINAL_WINNER;
        System.out.println(result);
    }
}
