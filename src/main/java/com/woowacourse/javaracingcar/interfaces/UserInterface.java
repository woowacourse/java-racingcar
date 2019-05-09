package com.woowacourse.javaracingcar.interfaces;

import com.woowacourse.javaracingcar.domain.Car;

import java.util.List;

public interface UserInterface {
    List<String> promptUserNames();
    int promptTries();
    void printResult(List<Car> cars);
    void printWinners(List<Car> winners);

    List<String> onInvalidUserNames();
    int onInvalidTries();
}
