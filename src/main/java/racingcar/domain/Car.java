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

    private final CarName name;
    private int position = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public void forward() {
        position++;
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position;
    }

    public boolean isEqualPosition(int position) {
        return this.position == position;
    }

    public String getProgress(String delimiter, String progressSign) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(progressSign);
        }
        return name + delimiter + stringBuilder.toString() + NEW_LINE;
    }
}
