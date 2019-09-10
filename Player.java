package crapsGameV1;

public class Player {

	private int bankroll;

	private int passline;

	private int dontPass;

	public int getBankroll() {
		return this.bankroll;
	}

	public void setBankroll(int bankroll) {
		this.bankroll = bankroll;
	}

	public int getPassline() {
		return passline;
	}

	public void setPassline(int passline) {
		this.passline = passline;
	}

	public int getDontPass() {
		return dontPass;
	}

	public void setDontPass(int dontPass) {
		this.dontPass = dontPass;
	}

}
