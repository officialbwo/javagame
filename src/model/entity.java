package model;

public interface entity {
	
	public void info();
	
	public int getX();
	
	public int getY();
	
	public int getBasis();
	
	public int getHoehe();
	
	public String getName();
	
	public int getPosition();
	
	public int getIndicator();
	
	public int getColor();

	public void setX(int x);
	
	public void setY(int y);
	
	public void setBasis(int basis);
	
	public void setHoehe(int hoehe);
	
	public void setName(String name);
	
	public void setPosition(int position);
	
	public void setIndicator(int indicator);
	
	public void setColor(int color);
	
	public int[] draw(
		int[] pixels,
		int yMin, 
		int xMax,
		int tileWidth,
		int rowLength
	);
}
