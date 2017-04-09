package com.link.core;

import java.awt.Point;

public class GameLine {

	public Point a;
	public Point b;
	public int direct;

	public GameLine(){
	}

	
	public GameLine(int direct, Point a, Point b){
		this.a = a;
		this.b = b;
		this.direct = direct;
	}
}
