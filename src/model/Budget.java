package model;

public class Budget {

	private String numBudget;
	private int fkTypeBudget;

	public Budget(String numBudget, int fkTypeBudget) {
		super();
		this.numBudget = numBudget;
		this.fkTypeBudget = fkTypeBudget;
	}

	public String getNumBudget() {
		return numBudget;
	}

	public void setNumBudget(String numBudget) {
		this.numBudget = numBudget;
	}

	public int getFkTypeBudget() {
		return fkTypeBudget;
	}

	public void setFkTypeBudget(int fkTypeBudget) {
		this.fkTypeBudget = fkTypeBudget;
	}
}
