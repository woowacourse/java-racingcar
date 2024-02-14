package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String CAR_NAMES_INPUT_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String TRY_COUNT_INPUT_MSG = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MSG = "실행 결과";
    private static final String POSITION_FORM = "%s : %s";
    private static final String TRACE = "-";

    public String printCarPosition(Cars cars) {
        for(Car car : cars.getCars()) {
            String name = car.getName();
            String traces = makeTraces(car.getCount());
            System.out.println(String.format(POSITION_FORM, name, traces));
        }
    }

    private String makeTraces(int count) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
            sb.append(TRACE);
        }
        return sb.toString();
    }
}
