package com.woowacourse.javaracingcar.interfaces;

import com.woowacourse.javaracingcar.domain.GameResult;

public interface OutputView {
    void printResultTitle();
    void printResult(GameResult cars);
}
