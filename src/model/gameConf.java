package model;


public class gameConf {

	//game specific
	private final int SCALE 	= 2;
	private final int WIDTH 	= (512) * SCALE;
	private final int HEIGHT 	= (WIDTH/ 16 * 9); //Resolution
	private final String NAME 	= "adventureTiles";
	
	public int getWidth() {
		return this.WIDTH;
	}
	
	public int getHeight() {
		return this.HEIGHT;
	}
	
	public int getScale() {
		return this.SCALE;
	}
	
	public String getName() {
		return this.NAME;
	}
	
	
	
	//block specific
	private final int BLOCK_WIDTH 			= (256) * SCALE;
	private final int BLOCK_WIDTH_MASK 		= BLOCK_WIDTH - 1;
	private final int BLOCK_SIZE			= BLOCK_WIDTH * BLOCK_WIDTH;

	public int getBlockWidth() {
		return this.BLOCK_WIDTH;
	}
	
	public int getBlockWidthMask() {
		return this.BLOCK_WIDTH_MASK;
	}
	
	public int getBlockSize() {
		return this.BLOCK_SIZE;
	}
	

	
	//tile specific
	private final int TILE_WIDTH 			= (32) * SCALE;
	private final int TILE_SIZE 			= TILE_WIDTH * TILE_WIDTH;
	private final int TILELOG_BASE_2 		= (int) (Math.log(TILE_WIDTH)/Math.log(2)); //2(x) == TILEWIDTH
	
	public int getTileWidth() {
		return this.TILE_WIDTH;
	}

	public int getTileSize() {
		return this.TILE_SIZE;
	}
	
	public int getTileDivisor() {
		return TILELOG_BASE_2;
	}

	
	
	//pool class awaits
	private String initPath					= "/16_9_map.png";
	private String refPath					= "/16_9_reference.png";
	
	public String getinitPath() {
		return this.initPath;
	}
	
	public String getrefPath() {
		return this.refPath;
	}
}
