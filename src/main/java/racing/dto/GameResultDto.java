package racing.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GameResultDto {
    private final Map<String, Integer> result = new HashMap<>();

    public void put(String name, int position) {
        result.put(name, position);
    }

    public Set<String> getNames() {
        return result.keySet();
    }

    public int getPosition(String name) {
        return result.get(name);
    }
}
