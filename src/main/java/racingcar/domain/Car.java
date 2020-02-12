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

    private final String name;
    private int forwardCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void forward() {
        forwardCount++;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < forwardCount; i++) {
            stringBuilder.append("-");
        }
        return name + " : " + stringBuilder.toString() + "\n";
    }
}
