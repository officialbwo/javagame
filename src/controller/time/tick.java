package controller.time;

public class tick {

	private int ticks = 0;
	private final double nsPerTick = 1000000000D/600D;

	public tick() {};
	
	//difference time between lastupdate doesnt exceed set limit of nsPerTick
	public boolean delta(long diff, tick t) {
		if((diff - nsPerTick * t.ticks)/nsPerTick >= 1){
			t.addTick();
			return true;
		};
		return false;
	}
	
	public void addTick() {
		this.ticks += 1;
	}
	
	public void subTick() {
		this.ticks -= 1;
	}
	
	public void resetTicks() {
		this.ticks = 0;
	}
	
	public int getTicks() {
		return ticks;
	}
}
