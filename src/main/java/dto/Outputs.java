package dto;

import domain.Cars;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Outputs {

    private final List<Output> outputs;

    private Outputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public static Outputs from(Cars cars) {
        List<Output> outputs = cars.getCars().stream()
                .map(Output::from)
                .collect(Collectors.toList());

        return new Outputs(outputs);
    }

    public List<Output> getOutputs() {
        return Collections.unmodifiableList(outputs);
    }
}
