package com.woowacourse.javaracingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerGroup {
    final List<CarDto> winners;

    public WinnerGroup(final GameRound gameRound) {
        final List<CarDto> cars = new ArrayList<>();
        gameRound.forEach(cars::add);
        final int max = Collections.max(cars).getPosition();

        winners = cars.stream()
            .filter(c -> c.getPosition() == max)
            .map(c -> new CarDto(c.getName(), c.getPosition()))
            .collect(Collectors.toList());
    }

    public List<CarDto> getWinners() {
        return new ArrayList<>(winners);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("WinnerGroup [ ");
        winners.forEach(sb::append);
        sb.append(" ]");
        return sb.toString();
    }
}
