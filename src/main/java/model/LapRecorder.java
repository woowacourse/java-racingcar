package model;

import java.util.ArrayList;
import java.util.List;

public class LapRecorder {
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
