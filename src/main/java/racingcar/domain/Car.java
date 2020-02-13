/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        11 Feb 2020
 *
 */

package racingcar.domain;

public class Car {

    private final static String NEW_LINE = "\n";

    private final String name;
    private int forwardCount = 0;

    Car(String name) {
        this.name = name;
    }

    public void forward() {
        forwardCount++;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public String getProgress(String delimiter, String progressSign) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < forwardCount; i++) {
            stringBuilder.append(progressSign);
        }
        return name + delimiter + stringBuilder.toString() + NEW_LINE;
    }
}
