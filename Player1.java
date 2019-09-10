package crapsGameV1;

import java.util.Scanner;
import java.util.Set;

public class Player1 {

	
    Player bankroll = new Player();
	Scanner in = new Scanner(System.in);
	
	int money = in.nextInt();
	
	bankroll.setBankroll(money);

}
