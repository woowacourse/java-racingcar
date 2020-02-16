package domain;

import java.util.List;

public class RacingResults {
	private final List<RacingResult> results;

	public RacingResults(final List<RacingResult> results) {
		this.results = results;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		results.forEach(results -> builder.append(results.toString()));
		return builder.toString();
	}
}
