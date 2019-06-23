package model.playerTypes;




public class prota extends player {

	private int dach = 0xF44444;
	private int wand = 0xF40404;
	private String name = "red";
	
	@Override
	public void info() {
		System.out.println("i am the protagonist");
	}
	
	public prota(int position, int indicator, int color, int posX, int posY, int tileWidth) {
		super(position, indicator, color, posX, posY, tileWidth, tileWidth/2);
	}
	
	@Override
	public int getX() { return this.posX; }

	@Override
	public int getY() { return this.posY; }

	@Override
	public int getBasis() { return this.basis; }

	@Override
	public int getHoehe() { return this.hoehe; }

	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getPosition() {
		return this.position;
	}
	
	@Override
	public int getIndicator() {
		return this.indicator;
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
		this.indicator = indicator;
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
			for(int x = xMin; x < xMax; x++) {
				if( (y & (this.basis - 1)) < this.hoehe) {
					if (y > this.hoehe) {
						pixels[x + (y - this.hoehe) * rowLength] = dach;
					}
					pixels[x + (y * rowLength)] = dach;
				} else {
					pixels[x + (y * rowLength)] = wand;
				}
			}
		}
		return pixels;
	}

	
	
}
