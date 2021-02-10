package racingcar.view;

import racingcar.RacingLogPerRound;

public class LogToGraph {

  private static final String GRAPH_FORM = "%s : %s\n";
  private static final String GRAPH = "-";
  private final RacingLogPerRound logByRound;
  private final StringBuilder graph;

  public LogToGraph(RacingLogPerRound logByRound) {
    this.logByRound = logByRound;
    this.graph = new StringBuilder();
  }

  public String logGraph() {
    logByRound.racingLog()
        .forEach(log -> graph.append(
            String.format(GRAPH_FORM, log.getName(), positionToGraph(log.getPosition()))
        ));
    return graph.toString();
  }

  private String positionToGraph(int position) {
    StringBuilder graph = new StringBuilder();
    for (int i = 0; i < position; i++) {
      graph.append(GRAPH);
    }
    return graph.toString();
  }
}
