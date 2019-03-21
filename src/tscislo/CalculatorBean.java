package tscislo;

public class CalculatorBean {

	private String currentInMemory;
	private String currentOnDisplay;

	private Operation currentOperation;
	private Operation previousOperation;
	private Operation previousArthmeticOperation;

	private CalculatorStates state = CalculatorStates.IDLE;

	private int numberOfDigitsOnDisplayLimit = 20;

	private void init() {
		this.state = CalculatorStates.IDLE;
		this.currentInMemory = "0";
		this.currentOnDisplay = "0";
		this.previousOperation = null;
		this.currentOperation = new Operation("0");

	}

	public CalculatorBean() {
		this.init();
	}

	public void addNewOperation(Operation operation) {
		if (this.state == CalculatorStates.ERROR) {
			this.init();
		}

		try {
			if (operation.isEq() && this.previousArthmeticOperation != null
					&& !this.previousArthmeticOperation.getWasExecuted()) {
				this.performArthemticOperation(this.previousArthmeticOperation, true);
				this.currentOperation = new Operation("=");
			}

			this.previousOperation = this.currentOperation.clone();
			this.currentOperation = operation;

			if (operation.isArthmetic()) {
				this.previousArthmeticOperation = operation;
			}
			if (this.currentOperation.isNumber()) {
				if (this.previousOperation.isArthmetic() || this.previousOperation.isEq()) {
					this.currentOnDisplay = "";
				}
				if (this.currentOnDisplay.equals("0")) {
					this.currentOnDisplay = operation.getOperation();
				} else {
					this.currentOnDisplay += operation.getOperation();
				}

			} else if (!this.previousOperation.isEq() && operation.isArthmetic()) {
				if (currentInMemory.equals("0")) {
					this.currentInMemory = this.currentOnDisplay;
				} else {
					this.performArthemticOperation(this.currentOperation,
							(this.state == CalculatorStates.IDLE) ? false : true);
				}
			} else if (operation.isClear()) {
				this.init();
			}
			this.state = CalculatorStates.NORMAL;
			this.verifyValue();
		} catch (Exception e) {
			this.reportError();
		}
	}

	public void performArthemticOperation(Operation operation, Boolean markAsExecuted) {
		switch (operation.getOperation()) {
		case "+":
			this.currentOnDisplay = Double
					.toString((Double.valueOf(currentInMemory) + Double.valueOf(currentOnDisplay)));
			break;
		case "-":
			this.currentOnDisplay = Double
					.toString((Double.valueOf(currentInMemory) - Double.valueOf(currentOnDisplay)));
			break;
		case "*":
			this.currentOnDisplay = Double
					.toString((Double.valueOf(currentInMemory) * Double.valueOf(currentOnDisplay)));
			break;
		case "/":
			this.currentOnDisplay = Double
					.toString((Double.valueOf(currentInMemory) / Double.valueOf(currentOnDisplay)));
			break;
		case "sqrt":
			this.currentOnDisplay = Double.toString(Math.sqrt(Double.valueOf(currentOnDisplay)));
			break;
		case "%":
			this.currentOnDisplay = Double
					.toString((Double.valueOf(currentOnDisplay) * Double.valueOf(currentInMemory) / 100));
			break;
		default:
			break;
		}
		operation.setWasExecuted(markAsExecuted);
		this.currentInMemory = this.currentOnDisplay;
	}

	private void verifyValue() throws Exception {
		if (this.currentOnDisplay.length() > numberOfDigitsOnDisplayLimit || this.currentOnDisplay == "Infinity") {
			throw new Exception();
		}
	}

	private void reportError() {
		this.currentOnDisplay = "ERR";
		this.state = CalculatorStates.ERROR;
	}

	public String getCurrentOnDisplay() {
		return currentOnDisplay;
	}

	public void setCurrentOnDisplay(String currentOnDisplay) {
		this.currentOnDisplay = currentOnDisplay;
	}

	public String getCurrentInMemory() {
		return currentInMemory;
	}

	public void setCurrentInMemory(String currentInMemory) {
		this.currentInMemory = currentInMemory;
	}

	public Operation getCurrentOperation() {
		return currentOperation;
	}

	public void setCurrentOperation(Operation currentOperation) {
		this.currentOperation = currentOperation;
	}

	public Operation getPreviousOperation() {
		return previousOperation;
	}

	public void setPreviousOperation(Operation previousOperation) {
		this.previousOperation = previousOperation;
	}

	public Operation getPreviousArthmeticOperation() {
		return previousArthmeticOperation;
	}

	public void setPreviousArthmeticOperation(Operation previousArthmeticOperation) {
		this.previousArthmeticOperation = previousArthmeticOperation;
	}

}
