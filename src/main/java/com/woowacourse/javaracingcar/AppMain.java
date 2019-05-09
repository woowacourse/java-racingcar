package com.woowacourse.javaracingcar;

public class AppMain {

    public static void main(String[] args) {
        new RacingcarController(new ConsoleUserInterface()).play();
    }
}
