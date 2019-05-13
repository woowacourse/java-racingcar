package racinggame.view;

import java.util.List;

public class ResultOutput {
    static StringBuilder sb = new StringBuilder();

    public static void winnersOutput(List<String> winners) {
        sb.setLength(0);
        sb.append(String.join(", ", winners));
        sb.append("가 최종 우승했습니다.");

        System.out.println(sb);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
