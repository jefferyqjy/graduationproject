package com.link.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GameScore extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private volatile Thread thread;
	//private boolean isPainting = false;
	public int lastScore, currentScore;
	Color color = new Color(255, 255, 0);
	Font font48 = new Font("serif", Font.BOLD, 42);
	java.text.DecimalFormat df = new java.text.DecimalFormat("0000");

	/**
	 * ���캯��
	 */
	public GameScore() {
		this.setMinimumSize(new Dimension(156, 48));
		this.setPreferredSize(new Dimension(156, 48));
	}

	/**
	 * ����Ļ���
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension d = getSize();
		g2.setBackground(new Color(111, 146, 212));
		g2.clearRect(0, 0, d.width, d.height);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.setFont(font48);
		g2.drawString("￥" + df.format(lastScore), 20, 40);
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		Thread currentThread = Thread.currentThread();
		while (thread == currentThread && lastScore < currentScore) {
			try {
				lastScore++;
				repaint();
				thread.sleep(50l);
			}
			catch (InterruptedException ex) {
			}
		}
	}

	public void setScore(int l, int c) {
		this.lastScore = l;
		this.currentScore = c;
		start();
	}

	public void stop() {
		if (thread != null) {
			thread = null;
		}
	}

}