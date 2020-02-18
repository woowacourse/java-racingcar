package domain;

public class RacingResult {
    String name;
    int position;

    public RacingResult(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }
}
