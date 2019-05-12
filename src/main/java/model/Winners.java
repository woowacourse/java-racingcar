/*
 * @(#)Winner.java      1.0 2019/05/12
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
public class Winners {
    /*우승자에 관한 클래스*/
    private List<String> winners = new ArrayList<>();

    void addWinners(String name) {
        winners.add(name);
    }

    @Override
    public String toString() {
        return String.join(", ", winners);
    }
}
