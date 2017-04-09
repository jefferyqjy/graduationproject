package com.link.core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class GameClock extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private volatile Thread thread;
	long startTime = 0l; // 开始时间
	long usedTime = 0l; // 使用时间
	int maxTime = 0;

	Color color = new Color(212, 255, 200);
	Font font48 = new Font("serif", Font.PLAIN, 28);
	java.text.DecimalFormat df = new java.text.DecimalFormat("000");

	public GameClock() {
		this.setMinimumSize(new Dimension(154, 48));
		this.setPreferredSize(new Dimension(154, 48));
	}

	/**
	 * 时间的绘制
	 */
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Dimension d = getSize();
		g2.setBackground(new Color(111, 146, 212));
		g2.clearRect(0, 0, d.width, d.height);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(color);
		g2.setFont(font48);

		g2.drawString("剩余:" + maxTime +"秒", 16, 40);
		maxTime --;
	}

	/**
	 * 取得使用时间格式化后的字符串
	 */
	String getTime() {
		int sec;
		long time;
		time = usedTime;
		sec = Math.round(time / 1000);
		time -= sec * 1000;
		return (df.format(sec) );
	}

	public void start(int maxTime) {
		startTime = System.currentTimeMillis();
		this.maxTime =maxTime;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		Thread currentThread = Thread.currentThread();
		while (thread == currentThread) {
			try {
				repaint();
				thread.sleep(1000);
				if (maxTime <= 0) {
					stop();
				}
			} catch (InterruptedException ex) {
			}
		}
	}

	public void stop() {
		if (thread != null) {
			thread = null;
		}
	}

	/**
	 * 取得用户使用的时间
	 */
	public int getUsedTime() {
		return Math.round(usedTime / 1000);
	}

}