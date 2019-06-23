package model.playerTypes;

import model.entity;

public abstract class player implements entity {
	
	
	protected int position	= 0;
	protected int indicator = 0;
	protected int color		= 0;
	protected int posX 		= 0;
	protected int posY 		= 0;
	protected int basis 	= 0;
	protected int hoehe 	= 0;
	
	public player(
			int position, 
			int indicator,
			int color,
			int posX, 
			int posY, 
			int basis, 
			int hoehe
			) {
		this.position	= position;
		this.indicator  = indicator;
		this.color		= color;
		this.posX 		= posX;
		this.posY 		= posY;
		this.basis 		= basis;
		this.hoehe 		= hoehe;
	}
	
	
	public void moveLeft() {
		
		this.posX -= 1;
		System.out.println(this.posY + " " + this.posX);
	}
	
	public void moveUp() {
		this.posY -= 1;
		System.out.println(this.posY + " " + this.posX);
		
	}
	
	public void moveRight() {
		this.posX += 1;
		System.out.println(this.posY + " " + this.posX);
	}
	
	public void moveDown() {
		this.posY += 1;
		System.out.println(this.posY + " " + this.posX);
	}
}
