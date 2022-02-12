package calculator.domain;

public class UserInputForm {

	private final String formula;
	private String customDelimiter;

	public UserInputForm(String formula) {
		this.formula = formula;
	}

	public UserInputForm(String customDelimiter, String formula) {
		this.customDelimiter = customDelimiter;
		this.formula = formula;
	}

	public String getFormula() {
		return formula;
	}

	public String getCustomDelimiter() {
		return customDelimiter;
	}

	public boolean hasCustomDelimiter() {
		return this.getCustomDelimiter() != null;
	}
}
