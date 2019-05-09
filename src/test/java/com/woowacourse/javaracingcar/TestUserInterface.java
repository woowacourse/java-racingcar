package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class TestUserInterface implements UserInterface {

    private String carNamesInput;
    private int triesInput;

    private TestUserInterfaceOutputListener outputListener;

    TestUserInterface(TestUserInterfaceOutputListener outputListener, String carNamesInput, int tries) {
        this.outputListener = outputListener;
        this.carNamesInput = carNamesInput;
        this.triesInput = tries;
    }

    @Override
    public List<String> promptUserNames() {
        String[] names =  RacingCarUtil.splitIntoNames(carNamesInput);
        List<String> nameList = new ArrayList<>();
        for (String name : names) {
            nameList.add(name);
        }
        return nameList;
    }

    @Override
    public int promptTries() {
        return triesInput;
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

    @Override
    public List<String> onInvalidUserNames() {
        return null;
    }

    @Override
    public int onInvalidTries() {
        return 0;
    }

    interface TestUserInterfaceOutputListener {
        void onPrintResult(List<CarDto> cars);
        void onPrintWinners(List<CarDto> cars);
    }
}
