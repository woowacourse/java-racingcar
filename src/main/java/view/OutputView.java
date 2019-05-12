/*
 * @(#)OutputView.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package view;

import model.LapRecorder;
import model.Winners;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class OutputView {
    /*자동차 게임 출력을 담당하는 클래스*/
    private static final String WINNER_MESSAGE = "%s 가 최종 우승했습니다.";

    public static void printWinners(Winners winners) {
        System.out.println(String.format(WINNER_MESSAGE, winners.toString()));
    }

    public static void printGameResult(LapRecorder lapRecorder) {
        System.out.println("실행 결과");
        System.out.print(lapRecorder.toString());
    }
}
