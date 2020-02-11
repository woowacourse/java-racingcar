package view;

public class OutputView {
    public void printCurrentPosition(String name, int position) {
        String carState = String.format("%s : %s", name, makeHyphens(position));
        System.out.println(carState);
    }

    public String makeHyphens(int position) {
        StringBuilder builder = new StringBuilder();
        while (position-- > 0) {
            builder.append("-");
        }
        return builder.toString();
    }
}
