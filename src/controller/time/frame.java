package controller.time;

public class frame {

	private int frames 				= 0;
	private final double nsPerFrame = 1000000000D/60D;

	public frame() {};
	
	//difference time between lastupdate doesnt exceed set limit of nsPerFrame
	public boolean delta(long diff, frame f) {
		
		if((diff - nsPerFrame * f.frames)/nsPerFrame >= 1){
			f.addFrame();
			return true;
		};
		
		return false;
	}

	
	public void addFrame() {
		this.frames += 1;
	}
	
	public void subFrame() {
		this.frames -= 1;
	}
	
	
	public void resetFrames() {
		frames = 0;
	}

	
	public int getFrames() {
		return frames;
	}

}
