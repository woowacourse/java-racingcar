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

public class TryCount {

    private static int tryCount = 0;

    public static void setTryCount(String count) {
        validateNumber(count);
        tryCount = Integer.parseInt(count);
        validateCount();
    }

    private static void validateNumber(String count) {
        try {
            Integer.parseInt(count);
        } catch (NumberFormatException nfe) {
            throw new NumberFormatException("시도 횟수는 숫자로 입력해야합니다.");
        }
    }

    private static void validateCount() {
        if (tryCount > 1000) {
            throw new IllegalArgumentException("최대 시도 횟수는 1000번 입니다.");
        }
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1번 이상이여야 합니다.");
        }
    }

    public static int getTryCount() {
        return tryCount;
    }
}
