package com.woowacourse.javaracingcar.view.interfaces;

import com.woowacourse.javaracingcar.GameResult;
import com.woowacourse.javaracingcar.dto.CarDto;

import java.util.List;

public interface UserInterface {
    List<String> promptUserNames();
    int promptTries();
    void printResult(List<CarDto> cars);
    void printWinners(GameResult gameResult);

    List<String> onInvalidUserNames();
    int onInvalidTries();
}
