package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingResults {
    private List<RacingResult> racingResults = new ArrayList<>();

    public void add(RacingResult racingResult) {
        racingResults.add(racingResult);
    }

    public int getSize() {
        return racingResults.size();
    }

    public RacingResult get(int index) {
        return racingResults.get(index);
    }
}
