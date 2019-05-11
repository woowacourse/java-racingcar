package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.RandomNumberGenerator;

public class AppMain {

    public static void main(String[] args) {
        new RacingcarController(new ConsoleInputView(), new ConsoleOutputView(), new RandomNumberGenerator()).play();
    }
}
