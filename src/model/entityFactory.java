package model;


import model.entity;
import model.mapTypes.*;
import model.playerTypes.*;

public class entityFactory {
	private int tileWidth;
	
	//possible singleton
	public entityFactory(int tileWidth) {
		this.tileWidth 	= tileWidth;
	}
	
	public entity getE(int position, int color, int yTile, int xTile) {
		
		//8 possibilities to keep the code snappy and a single file short. 
		//variation is not that relevant. 
		int indicator = (color & 0xff) / 64;
		
		switch(indicator) {
		case 0:
			return new beton(position, indicator, color, xTile, yTile, tileWidth);
		case 1:
			return new prota(position, indicator, color, xTile, yTile, tileWidth);
		case 2:
			return new holz(position, indicator, color, xTile, yTile, tileWidth);
		case 3:
			return new ground(position, indicator, color, xTile, yTile, tileWidth);
		default:
			return new ground(position, indicator, color, xTile, yTile, tileWidth);
		}
	}
	
}