package controller.graphics;

import model.entity;
import model.gameConf;
import model.gamePool;

public class update {
	
	private int width;
	private int height;
	private int tileWidth;
	private int tileDivisor;
	private int yOffset;
	private int xOffset;
	
	public update(gameConf conf, int offset) {
		this.width 			= conf.getWidth();
		this.height 		= conf.getHeight();
		this.tileWidth		= conf.getTileWidth();
		this.tileDivisor	= conf.getTileDivisor();
		this.yOffset		= offset;
		this.xOffset		= offset;
	}
	
	public int[] refresh(int[] windowPixels, gamePool gamPool) {
		
		for(int yTile = yOffset >> tileDivisor; yTile < (yOffset + height) >> tileDivisor; yTile++) {
			int yMin = yTile * tileWidth - yOffset;
			int yMax = yMin + tileWidth;
			if (yMin < 0) yMin = 0;
			if (yMax > height) yMax = height;
			
			for(int xTile = xOffset >> tileDivisor; xTile < (xOffset + width) >> tileDivisor; xTile++) {
				int xMin = xTile * tileWidth - xOffset;
				int xMax = xMin + tileWidth;
				if (xMin < 0) xMin = 0;
				if (xMax > width) xMax = width;
				
				entity e = gamPool.getEntityPos(yTile, xTile);
				windowPixels = e.draw(windowPixels, yMin, xMin, tileWidth, width);
			}
		}
		return windowPixels;
	}
}
