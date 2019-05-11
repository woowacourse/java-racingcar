package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.interfaces.InputView;

import java.util.List;

public class TestInputView implements InputView {
    private String carNamesInput;
    private int triesInput;

    public TestInputView(String carNamesInput, int triesInput) {
        this.carNamesInput = carNamesInput;
        this.triesInput = triesInput;
    }

    @Override
    public List<String> promptUserNames() {
        return RacingcarUtil.splitIntoNames(carNamesInput);
    }

    @Override
    public int promptTries() {
        return triesInput;
    }
}
