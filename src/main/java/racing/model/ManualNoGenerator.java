package racing.model;

public class ManualNoGenerator implements NumberGenerator {
    private int no;

    public ManualNoGenerator(int no) {
        this.no = no;
    }

    @Override
    public int getNumber() {
        return no;
    }
}
