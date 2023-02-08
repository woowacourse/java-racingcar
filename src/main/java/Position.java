public class Position {
    private static final String DELIMITER = "-";

    private int position;

    public Position() {
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(DELIMITER);
        }
        return stringBuilder.toString();
    }
}
