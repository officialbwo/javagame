package model;


import java.util.ArrayDeque;
import java.util.Deque;

import model.mapTypes.map;
import model.playerTypes.prota;
import view.spriteSheet;

public class gamePool {
	
	//init
	private int frameWidth;
	private int columns;
	private int rows;
	private int tileWidth;
	private int tileDivisor;
	
	//pools
	
	/*
	 * the central misconception is that i use the initial bitmap
	 * as reference for creating my entities. this gives the bitmap
	 * 2 functions instead of only one. it serves as indicator where i 
	 * should place my entities on the map at initialization and it serves
	 * as reference on which properties my entities have. this is BAD!!! bad ainsley
	 * the bottleneck is i have to use the bitmap twice and therefor need to additionally 
	 * update it while i could use a static positional reference.
	 * 
	 * 
	 * TODO:
	 * additional spritesheet placing a static reference to the objects into the game conf.
	 * convert the entity array into something efficient where the array components are a hash
	 * consisting of an entity object and a value representing their fluidity. fluidity is the how
	 * little the predicted amount of time between possible necessary updates. so the most frequent 
	 * updated objects are updated first while once arrived at the first least updated objects(ground)
	 * the program can assume every following object in the iteration is automatically a ground. 
	 */
	public int[] reference;
	public int[] state;
	
	public Deque<Integer> events;
	//choose a fast iterable array 
	public entity[] entities;
	
	//factories
	private entityFactory entFact;
	private prota player;
	private map ground;
	
	
	//make singleton there is only one and only gameFactory
	public gamePool(gameConf conf){
		
		this.reference		= new spriteSheet(conf.getrefPath()).pixels;
		this.state 			= new spriteSheet(conf.getinitPath()).pixels;
		this.entities		= new entity[this.state.length];
		this.frameWidth		= conf.getWidth();
		this.tileWidth		= conf.getTileWidth();
		this.tileDivisor	= conf.getTileDivisor();
		this.entFact		= new entityFactory(this.tileWidth);
		this.rows			= conf.getHeight() >> conf.getTileDivisor();
		this.columns		= this.frameWidth >> this.tileDivisor;
		this.events			= new ArrayDeque<Integer>();
				
		init();
	}
	
	public prota getPlayer() {
		return this.player;
	}
	
	public map getGround() {
		return this.ground;
	}
	
	public void setPlayer(String name) {
		//carefull sets the last found entity with ident name to player!
		entity player = null;
		if (entities.length > 0) {
			for(int i = 0; i < state.length; i++) {
				if(entities[i].getName() == name) {
					player = entities[i];
				}
			}
		}
	}
	
	//getentity
	public entity getEntityPos(int yTile, int xTile) {
		
		if (entities.length > 0) {
			for ( int i = 0; i < state.length; i++ ) {
				if(entities[i] == null) {
					return getEntRaw(yTile, xTile);
				}
				if(entities[i].getX() == xTile && entities[i].getY() == yTile) {
					return entities[i];
				}
			}
		}
		return getEntRaw(yTile, xTile);
	}
	
	
	private void init() {
		//this.events = new Deque();
		for ( int i = 0; i < state.length; i++ ) {
			this.entities[i] = null;
			
			int yTile = Math.floorDiv(i, columns);
			int xTile = i & (columns - 1);
			
			entity e = getEntRaw(yTile, xTile);
			if(e.getName() == "red") {
				this.player = (prota)e;
			}
			if(e.getName() == "green") {
				this.ground = (map)e;
			}
			this.entities[i] = e;
		}
	}
	
	private entity getEntRaw(int yTile, int xTile) {
		int position = xTile + (yTile * (this.frameWidth/this.tileWidth));
		int color = state[position];
		
		return entFact.getE(position, color, yTile, xTile);
	}
	
	public void interchange(int position, int newPosition) {
		
		int yTile = Math.floorDiv(position, columns);
		int xTile = position & (columns - 1);
		
		int newyTile = Math.floorDiv(newPosition, columns);
		int newxTile = newPosition & (columns - 1);
		entity e = getEntityPos(newyTile, newxTile);
		e.setX(xTile);
		e.setY(yTile);
		e.setPosition(position);
		
		int tempcolor = state[newPosition];
		state[newPosition] = state[position];
		state[position] = tempcolor;
	}
}
