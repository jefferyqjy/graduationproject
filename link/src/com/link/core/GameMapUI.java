package com.link.core;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameMapUI extends JPanel implements ActionListener, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected GameMap map;
	protected JButton[] pointButtons;

	protected Point lastPoint = new Point(0, 0); //上一个点的坐标
	protected boolean isSelected = false; //是否已经选择了一个点

	protected GameScore gameScore; //记录用户的得分
	int score;
	protected GameClock clock; //同步显示时钟
	
	protected int xLen;
	protected int yLen;
	protected boolean isPlaying = false; //当前是否正在游戏中
	protected int limitTime;
	public GameMapUI(GameMap map, JButton[] pointButtons) {
		this.map = map;
		this.pointButtons = pointButtons;
		xLen = map.getxLen();
		yLen = map.getyLen();
		GridLayout gridLayout = new GridLayout();
		this.setLayout(gridLayout);
		gridLayout.setRows(yLen);
		gridLayout.setColumns(xLen);
		gridLayout.setHgap(2);
		gridLayout.setVgap(2);
		this.setLayout(gridLayout);
		this.setBackground(GameMain.DarkColor);
		
		for (int row = 0; row < yLen; row++) {
			for (int col = 0; col < xLen; col++) {
				int index = row *xLen + col;
				pointButtons[index].addActionListener(this);
				this.add(pointButtons[index]);
			}
		}
	}
	
	private void paint() {
		int pics = 0;
		for (int row = 0; row < yLen; row++) {
			for (int col = 0; col < xLen; col++) {
				int index = row * xLen + col;
				pointButtons[index].setMinimumSize(new Dimension(34, 34));
				pointButtons[index].setPreferredSize(new Dimension(34, 34));
				if (map.pointStatus[row][col] > 0) {
					pointButtons[index].setIcon(GameMain.icons[map.pointStatus[row][col] - 1]);
					pointButtons[index].setEnabled(true);
					pics ++;
				}
				else {
					pointButtons[index].setIcon(null);
					pointButtons[index].setEnabled(false);
				}
			}
		}
		System.out.println("pics=" + pics);
	}

	public void repaint(Graphics g) {
		paint();
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public void start() {
		score = 0;
		isPlaying = true;
		limitTime = map.getMode().getFinishTime();
		paint();
	}
	
	public void start(int score, int limitTime) {
		this.score += score;
		isPlaying = true;
		this.limitTime = map.getMode().getFinishTime() + limitTime;
		paint();
	}

	public void refresh() {
		if (!isPlaying) { //不在游戏中,返回
			return;
		}
		
	
		map.refresh();
		paint();
	}

	public void findNext(Point a) {
		if (!isPlaying) { //不在游戏中,返回
			return;
		}
		if (map.getCount() == 0) {
			return;
		}
		GameLine line = new GameLine(0, new Point(), new Point());
		map.imitate = true; //告诉map当前只是测试，并不需要进行删除动画
		line = map.findNext(a);
		int offset = 0;
		if (line.direct == 1) { //找到了可消除的
			offset = line.a.x * map.xLen + line.a.y;
			pointButtons[offset].setBorder(GameMain.imitate);
			offset = line.b.x * map.xLen + line.b.y;
			pointButtons[offset].setBorder(GameMain.imitate);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (clock.maxTime <= 0) {
			stop();
			
			String name = JOptionPane.showInputDialog(this, "时间到，你失败了，请输入名字:", "路人甲");
			if (!"".equals(name.trim())) { //如果留了名字
				UserScore us = new UserScore();
				us.setName(name);
				us.setScore(score);
				URLClassLoader urlLoader = (URLClassLoader)this.getClass().getClassLoader();
				URL url =  urlLoader.findResource("doc/top.txt");
				 ObjectInputStream is = null;
				 ObjectOutputStream os = null;
				try {  
					 InputStream iss = new FileInputStream(  
							 url.getFile());
					 is = new ObjectInputStream(iss);  
					
					 List<UserScore> top10Score = (List<UserScore>) is.readObject();
					 is.close();
					 if (top10Score == null) {
						 top10Score = new ArrayList<UserScore>();
					 }
					 top10Score.add(us);
					 os = new ObjectOutputStream(  
			                    new FileOutputStream( url.getFile()));  
					 os.writeObject(top10Score);
				 } catch (Exception ex) {
					 try {
						 os = new ObjectOutputStream( new FileOutputStream( url.getFile()));  
						 List<UserScore> top10Score = new ArrayList<UserScore>();
						 top10Score.add(us);
						 os.writeObject(top10Score);
					 }catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					 
				 } finally {
					 
					 try {
						if (is != null) {
							 is.close();
						 }
						
						if (os != null) {
							 os.close();
						 }
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				 }
				
				
			}
			return;
		}
		JButton button = (JButton) e.getSource();
		int offset = Integer.parseInt(button.getActionCommand());
		int row, col;
		row = Math.round(offset / map.xLen);
		col = offset - row * map.xLen;
		//如果上面没有图片
		if (map.pointStatus[row][col] < 1) {
			return;
		}
		
		if (isSelected) {		
			if (lastPoint.x == row && lastPoint.y == col) { 
				button.setBorder(GameMain.nonChecked);
				isSelected = false;
			} else {
				Point current = new Point(row, col);
				map.imitate = false;
				if (map.test(lastPoint, current)) {
					pointButtons[row * map.xLen + col].setBorder(GameMain.nonChecked);
					map.earse(current, lastPoint);
					earse(current, lastPoint);
					pointButtons[lastPoint.x * map.xLen +
							lastPoint.y].setBorder(GameMain.nonChecked);
						lastPoint = new Point(0, 0);
						isSelected = false;
						showScore(score, score + 5 );
						score += 5 ;
				} else {
					pointButtons[lastPoint.x * map.xLen +
							lastPoint.y].setBorder(GameMain.nonChecked);
						button.setBorder(GameMain.checked);
						lastPoint.x = row;
						lastPoint.y = col;
						isSelected = true;
				}
			}
		} else {
			button.setBorder(GameMain.checked);
			lastPoint.x = row;
			lastPoint.y = col;
			isSelected = true;
		}
	}
	
	void earse(Point a, Point b) {
		//paint();

		int offset;
		offset = a.x * map.xLen + a.y;
		pointButtons[offset].setIcon(null);
		pointButtons[offset].setEnabled(false);

		offset = b.x * map.xLen + b.y;
		pointButtons[offset].setIcon(null);
		pointButtons[offset].setEnabled(false);

		//如果地图清除完成，关闭
		if (map.getCount() == 0) {
			int remainTime = limitTime - clock.getUsedTime();
			if (remainTime > 0) {
				showScore(score, score + remainTime * 10);
				score += remainTime * 10;
			}
			isPlaying = false;
			stop();
			map.init();
			start(score, remainTime);
			clock.start(map.getMode().getFinishTime() + remainTime);
			
		}
		else {
			//test1(map.getDeleteArray());
		}
	}
	public void stop() {
		clock.stop();
	}
	
	private void showScore(int l, int c) {
		if (gameScore == null) {
			return;
		}
		gameScore.setScore(l, c);
	}
	
}
