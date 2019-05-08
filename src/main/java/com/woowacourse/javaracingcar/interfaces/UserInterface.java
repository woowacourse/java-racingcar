package com.woowacourse.javaracingcar.interfaces;

import com.woowacourse.javaracingcar.domain.Car;

import java.util.List;

public interface UserInterface {
    public List<String> promptUserNames();
    public int promptTries();
    public void printResult(List<Car> cars);
    public void printWinners(List<Car> winners);

    public List<String> onInvalidUserNames();
    public int onInvalidTries();
}
