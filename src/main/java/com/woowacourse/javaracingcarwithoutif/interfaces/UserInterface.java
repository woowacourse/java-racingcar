package com.woowacourse.javaracingcarwithoutif.interfaces;

import com.woowacourse.javaracingcarwithoutif.domain.CarDto;

import java.util.List;

public interface UserInterface {
    List<String> promptUserNames();

    int promptTries();

    void printResult(List<CarDto> cars);

    void printWinners(List<CarDto> winners);
}
