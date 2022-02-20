package racingcar.model;

import java.util.Objects;

public class PlayTime {

    private static final int MIN_PLAY_TIME = 1;
    private static final String MIN_PLAY_TIME_ERROR_MESSAGE = "[ERROR] 레이싱 횟수는 1회 이상이어야 합니다.";

    private int playTime;

    public PlayTime(int playTime) {
        if (playTime < MIN_PLAY_TIME) {
            throw new IllegalArgumentException(MIN_PLAY_TIME_ERROR_MESSAGE);
        }
        this.playTime = playTime;
    }

    public void decrease() {
        this.playTime--;
    }

    public boolean isEnd() {
        return playTime == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PlayTime playTime1 = (PlayTime) o;

        return playTime == playTime1.playTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(playTime);
    }
}
