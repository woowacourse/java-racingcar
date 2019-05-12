/*
 * @(#)LapCount.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package model;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class LapCount {
    /*시도횟수에 대한 클래스*/
    private static final String REGEX_IS_NATURAL_NUMBER = "^([1-9])([0-9])*$";
    private int lapCount;

    public LapCount(String lapCount) {
        parseNaturalNumber(lapCount);
    }

    private void parseNaturalNumber(String lapCount) {
        checkNaturalNumberFormat(lapCount);
        try {
            this.lapCount = Integer.parseInt(lapCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수가 정수 범위롤 초과힙니다.");
        }
    }

    private void checkNaturalNumberFormat(String lapCount) {
        if (!lapCount.matches(REGEX_IS_NATURAL_NUMBER)) {
            throw new IllegalArgumentException("시도 횟수는 자연수입니다.");
        }
    }

    public int getLapCount() {
        return lapCount;
    }
}
