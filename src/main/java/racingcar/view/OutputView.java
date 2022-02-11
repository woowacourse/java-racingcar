package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public interface OutputView {
    void printResultMessage();
    void printRoundStatus(List<CarDto> cars);
}
