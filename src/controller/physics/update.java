package controller.physics;

import model.entity;
import model.gameConf;
import model.gamePool;

public class update {

	private gamePool gamPool;
	private int rowLenght;
	
	public update(gamePool gamPool, gameConf conf) {
		this.gamPool = gamPool;
		this.rowLenght = conf.getWidth() >> conf.getTileDivisor();
	}
	
	public void refresh() {
		while(!gamPool.events.isEmpty()) {
			int event = gamPool.events.removeFirst();
			entity player = gamPool.getPlayer();
			int position = player.getPosition();
			int newPosition = 0;
			switch(event) {
			case 37:
				newPosition = position - 1;
				System.out.println("posi " + newPosition);
				gamPool.interchange(position, newPosition);
				player.setPosition(newPosition);
				gamPool.getPlayer().moveLeft();
				break;
			case 38:
				newPosition = position - rowLenght;
				gamPool.interchange(position, newPosition);
				player.setPosition(newPosition);
				gamPool.getPlayer().moveUp();
				break;
			case 39:
				newPosition = position + 1;
				gamPool.interchange(position, newPosition);
				player.setPosition(newPosition);
				gamPool.getPlayer().moveRight();
				break;
			case 40:
				newPosition = position + rowLenght;
				gamPool.interchange(position, newPosition);
				player.setPosition(newPosition);
				gamPool.getPlayer().moveDown();
				break;
			default:
				break;
			}
		}
		
	}
}
