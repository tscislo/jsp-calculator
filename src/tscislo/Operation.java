package tscislo;

import java.util.Arrays;

public class Operation {

	private String operation;
	private String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." };
	private String[] arthmetic = { "-", "+", "*", "/", "%", "sqrt" };
	private Boolean wasExecuted = false;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Operation(String operation) {
		this.operation = operation;
	}

	public Boolean isArthmetic() {
		return Arrays.asList(this.arthmetic).contains(this.operation);
	}

	public Boolean isNumber() {
		return Arrays.asList(this.numbers).contains(this.operation);
	}

	public Boolean isClear() {
		return this.operation.equals("ce");
	}

	public Boolean isEq() {
		return this.operation.equals("=");
	}

	public Operation clone() {
		return new Operation(this.operation);
	}

	public Boolean getWasExecuted() {
		return wasExecuted;
	}

	public void setWasExecuted(Boolean wasExecuted) {
		this.wasExecuted = wasExecuted;
	}

}
