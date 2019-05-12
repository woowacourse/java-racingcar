/*
 * @(#)LapRecorder.java      1.0 2019/05/12
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Calculator, Java, Seoul, KOREA
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0 2019년 05년 12일
 * @author 김효건
 */
public class LapRecorder {
    /*레이싱 lap(각 시도)에 대한 정보를 기록하는 클래스*/
    private List<Cars> laps;

    public LapRecorder() {
        laps = new ArrayList<>();
    }

    public void record(Cars cars) {
        laps.add(cars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Cars cars : laps) {
            sb.append(cars.toString());
        }
        return sb.toString();
    }
}
