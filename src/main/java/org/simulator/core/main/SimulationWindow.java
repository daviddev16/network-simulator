package org.simulator.core.main;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;

/* !!!!scaling/mousing draggin test!!!! */
public class SimulationWindow extends JFrame {

	private static final long serialVersionUID = 3562214532860259471L;

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	private SimulationCanvas canvas;


	public boolean dragging  = false;
	public boolean dragging1  = false;

	public int lastX;

	public int lastY;
	

	public int x;

	public int y;

	public SimulationWindow(final String title) {
		canvas = new SimulationCanvas(WIDTH, HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(WIDTH, HEIGHT));
		setLocationRelativeTo(null);
		setResizable(false);
		add(canvas);
		pack();

		canvas.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {
				Mouse.mouseX = (arg0.getX()/Mouse.wheel) - Mouse.offsetX;
				Mouse.mouseY = (arg0.getY()/Mouse.wheel) - Mouse.offsetY;



			}

			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				
				if (dragging) {

					int draggingX = Mouse.offsetX + (arg0.getX() - lastX)/Mouse.wheel;
					int draggingY = Mouse.offsetY + (arg0.getY() - lastY)/Mouse.wheel;
					
					Mouse.offsetX = draggingX;
					Mouse.offsetY = draggingY;

					System.out.println(Mouse.offsetX + ", " + Mouse.offsetY);
					lastX = arg0.getX();
					lastY = arg0.getY();
				}

			}

		});

		canvas.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				dragging = false;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				lastX = e.getX();
				lastY = e.getY();
				dragging = true;
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub


			}
		});

		canvas.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {
					dragging1 = false;
				}

			}

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {
					dragging1 = true;
				}
			}
		});

		canvas.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {

				if (e.getWheelRotation() >= 1)
				{
					if(Mouse.wheel < 2) return;

					Mouse.wheel -= 1;
				} 
				else if(e.getWheelRotation() <= -1) 
				{
					if(Mouse.wheel > 10) return;
					Mouse.wheel += 1;
				}
				System.out.println(Mouse.wheel);
			}
		});
	}

	public SimulationCanvas getCanvas() {
		return canvas;
	}
}
