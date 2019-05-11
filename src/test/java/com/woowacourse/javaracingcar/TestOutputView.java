package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.interfaces.OutputView;

import java.util.List;

public class TestOutputView implements OutputView {

    private final TestOutputListener outputListener;

    public TestOutputView(TestOutputListener outputListener) {
        this.outputListener = outputListener;
    }


    @Override
    public void printResult(List<CarDto> cars) {
        if (outputListener != null) {
            outputListener.onPrintResult(cars);
        }
    }

    @Override
    public void printWinners(List<CarDto> winners) {
        if (outputListener != null) {
            outputListener.onPrintWinners(winners);
        }
    }

    interface TestOutputListener {
        void onPrintResult(List<CarDto> carList);
        void onPrintWinners(List<CarDto> carList);
    }
}
