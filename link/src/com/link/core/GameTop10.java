package com.link.core;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GameTop10 extends JDialog{

	JPanel Panel1 = new JPanel();
	JButton Close = new JButton();
	Border border2;
	public GameTop10(JFrame frame) {
		super(frame, true);
		try {
			jbInit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//设置运行位置，使对话框居中
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation( (int) (screenSize.width - 560) / 2,
						 (int) (screenSize.height - 400) / 2);
		this.setResizable(false);
		this.show();
	}
	
	private void jbInit() throws Exception {
		border2 = BorderFactory.createCompoundBorder(
			BorderFactory.createLineBorder(
				Color.lightGray, 1), BorderFactory.createEmptyBorder(2, 10, 2, 10));
		this.setSize(new Dimension(560, 360));
		this.setTitle("积分榜");
		
		URLClassLoader urlLoader = (URLClassLoader)this.getClass().getClassLoader();
		URL url =  urlLoader.findResource("doc/top.txt");
		 ObjectInputStream is = null;
		try {  
			 
			 is = new ObjectInputStream(new FileInputStream(  
					 url.getFile()));  
			 if (is != null) {
				 List<UserScore> top10Score = (List<UserScore>) is.readObject();
				 Collections.sort(top10Score, new ComparatorUserScore());
				 for (int i=0; i < top10Score.size(); i++) {
					 UserScore us = top10Score.get(i);
					 JLabel label = new JLabel("第" + (i+1) +"名： " + us.getName() +"----" + us.getScore() +"分");
					 label.setBounds(0, i * 30, 400, 30);
					 this.add(label, BorderLayout.SOUTH);
				 }
			 }
			 
			 
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 if (is != null) {
				 is.close();
			 }
		 }
	
		
		Close.setBackground(Color.white);
		Close.setBorder(border2);
		Close.setActionCommand("jButton1");
		Close.setText("关闭");
		Close.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			}
		);

		Panel1.setBackground(Color.white);
		this.getContentPane().add(Panel1, BorderLayout.SOUTH);
		Panel1.add(Close, null);
	}
}
