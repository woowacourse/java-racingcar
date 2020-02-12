/*
 * Copyright (c) 2020 by 티거, 제이미
 * All rights reserved.
 *
 * @author      티거, 제이미
 * @version     1.0
 * @date        12 Feb 2020
 *
 */

package racingcar.domain;

public class TryCount {

    private final static String EXCEPTION_MESSAGE = "1부터 1000까지의 숫자만 입력 가능합니다.";
    private final static int MINIMUM_NUMBER = 0;
    private final static int MAXIMUM_NUMBER = 1000;
    private int tryCount = 0;

    public TryCount(String count) {
        tryCount = returnValidateNumber(count);
    }

    private static int returnValidateNumber(String count) {
        validateNumber(count);
        int number = Integer.parseInt(count);
        validateRange(number);
        return number;
    }

    private static void validateNumber(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException(EXCEPTION_MESSAGE);
        }
    }

    private static void validateRange(int count) {
        if (count <= MINIMUM_NUMBER || count > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }

    public int getTryCount() {
        return tryCount;
    }
}
