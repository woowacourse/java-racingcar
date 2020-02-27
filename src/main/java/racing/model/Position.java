package racing.model;

public class Position {
    private static final int STEP = 1;

    private int position;

    public Position (int position){
        this.position = position;
    }

    public void add(){
        position += STEP;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o){
        return this.position == ((Position) o).position;
    }
}
