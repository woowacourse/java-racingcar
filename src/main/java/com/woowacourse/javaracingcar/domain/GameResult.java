package com.woowacourse.javaracingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private final List<GameRound> rounds;
    private final List<CarDto> winners;

    public GameResult(final List<GameRound> rounds) {
        this.rounds = rounds;
        this.winners = createWinner();
    }

    private List<CarDto> createWinner() {
        final List<CarDto> cars = new ArrayList<>();
        // 마지막 라운드의 결과로 우승자를 선정
        rounds.get(rounds.size() - 1).forEach(cars::add);
        final int max = Collections.max(cars).getPosition();

        return cars.stream()
            .filter(c -> c.getPosition() == max)
            .map(c -> new CarDto(c.getName(), c.getPosition()))
            .collect(Collectors.toList());
    }

    public List<GameRound> getRounds() {
        return new ArrayList<>(rounds);
    }

    public List<CarDto> getWinners() {
        return new ArrayList<>(winners);
    }
}
