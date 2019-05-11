package model;

import java.util.ArrayList;
import java.util.List;

public class LapRepository {
    List<Cars> laps;

    public LapRepository() {
        laps = new ArrayList<>();
    }

    public void add(Cars cars) {
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
