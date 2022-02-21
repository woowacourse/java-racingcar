package racingcar.model.score;

public class Score implements Comparable<Score> {
    private final String name;
    private final int point;

    public Score(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public boolean matchScore(int score) {
        return this.point == score;
    }

    @Override
    public int compareTo(Score o) {
        return this.point - o.point;
    }
}
