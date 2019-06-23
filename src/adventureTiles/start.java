package adventureTiles;

import controller.gameLoop;
import controller.time.timer;
import model.gameConf;

public class start {
	
	public timer game = new timer();

	public static void main(String[] args) {
		
		gameConf conf = new gameConf();
		gameLoop loop = new gameLoop(conf);
		loop.start();
		
	}

}
