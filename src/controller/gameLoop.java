package controller;

import controller.time.*;
import model.gameConf;
import model.gamePool;
import view.window;

public class gameLoop implements Runnable {
	public timer gameLoop 	= new timer();
	
	public boolean running 	= false;
	private gameConf gamConf;
	private gamePool gamPool;
	private window w;
	
	public gameLoop(gameConf conf) {
		this.gamConf 	= conf;
		this.gamPool = new gamePool(conf);
		this.w		= new window(conf.getName(), conf.getWidth(), conf.getHeight(), gamPool.events);
	}

	public synchronized void start() {
		running 	= true;
		new Thread(this).start();
	}
	
	public synchronized void stop() {
		running 	= false;
	}
	
	
	@Override
	public void run() {
		
		tick t 										= new tick();
		frame f 									= new frame();
		controller.graphics.update graphicsUpdate 	= new controller.graphics.update(gamConf, 0);
		controller.physics.update physicsUpdate		= new controller.physics.update(gamPool, gamConf);
		
		long now 	= System.nanoTime();
		
		while(running) {
			long elapsed = System.nanoTime() - now;
			
			while(t.delta(elapsed, t)) {
				long msUpdate = update(t, graphicsUpdate, physicsUpdate);
				elapsed -= msUpdate;
			};
			
			if(f.delta(elapsed, f)) {
				render(f);
			};
			
			if(elapsed >= 1000000000) {
				debugMsg(t, f);
				t.resetTicks();
				f.resetFrames();
				now = System.nanoTime();
			};
		}
	}

	
	
	private void debugMsg(
			tick t, 
			frame f
	  ) {
		
		System.out.println("Frames: " + f.getFrames() + " Ticks: " + t.getTicks()); 
	}
	
	
	private long update(
		tick t, 
		controller.graphics.update graphicsUpdate,
		controller.physics.update physicsUpdate
	  ) {
		
		timer update 	= new timer();
		physicsUpdate.refresh();
		w.pixels = graphicsUpdate.refresh(w.pixels, gamPool);
		return update.elapsed();
	}

	
	private long render(
			frame f
	  ) {
			
		timer render 	= new timer();
		w.draw();
		return render.elapsed();
	}
}