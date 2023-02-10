package output;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.Cars;

public class Outputs {

    private final List<Output> outputs;

    private Outputs(List<Output> outputs) {
        this.outputs = outputs;
    }

    public static Outputs from(Cars cars) {
        List<Output> outputs = cars.getStream()
                .map(Output::from)
                .collect(Collectors.toList());

        return new Outputs(outputs);
    }

    public Stream<Output> getStream() {
        return outputs.stream();
    }
}
