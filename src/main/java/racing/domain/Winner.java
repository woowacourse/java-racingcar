/*
 * @(#)Winner.java
 *
 * v 2.0.0
 *
 * 2019.05.13
 *
 * Copyright (c) 2019 KwonMC.
 * WoowahanTechCamp, Seoul, KOREA
 * All right Reserved
 */

package racing.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 우승자를 저장하는 Winner 클래스
 *
 * @author kwonmc
 * @version 2.0.0
 */
public class Winner {
    private final List<Car> winner = new ArrayList<>();

    public void add(Car car) {
        winner.add(car);
    }

    public String getWinners() {
        String[] result = new String[winner.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = winner.get(i).toString();
        }
        return String.join(", ", result);
    }
}
