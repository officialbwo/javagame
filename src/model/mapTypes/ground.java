package model.mapTypes;

public class ground extends map {

	private int light 		= 0x75FF33;	
	private int dark 		= 0x33FF57;
	private int[] colors 	= { light, dark };
	private String name 	= "green";
	
	public void info() {
		System.out.println("I am a Ground");
	}
	
	public ground(int position, int indicator, int color, int posX, int posY, int tileWidth) {
		super(position, indicator, color, posX, posY, tileWidth, tileWidth);
	}
	
	public int getX() { return this.posX; }
	
	public int getY() { return this.posY; }
	
	public int getBasis() { return this.basis; }
	
	public int getHoehe() { return this.hoehe; }
	
	@Override
	public int getIndicator() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int getPosition() {
		return this.position;
	}

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getColor() {
		// TODO Auto-generated method stub
		return this.color;
	}


	@Override
	public void setX(int x) {
		this.posX = x;
	}

	@Override
	public void setY(int y) {
		this.posY = y;
	}

	@Override
	public void setBasis(int basis) {
		this.basis = basis;
	}

	@Override
	public void setHoehe(int hoehe) {
		this.hoehe = hoehe;
	}
	

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public void setIndicator(int indicator) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void setColor(int color) {
		// TODO Auto-generated method stub
		this.color = color;
	}

	
	
	@Override
	public int[] draw(
			int[] pixels,
			int yMin, 
			int xMin,
			int tileWidth,
			int rowLength
	) {
		int yMax = yMin + tileWidth;
		int xMax = xMin + tileWidth;
		for(int y = yMin; y < yMax; y++) {
			int row = y * rowLength;
			for(int x = xMin; x < xMax; x++) {
				pixels[x + row] = colors[(this.posX + this.posY) & 1];
			}
		}
		return pixels;
	}

	
	

	
}
