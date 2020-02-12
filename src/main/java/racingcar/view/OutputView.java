package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.message.Message;

/*
 * Copyright (c) 2020 by 또동페어
 * All rights reserved.
 *
 * OutputView.java
 * 출력을 담당하는 클래스
 *
 * @author      또동페어
 * @version     1.0
 * @date        12 Feb 2020
 *
 */
public class OutputView {
    private static final char LINE_FEED = '\n';
    private static final char COLON = ':';
    private static final char TRACE_OF_CAR = '-';

    public static void printRoundResult(Cars cars){
        StringBuilder stringBuilder = new StringBuilder();
        for(Car car : cars){
            stringBuilder.append(car.getName());
            stringBuilder.append(COLON);
            stringBuilder.append(makePositionLine(car.getPosition()));
            stringBuilder.append(LINE_FEED);
        }
        stringBuilder.append(LINE_FEED);
        System.out.print(stringBuilder);
    }

    private static String makePositionLine(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(TRACE_OF_CAR);
        }
        return stringBuilder.toString();
    }

    public static void printRoundStart() {
        System.out.println(Message.ROUND_START.getMessageText());
    }
}
