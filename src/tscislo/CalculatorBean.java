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

	public void processOperation(Operation operation) {
		if (!isError() || (isError() && operation.isClear())) {
			this.addNewOperation(operation);
		}
	}

	private void addNewOperation(Operation operation) {
		try {
			if (this.previousArthmeticOperation != null && !this.previousArthmeticOperation.getWasExecuted()) {
				if (operation.isEq()) {
					this.performArthemticOperation(this.previousArthmeticOperation, true);
				} else if (operation.isPercents()) {
					this.previousArthmeticOperation.setIsWithPercents(true);
					this.performArthemticOperation(this.previousArthmeticOperation, true);
				}
			}

			this.previousOperation = this.currentOperation.clone();
			this.currentOperation = operation;

			if (operation.isArthmeticTwoElements()) {
				this.previousArthmeticOperation = operation;
			}

			if (this.currentOperation.isNumber()) {
				if (this.previousOperation.isArthmeticTwoElements() || this.previousOperation.isEq()) {
					this.currentOnDisplay = "";
				}
				if (this.currentOnDisplay.equals("0")) {
					this.currentOnDisplay = operation.getOperationName();
				} else {
					this.currentOnDisplay += operation.getOperationName();
				}

			} else if (!this.previousOperation.isEq() && !this.previousOperation.isPercents()
					&& operation.isArthmeticTwoElements()) {
				if (currentInMemory.equals("0")) {
					this.currentInMemory = this.currentOnDisplay;
				} else {
					this.performArthemticOperation(this.currentOperation,
							(this.state == CalculatorStates.IDLE) ? false : true);
				}
			} else if (operation.isArthmeticOneElements()) {
				this.performArthemticOperation(this.currentOperation,
						(this.state == CalculatorStates.IDLE) ? false : true);
			} else if (operation.isClear()) {
				this.init();
			}
			this.state = CalculatorStates.NORMAL;
			this.verifyIfValueCorrect();
		} catch (Exception e) {
			this.reportError();
		}
	}

	public void performArthemticOperation(Operation operation, Boolean markAsExecuted) {
		Double forOperationCurrentOnDisplay = Double.valueOf(currentOnDisplay);
		if (operation.getIsWithPercents()) {
			forOperationCurrentOnDisplay = Double.valueOf(currentOnDisplay) * Double.valueOf(currentInMemory) / 100;
		}
		switch (operation.getOperationName()) {
		case "+":
			this.currentOnDisplay = Double.toString((Double.valueOf(currentInMemory) + forOperationCurrentOnDisplay));
			break;
		case "-":
			this.currentOnDisplay = Double.toString((Double.valueOf(currentInMemory) - forOperationCurrentOnDisplay));
			break;
		case "*":
			this.currentOnDisplay = Double.toString((Double.valueOf(currentInMemory) * forOperationCurrentOnDisplay));
			break;
		case "/":
			this.currentOnDisplay = Double.toString((Double.valueOf(currentInMemory) / forOperationCurrentOnDisplay));
			break;
		case "sqrt":
			this.currentOnDisplay = Double.toString(Math.sqrt(Double.valueOf(currentOnDisplay)));
			break;
		default:
			break;
		}
		operation.setWasExecuted(markAsExecuted);
		this.currentInMemory = this.currentOnDisplay;
	}

	private void verifyIfValueCorrect() throws Exception {
		if (this.currentOnDisplay.length() > numberOfDigitsOnDisplayLimit || this.currentOnDisplay == "Infinity") {
			throw new Exception();
		}
	}

	private void reportError() {
		this.currentOnDisplay = "ERR";
		this.state = CalculatorStates.ERROR;
	}

	public Boolean isError() {
		return this.state == CalculatorStates.ERROR;
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
