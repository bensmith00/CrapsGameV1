package crapsGameV1;

public class InteractiveDie implements Dice {

	private int dieRoll;

	@Override
	public int go() {
		setDieRoll((int) (Math.random() * 6) + 1);
		return getDieRoll();
	}

	public int getDieRoll() {
		return dieRoll;
	}

	public void setDieRoll(int dieRoll) {
		this.dieRoll = dieRoll;
	}

}
