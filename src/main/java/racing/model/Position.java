package racing.model;

public class Position {
    public static final String DASH = "-";
    public static final int STEP = 1;

    private int position;

    public Position (){}

    public Position (int position){
        this.position = position;
    }

    public void add(){
        position += STEP;
    }

    public String getPositionByDash() {
        StringBuilder dash = new StringBuilder();
        for (int index = 0; index < position; index++){
            dash.append(DASH);
        }
        return dash.toString();
    }

    public String getPositionByDash(int position) {
        StringBuilder dash = new StringBuilder();
        for (int index = 0; index < position; index++){
            dash.append(DASH);
        }
        return dash.toString();
    }

    @Override
    public boolean equals(Object o){
        if (this.position == ((Position)o).position && (o instanceof Position)){
            return true;
        }
        return false;
    }

    public boolean isBiggerThan(Position targetPosition) {
        return this.position > targetPosition.position;
    }
}
