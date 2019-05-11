package com.woowacourse.javaracingcar.interfaces;

import com.woowacourse.javaracingcar.domain.CarDto;

import java.util.List;

public interface OutputView {
    void printResult(List<CarDto> cars);
    void printWinners(List<CarDto> winners);
}
