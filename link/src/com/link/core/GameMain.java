package com.link.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class GameMain extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static Color DarkColor = new Color(Integer.decode("#297ACC")); // 暗色
	public static Color LightColor = new Color(111, 146, 212); // 亮色
	public static ImageIcon[] icons = new ImageIcon[GameMode.Hard
			.getImgNumber()];
	public static Border nonChecked = BorderFactory.createLineBorder(DarkColor,
			1); // 未选中时的边框
	public static Border checked = BorderFactory.createLineBorder(Color.green,
			2); // 选中后的边框
	public static Border imitate = BorderFactory.createLineBorder(Color.red,
			3); // 提示的边框

	public static ImageIcon GuideIcon; //连线的图标
	
	Dimension faceSize = new Dimension(900, 600);

	JPanel actionPanel = new JPanel(); // 用户操作栏
	JPanel contentPanel = new JPanel(); // 容器
	Border emptyBorder = BorderFactory.createEmptyBorder(); // 未选中时的边框
	JButton normalMode = new JButton("普通模式"); 
	JButton easyMode = new JButton("简单模式"); 
	JButton hardMode = new JButton("困难模式"); 
	
	JButton suggest = new JButton("友情提示"); // "提示"
	JButton refresh = new JButton("友情刷新"); // "提示"
	
	JButton top = new JButton("排行榜"); // "提示"
	JButton exit = new JButton("退出"); // "提示"
	
	JButton[] pointButtons;

	GameMapUI mapUI;
	GameMap map;
	GameScore score;
	GameClock clock;
	GameLineBuilder animateDelete; 
	public GameMain() {

		map = new GameMap();
		pointButtons = new JButton[map.xLen * map.yLen];
		animateDelete = new GameLineBuilder(pointButtons);
		initResource();
		mapUI = new GameMapUI(map, pointButtons);
		score = new GameScore();
		clock = new GameClock();
		initUI();
		animateDelete.setSpeed(2);
		mapUI.gameScore = score;
		mapUI.clock = clock;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setSize(faceSize);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int) (screenSize.width - faceSize.getWidth()) / 2,
				(int) (screenSize.height - faceSize.getHeight()) / 2);
		this.setResizable(false);
		this.setTitle("连连看"); // 设置标题
	}

	public void initResource() {
		// 程序图标

		for (int i = 0; i < icons.length; i++) {
			icons[i] = new ImageIcon(getImage("img/" + (i + 1) + ".png"));
		}
		GuideIcon = new ImageIcon(getImage("img/dots.gif"));
		
		// 初始化方块
		for (int i = 0; i < pointButtons.length; i++) {
			pointButtons[i] = new JButton();
			pointButtons[i].setActionCommand("" + i);
			pointButtons[i].setBorder(nonChecked);
			pointButtons[i].setBackground(DarkColor);
		}

	}
	
	Image getImage(String filename) {
		URLClassLoader urlLoader = (URLClassLoader) this.getClass()
				.getClassLoader();
		URL url = null;
		Image image = null;
		url = urlLoader.findResource(filename);
		image = Toolkit.getDefaultToolkit().getImage(url);
		MediaTracker mediatracker = new MediaTracker(this);
		try {
			mediatracker.addImage(image, 0);
			mediatracker.waitForID(0);
		} catch (InterruptedException _ex) {
			image = null;
		}
		if (mediatracker.isErrorID(0)) {
			image = null;
		}

		return image;
	}

	public void initUI() {
		// 界面整体布局
		Border border = BorderFactory.createBevelBorder(BevelBorder.LOWERED,
				new Color(45, 92, 162), new Color(43, 66, 97), new Color(45,
						92, 162), new Color(84, 123, 200));
		BorderLayout borderLayout = new BorderLayout();

		actionPanel.setBackground(LightColor);
		actionPanel.setBorder(border);
		actionPanel.setPreferredSize(new Dimension(160, 380));
		actionPanel.setMinimumSize(new Dimension(160, 380));
		

		contentPanel.setBackground(DarkColor);
		contentPanel.setBorder(border);
		contentPanel.setPreferredSize(new Dimension(740, 560));
		contentPanel.setMinimumSize(new Dimension(740, 560));

		this.getContentPane().setLayout(borderLayout);
		this.getContentPane().add(actionPanel, BorderLayout.WEST);
		this.getContentPane().add(contentPanel, BorderLayout.CENTER);

		// 加入地图
		contentPanel.add(mapUI);

		actionPanel.add(score);

		actionPanel.add(normalMode);
		normalMode.setBorder(emptyBorder);
		normalMode.setMinimumSize(new Dimension(154, 48));
		normalMode.setPreferredSize(new Dimension(154, 48));
		normalMode.setFont( new Font("宋体", Font.PLAIN, 30) );
		normalMode.addActionListener(this);

		actionPanel.add(easyMode);
		easyMode.setBorder(emptyBorder);
		easyMode.setMinimumSize(new Dimension(154, 48));
		easyMode.setPreferredSize(new Dimension(154, 48));
		easyMode.setFont( new Font("宋体", Font.PLAIN, 30) );
		easyMode.addActionListener(this);

		// 加入提示按钮
		actionPanel.add(hardMode);
		hardMode.setBorder(emptyBorder);
		hardMode.setMinimumSize(new Dimension(154, 48));
		hardMode.setPreferredSize(new Dimension(154, 48));
		hardMode.setFont( new Font("宋体", Font.PLAIN, 30) );
		hardMode.addActionListener(this);

		// 加入提示按钮
		actionPanel.add(suggest);
		suggest.setBorder(emptyBorder);
		suggest.setMinimumSize(new Dimension(154, 48));
		suggest.setPreferredSize(new Dimension(154, 48));
		suggest.setFont( new Font("宋体", Font.PLAIN, 30) );
		suggest.addActionListener(this);

		// 加入提示按钮
		actionPanel.add(refresh);
		refresh.setBorder(emptyBorder);
		refresh.setMinimumSize(new Dimension(154, 48));
		refresh.setPreferredSize(new Dimension(154, 48));
		refresh.setFont( new Font("宋体", Font.PLAIN, 30) );
		refresh.addActionListener(this);
				
		
		actionPanel.add(top);
		top.setBorder(emptyBorder);
		top.setMinimumSize(new Dimension(154, 48));
		top.setPreferredSize(new Dimension(154, 48));
		top.setFont( new Font("宋体", Font.PLAIN, 30) );
		top.addActionListener(this);
		// 加入提示按钮
		actionPanel.add(exit);
		exit.setBorder(emptyBorder);
		exit.setMinimumSize(new Dimension(154, 48));
		exit.setPreferredSize(new Dimension(154, 48));
		exit.setFont( new Font("宋体", Font.PLAIN, 30) );
		exit.addActionListener(this);
		// 加入时钟
		actionPanel.add(clock);
				

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == normalMode) { // 开始
			map = new GameMap();
			mapUI.map = map;
			mapUI.start();
			clock.start(map.getMode().getFinishTime());
			score.setScore(-1, 0);
		} else if (obj == easyMode) { // 开始
			map = new GameMap(GameMode.Easy);
			mapUI.map = map;
			mapUI.start();
			clock.start(map.getMode().getFinishTime());
			score.setScore(-1, 0);
		} else if (obj == hardMode) { // 开始
			map = new GameMap(GameMode.Hard);
			mapUI.map = map;
			mapUI.start();
			clock.start(map.getMode().getFinishTime());
			score.setScore(-1, 0);
		} else if (obj == suggest) { // 开始
			mapUI.findNext(new Point( -1, -1));
		} else if (obj == refresh) { // 开始
			mapUI.refresh();
		} else if (obj == exit) {
			this.dispose();
		} else if (obj == top) {
			new GameTop10(this);
		}

	}

	public static void main(String args[]) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		GameMain game = new GameMain();
		game.show();
	}

}
