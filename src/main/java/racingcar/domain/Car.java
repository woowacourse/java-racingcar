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

    private final static String BLANK = " ";
    private final static int NAME_LENGTH_LIMIT = 5;
    private final static int BASE_NUMBER = 4;
    private final static String HYPHEN = "-";
    private final static String COLON = " : ";
    private final static String NEW_LINE = "\n";

    private final String name;
    private int position;

    public Car(String name) {
        validateHasBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    public Car(String name, int position) {
        validateHasBlank(name);
        validateNameLength(name);
        this.name = name;
        this.position = position;
    }

    private void validateHasBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("공백은 허용되지 않습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("6자 이상 이름은 허용되지 않습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void move(int randomNo) {
        if (randomNo >= BASE_NUMBER) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(HYPHEN);
        }
        return name + COLON + stringBuilder.toString() + NEW_LINE;
    }
}
