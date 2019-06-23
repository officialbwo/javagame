package controller.time;

public class timer {
	private long start;
	
	
	public timer(){
		this.start = System.nanoTime();
	}
	
	public long elapsed() {
		return System.nanoTime() - this.start;
	}
}
