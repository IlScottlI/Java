import java.util.ArrayList;
public class Calculator {
	private Double operandOne;
	private String operation;
	private Double operandTwo;
	private ArrayList<Object> history = new ArrayList<Object>();
	private Double res;
	public Double getRes() {
		return res;
	}


	public void setRes(Double res) {
		this.res = res;
	}


	public Calculator () {
		
	}
	
	
	public void performOperation() {
		Double one = this.getOperandOne();
		Double two = this.getOperandTwo();
		String key = this.getOperation();
		switch (key) {
		case "+":
			this.setRes(one + two);
			break;
		case "-":
			this.setRes(one - two);
			break;
		}
		history.add(one + " " + key + " " + two + " = " + this.getRes());
	}
	
	public Double getResults() {
		return this.getRes();
	}
	
	// Getters and Setters
	
	public ArrayList<Object> getHistory() {
		return history;
	}


	public Double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(Double operandOne) {
		this.operandOne = operandOne;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(Double operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	
}
