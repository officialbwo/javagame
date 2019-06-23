package view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Deque;

import javax.swing.JFrame;

public class window extends Canvas implements KeyListener {

	private static final long serialVersionUID = 1L;
	public JFrame frame; 
	private BufferedImage image;
	public int[] pixels;
	
	private String title;
	private int width, heigth;
	private Deque<Integer> events;
	
	public window(String title, int width, int heigth, Deque<Integer> events) {
		this.title 		= title;
		this.width 		= width;
		this.heigth 	= heigth;
		this.events		= events;
		
		createWindow();
	}
	
	private void createWindow() {
		
		frame = new JFrame(title);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.pack();
		frame.createBufferStrategy(3);
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.setMinimumSize(new Dimension(width, heigth));
		frame.setMaximumSize(new Dimension(width, heigth));
		frame.setPreferredSize(new Dimension(width, heigth));
		
		
		frame.addKeyListener(this);
		
		this.image			= new BufferedImage(this.width, this.heigth, BufferedImage.TYPE_INT_RGB);
		this.pixels			= ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	}
	
	public void draw() {
		BufferStrategy bs  = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			bs = this.getBufferStrategy();
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(this.image, 0, 0, width, heigth, null);
		g.dispose();
		bs.show();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		/* to continually walk along 
		 * the keypressed event has to be timed to not
		 * disproportianate change position of the object
		 */
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		events.addFirst(arg0.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	
}