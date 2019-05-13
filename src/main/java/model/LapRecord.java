package model;

import java.util.ArrayList;
import java.util.List;

public class LapRecord {
    private List<Cars> laps;

    LapRecord() {
        laps = new ArrayList<>();
    }

    void add(Cars cars) {
        laps.add(cars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Cars cars : laps){
            sb.append(cars.toString());
        }
        return sb.toString();
    }
}
