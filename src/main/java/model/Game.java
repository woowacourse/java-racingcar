
package model;

import java.util.Collections;

public class Game {
  private final Cars cars;
  private final TrialCount trialCount;

  public Game(Cars cars, TrialCount trialCount) {
    this.cars = cars;
    this.trialCount = trialCount;
  }

  public Cars play() {
    trialCount.reduce();
    cars.moveAll();
    return cars;
  }

  public Cars winners() {
    int maxCount = Collections.max(cars.countOfForward());
    return cars.findSameCountOfForward(maxCount);
  }

  public boolean over() {
    return !trialCount.isRest();
  }
}
