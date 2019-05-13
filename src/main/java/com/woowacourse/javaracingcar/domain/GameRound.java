package com.woowacourse.javaracingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class GameRound {
    private final List<CarDto> cars;

    public GameRound(final PlayingCars playingCars) {
        this.cars = new ArrayList<>(playingCars.retrieveAllCars());
    }

    public void forEach(Consumer<CarDto> consumer) {
        cars.forEach(consumer);
    }
}
