package racingcar.model;

import java.util.Map;

public record MoveHistory(Map<String, Integer> nameAndPosition) {
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        for (String name : nameAndPosition.keySet()) {
            sb.append(name).append(" : ").append("-".repeat(nameAndPosition.get(name))).append("\n");
        }
        return sb.toString();
    }
}
