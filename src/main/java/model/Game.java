package model;

import java.util.Collections;

public class Game {

  public Cars proceed(Cars cars) {
    return cars.applyMoving();
  }

  public Cars winners(Cars cars) {
    int maxCount = Collections.max(cars.countOfForward());
    return cars.findSameCountOfForward(maxCount);
  }
}
