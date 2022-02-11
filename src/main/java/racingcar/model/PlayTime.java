package racingcar.model;

public class PlayTime {
    private Integer playTime;

    public PlayTime(Integer playTime) {
        if (playTime < 1) {
            throw new IllegalArgumentException("[ERROR] 레이싱 횟수는 1회 이상이어야 합니다.");
        }
        this.playTime = playTime;
    }
}
