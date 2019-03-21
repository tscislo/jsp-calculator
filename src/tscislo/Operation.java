package tscislo;

import java.util.Arrays;

public class Operation {

	private String operationName;
	private String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "." };
	private String[] arthmeticTwoElements = { "-", "+", "*", "/"};
	private String[] arthmeticOneElement = { "sqrt" };
	private Boolean isWithPercents = false;
	private Boolean wasExecuted = false;

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operation) {
		this.operationName = operation;
	}

	public Operation(String operation) {
		this.operationName = operation;
	}
	

	public Boolean isArthmeticTwoElements() {
		return Arrays.asList(this.arthmeticTwoElements).contains(this.operationName);
	}
	
	public Boolean isArthmeticOneElements() {
		return Arrays.asList(this.arthmeticOneElement).contains(this.operationName);
	}

	public Boolean isNumber() {
		return Arrays.asList(this.numbers).contains(this.operationName);
	}

	public Boolean isClear() {
		return this.operationName.equals("ce");
	}

	public Boolean isEq() {
		return this.operationName.equals("=");
	}
	
	public Boolean isPercents() {
		return this.operationName.equals("%");
	}

	public Operation clone() {
		return new Operation(this.operationName);
	}

	public Boolean getWasExecuted() {
		return wasExecuted;
	}

	public void setWasExecuted(Boolean wasExecuted) {
		this.wasExecuted = wasExecuted;
	}

	public Boolean getIsWithPercents() {
		return isWithPercents;
	}

	public void setIsWithPercents(Boolean isWithPercents) {
		this.isWithPercents = isWithPercents;
	}

}
