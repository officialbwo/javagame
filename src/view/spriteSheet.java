package view;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class spriteSheet {
	private String path;
	private int width;
	private int height;
	
	public int[] pixels;
	
	public int getWidth() {
		return width;
	}
	
	public int getHeigth() {
		return height;
	}
	
	public String getPath() {
		return path;
	}
	
	public spriteSheet(String path) {
		this.path = path;
		BufferedImage image = null;
		try {
			image = ImageIO.read(spriteSheet.class.getResourceAsStream(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//the try and catch does this for us. this is inefficient
		if(image == null) {
			return;
		}
		
		this.path = path;
		this.width = image.getWidth(); 
		this.height = image.getHeight();
		
		pixels = image.getRGB(0,  0, width, height, null, 0, width);
	
		/*for(int i = 0; i < pixels.length; i++) {
			int indicator = (pixels[i] & 0xff);
			pixels[i] = indicator / 64;
		}*/
	}
}
