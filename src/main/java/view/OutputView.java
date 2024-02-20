package view;

import domain.Cars;
import domain.Winner;
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
        System.out.println("\n실행 결과");
    }

    public void printRacingProceed(final Cars cars) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cars.getSize(); i++) {
            String name = cars.getCarNameOf(i);
            int position = cars.getCarPositionOf(i);
            builder.append(String.format("%s : %s\n", name, MOVE_EXPRESS.repeat(position)));
        }
        System.out.println(builder);
    }

    public void printWinner(final Winner winner) {
        StringJoiner stringJoiner = new StringJoiner(COMMA);
        winner.getNames().forEach(stringJoiner::add);
        System.out.printf("%s가 최종 우승했습니다.", stringJoiner);
    }
}
