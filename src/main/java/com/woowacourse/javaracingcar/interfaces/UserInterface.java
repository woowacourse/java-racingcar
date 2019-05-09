package com.woowacourse.javaracingcar.interfaces;

import com.woowacourse.javaracingcar.domain.CarDto;

import java.util.List;

public interface UserInterface {
    List<String> promptUserNames();

    int promptTries();

    void printResult(List<CarDto> carList);

    void printWinners(List<CarDto> winnerList);

    List<String> onInvalidUserNames();

    int onInvalidTries();
}
