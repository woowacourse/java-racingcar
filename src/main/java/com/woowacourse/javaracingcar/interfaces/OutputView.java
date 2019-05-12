package com.woowacourse.javaracingcar.interfaces;

import com.woowacourse.javaracingcar.domain.PlayingCars;
import com.woowacourse.javaracingcar.domain.WinnerGroup;

public interface OutputView {
    void printResultTitle();
    void printResult(PlayingCars cars);
    void printWinners(WinnerGroup winners);
}
