package model.mapTypes;

import model.entity;

public abstract class map implements entity {

	protected int position	= 0;
	protected int indicator = 0;
	protected int color 	= 0;
	protected int posX 		= 0;
	protected int posY 		= 0;
	protected int basis 	= 0;
	protected int hoehe 	= 0;
	
	public map(int position, int indicator, int color, int posX, int posY, int basis, int hoehe) {
		this.position  	= position;
		this.indicator  = indicator;
		this.color 		= color;
		this.posX 		= posX;
		this.posY 		= posY;
		this.basis 		= basis;
		this.hoehe 		= hoehe;
	}
}
