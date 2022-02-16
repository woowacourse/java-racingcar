package racingcar.view;

import java.util.List;

public interface InputView {

    String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    String COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    String DELIMITER = ",";

    List<String> getCarNames();

    int getCount();
}
