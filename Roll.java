package crapsGameV1;

import java.util.Scanner;

public class Roll implements Dice {

	@Override
	public int go() {
		return 0;
	}

	public void Call() {

		Dice d1 = new InteractiveDie();
		Dice d2 = new InteractiveDie();
		Scanner in = new Scanner(System.in);
		Player d = new Player();

		System.out.print("Enter Buyin = " + "\n" + "$");
		int bmoney = in.nextInt();
		d.setBankroll(bmoney);

		// System.out.println(bankroll.getBankroll());

		while (true) {
			// Come Out Roll

			// Wager makeWager = new Wager();

			System.out.print("Enter Passline wager = " + "\n" + "$");
			int passbet = in.nextInt();
			if (passbet <= bmoney && passbet >= 5 && passbet <= 2500) {
				d.setPassline(passbet);
				// System.out.print(d.getPassline());
			} else if (bmoney == 0) {
				System.out.print("Enter more money = ");
				bmoney = in.nextInt();
			} else if (passbet < 5 || passbet > 2500) {
				passbet = 0;
				System.out.print("\n" + "NO BET!!" + "\n" + "The minimum bet is $5 and the maximum is $2500");
			} else {
				passbet = 0;
				System.out.print("\n" + "NO BET!!" + "\n" + "Your wager may not be more than $" + bmoney + "\n");

				// System.out.print(d.getPassline());
			}

			// System.out.print(d.getPassline());

			System.out.println("\n" + "...Press [Enter] to roll the dice... " + "\n");
			in.nextLine();

			int roll1 = d1.go();
			int roll2 = d2.go();
			int call = roll1 + roll2;
			System.out.print(roll1 + " ");
			System.out.println(roll2);
			System.out.println("\nThe Call is = " + call + "\n");

			boolean keepPlaying = false;
			switch (call) {
			case 2:
			case 3:
				System.out.print(roll1 + " ");
				System.out.println(roll2);
				System.out.println("PassLine Loses");
				bmoney = bmoney - passbet;
				System.out.println("$" + bmoney);
				break;
			case 4:
			case 5:
			case 6:
			case 8:
			case 9:
			case 10:
				// System.out.println("The Point is " + call);
				int point = call;

				// int point = dieRoll;

				keepPlaying = true;
				while (keepPlaying) {

					roll1 = d1.go();
					roll2 = d2.go();
					call = roll1 + roll2;

					System.out.println("The Point is = " + point + "\n");
					in.nextLine();

					if (call == point) {
						keepPlaying = false;
						System.out.print(roll1 + " ");
						System.out.println(roll2);
						System.out.println("The Call is = " + call + "\n");
						System.out.println("PassLine Wins");
						bmoney = bmoney + passbet;
						System.out.println("$" + bmoney);
						break;
					}
					switch (call) {

					case 7:
						System.out.print(roll1 + " ");
						System.out.println(roll2);
						System.out.println("The Call is = " + call + "\nLine Away\n");
						keepPlaying = false;
						bmoney = bmoney - passbet;
						System.out.println("$" + bmoney);
						break;
					case 2:
					case 3:
					case 4:
					case 5:
					case 6:
					case 8:
					case 9:
					case 10:
					case 11:
					case 12:
						System.out.print(roll1 + " ");
						System.out.println(roll2);
						System.out.println("The Call is = " + call);
						break;
					default:
						break;
					}
					if (keepPlaying == false) {
						break;
					}
				}
				break;
			case 7:
			case 11:
				System.out.println("PassLine Wins");
				bmoney = bmoney + passbet;
				System.out.println("$" + bmoney);
				break;
			case 12:
				System.out.println("PassLine Loses, Don't Pass Pushes");
				bmoney = bmoney - passbet;
				System.out.println("$" + bmoney);
				break;
			default:
				break;
			}
			// in.close();
		}
	}

}
