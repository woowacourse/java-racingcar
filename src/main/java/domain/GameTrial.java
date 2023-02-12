package domain;

public class GameTrial {

    int gameTrial;

    public GameTrial(int gameTrial) {
        this.gameTrial = gameTrial;
    }

    public boolean isGreaterThan(int otherCount) {
        return gameTrial > otherCount;
    }

    public void reduce() {
        gameTrial--;
    }
}