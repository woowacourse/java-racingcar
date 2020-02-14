package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RacingResultFactory {

    private List<RacingResult> racingResults = new ArrayList<>();

    public void setResult(RacingResult racingResult) {
        racingResults.add(racingResult);
    }

    public int size() {
        return racingResults.size();
    }

    public Map<Car, Integer> getEpisodeResult(int episode) {
        RacingResult episodeResult = racingResults.get(episode - 1);
        return episodeResult.getRacingResult();
    }
}
