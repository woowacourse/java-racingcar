package view;

import domain.Car;
import domain.Cars;
import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final String MOVE_EXPRESS = "-";
    private static final String COMMA = ", ";

     public void printCarNamesInputText() {
         System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
     }

     public void printTryCountInputText() {
         System.out.println("시도할 회수는 몇회인가요?");
     }

     public void printRacingResult() {
         System.out.println("실행 결과");
     }

    public void printRacingProceed(Cars cars) {
        StringBuilder builder = new StringBuilder();
        for (Car car : cars.getCars()) {
            builder.append(String.format("%s : %s\n", car.getName(), MOVE_EXPRESS.repeat(car.getPosition())));
        }

        System.out.println(builder);
    }

    public void printWinners(Cars cars) {
        StringJoiner stringJoiner = new StringJoiner(COMMA);
        cars.getCars().forEach(car -> stringJoiner.add(car.getName()));

        System.out.printf("%s가 최종 우승했습니다.", stringJoiner);
    }
}
