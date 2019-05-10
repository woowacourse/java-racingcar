package com.woowacourse.javaracingcarwithoutif;

import com.woowacourse.javaracingcar.domain.RandomNumberGenerator;

/**
 * If 구문을 사용하지 않은 버전
 */
public class AppMain {

    public static void main(String[] args) {
        new RacingcarController(new ConsoleUserInterface(), new RandomNumberGenerator()).play();
    }
}
