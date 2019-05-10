package com.woowacourse.javaracingcarwithoutif;

import com.woowacourse.javaracingcarwithoutif.domain.CarDto;
import com.woowacourse.javaracingcarwithoutif.interfaces.UserInterface;

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
        List<String> names =  RacingcarUtil.splitIntoNames(carNamesInput);
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

    public interface TestUserInterfaceOutputListener {
        void onPrintResult(List<CarDto> carList);
        void onPrintWinners(List<CarDto> carList);
    }
}
