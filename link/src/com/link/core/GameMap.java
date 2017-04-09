package com.link.core;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class GameMap {

	protected int pointStatus[][];
	protected int xLen;
	protected int yLen;
	protected int side;
	protected boolean imitate;
	protected Vector<GameLine> vector;
	protected GameMode mode;
	GameLineBuilder animate;
	protected int blockSize;
	int [] array;
	public GameMap() {
		mode = GameMode.Normal;
		init();
	}

	public GameMap(GameMode mode) {
		this.mode = mode;
		init();
	}

	public static void main(String[] args) {
		new GameMap();
	}

	protected void init() {
		xLen = 20;
		yLen = 15;
		side = 40;
		imitate = false;
		vector = new Vector<GameLine>();
		pointStatus = new int[yLen][xLen];
		blockSize = mode.getImgNumber() * 2 * mode.getImgCouples();
		array = new int [blockSize];
		for (int i = 1; i <= mode.getImgNumber(); i++) {
			for (int j=1; j <= mode.getImgCouples() * 2; j++) {
				int k = (i-1) * mode.getImgCouples() * 2 + (j-1);
				array[k] = i;
			}
		}
		
		initImgs(blockSize);
		
	}

	public void refresh(){
		int count = getCount();
		if(count <= 0)
			return;
		
		array = new int [blockSize];
		int index = 0;
		for (int i = 0; i < yLen; i++) {
			for (int j=0; j < xLen; j++) {
				if (pointStatus[i][j] > 0) {
					array[index] = pointStatus[i][j];
					index ++;
				}
			}
		}
		
		pointStatus = new int[yLen][xLen];
		
		initImgs(blockSize);

	}
	private void initImgs(int loopSize) {
		
		
		int newloopSize = 0;
		for (int i = 0; i < loopSize; i++) {
			int randomIndex = CommonUtil.random(xLen * yLen);

			if (randomIndex == 0) {
				if (pointStatus[0][0] > 0) {
					newloopSize++;
				} else {
					pointStatus[0][0] = random();
				}
				continue;
			}

			int rX = (randomIndex + 1) / xLen;
			int rY = (randomIndex + 1) % xLen;
			if (rY == 0) {
				rY = yLen;
				rX--;
			}
			if (pointStatus[rX][rY] > 0) {
				newloopSize++;
			} else {
				pointStatus[rX][rY] =  random();
			}
		}

		if (newloopSize > 0) {
			initImgs(newloopSize);
		}
	}

	public int random() {
		int index = CommonUtil.random(array.length);
		if (array[index] == 0) {
			return random();
		} else {
			int result = array[index];
			array[index] = 0;
			List<Integer> list= new ArrayList<Integer>();
			for (int i:array) {
				if (i!=0) {
					list.add(i);
				}
			}
			array = new int[list.size()];
			for (int i=0; i< list.size(); i++) {
				array[i] = list.get(i);
			}
			return result;
		}
	}
	
	public void earse(Point a, Point b) {
		pointStatus[a.x][a.y] = 0;
		pointStatus[b.x][b.y] = 0;
		blockSize -= 2;
	}

	public int getCount() {
		return blockSize <= 0 ? 0 : blockSize;
	}

	private boolean horizon(Point a, Point b, boolean recorder) {
		if (a.x == b.x && a.y == b.y)
			return false;
		if (a.x == b.x && (a.x == 0 || a.x == 14)) {
			return true;
		}
		int x_start = a.y <= b.y ? a.y : b.y;
		int x_end = a.y <= b.y ? b.y : a.y;
		for (int x = x_start + 1; x < x_end; x++)
			if (pointStatus[a.x][x] != 0)
				return false;
		
		if(!imitate && recorder)
			animate = new GameLineBuilder(1, a, b);
		
		return true;
	}

	private boolean vertical(Point a, Point b, boolean recorder) {
		if (a.x == b.x && a.y == b.y)
			return false;
		if (a.y == b.y && (a.y == 0 || a.y == 19)) {
			return true;
		}
		int y_start = a.x <= b.x ? a.x : b.x;
		int y_end = a.x <= b.x ? b.x : a.x;
		for (int y = y_start + 1; y < y_end; y++)
			if (pointStatus[y][a.y] != 0)
				return false;

		if(!imitate && recorder)
			animate = new GameLineBuilder(0, a, b);
		
		return true;
	}

	private boolean oneCorner(Point a, Point b) {
		Point c = new Point(a.x, b.y);
		Point d = new Point(b.x, a.y);
		if (pointStatus[c.x][c.y] == 0) {
			boolean method1 =  horizon(a, c, false) && vertical(b, c, false);
			if(method1 && !imitate){
				if(!imitate)
					animate = new GameLineBuilder(1, a, c, b);
				return method1;
			}
		} 
		
		if (pointStatus[d.x][d.y] == 0) {
			boolean method1 =  vertical(a, d, false) && horizon(b, d, false);
			if(method1)
				if(!imitate)
					animate = new GameLineBuilder(0, a, d, b);
				return method1;
		} else {
			return false;
		}
	}

	private Vector<GameLine> scan(Point a, Point b) {
		Vector<GameLine> v = new Vector<GameLine>();
		for (int y = a.y; y >= 0; y--)
			if (pointStatus[a.x][y] == 0 && pointStatus[b.x][y] == 0 && vertical(new Point(a.x, y), new Point(b.x, y), false))
				v.add(new GameLine(0, new Point(a.x, y), new Point(b.x, y)));

		for (int y = a.y; y < xLen; y++)
			if (pointStatus[a.x][y] == 0 && pointStatus[b.x][y] == 0 && vertical(new Point(a.x, y), new Point(b.x, y), false))
				v.add(new GameLine(0, new Point(a.x, y), new Point(b.x, y)));

		for (int x = a.x; x >= 0; x--)
			if (pointStatus[x][a.y] == 0 && pointStatus[x][b.y] == 0 && horizon(new Point(x, a.y), new Point(x, b.y), false))
				v.add(new GameLine(1, new Point(x, a.y), new Point(x, b.y)));

		for (int x = a.x; x < yLen; x++)
			if (pointStatus[x][a.y] == 0 && pointStatus[x][b.y] == 0 && horizon(new Point(x, a.y), new Point(x, b.y), false))
				v.add(new GameLine(1, new Point(x, a.y), new Point(x, b.y)));

		return v;
	}

	private boolean twoCorner(Point a, Point b) {
		vector = scan(a, b);
		if (vector.isEmpty())
			return false;
		for (int index = 0; index < vector.size(); index++) {
			GameLine gameLine = (GameLine) vector.elementAt(index);
			if (gameLine.direct == 1) {
				if (vertical(a, gameLine.a, false) && vertical(b, gameLine.b, false)) {
					if(!imitate)
						animate = new GameLineBuilder(0, a, gameLine.a, gameLine.b, b);
					return true;
				}
			} else if (horizon(a, gameLine.a, false) && horizon(b, gameLine.b, false)) {
				if(!imitate)
					animate = new GameLineBuilder(1, a, gameLine.a, gameLine.b, b);
				return true;
			}
		}

		return false;
	}
	
	public boolean test(Point a, Point b){
		if(pointStatus[a.x][a.y] != pointStatus[b.x][b.y])
			return false;
		if(a.x == b.x && horizon(a, b, true))
			return true;
		if(a.y == b.y && vertical(a, b, true))
			return true;
		if(oneCorner(a, b))
			return true;
		else
			return twoCorner(a, b);
	}
	
	public GameLine findNext(Point a){
		Point b = new Point();
		a = findFirst(a);
		if(a.equals(new Point(-1, -1)))
			return new GameLine(0, a, b);
		for(; !a.equals(new Point(-1, -1)); a = findFirst(a))
			for(b = findSecond(a, b); !b.equals(new Point(-1, -1)); b = findSecond(a, b))
				if(test(a, b))
					return new GameLine(1, a, b);


		return new GameLine(0, a, b);
	}

	private Point findFirst(Point a){
		int offset = 0;
		if(a != null)
			offset = a.x * xLen + a.y;
		if(offset < 0)
			offset = -1;
		for(int x = offset + 1; x < xLen * yLen; x++){
			int row = Math.round(x / xLen);
			int col = x - row * xLen;
			if(pointStatus[row][col] != 0)
				return new Point(row, col);
		}

		return new Point(-1, -1);
	}

	private Point findSecond(Point a, Point b){
		if(a == null)
			return new Point(-1, -1);
		if(a.x + a.y < 0)
			return new Point(-1, -1);
		if(b == null)
			b = new Point(0, 0);
		int offset = Math.max(a.x * xLen + a.y, b.x * xLen + b.y);
		for(int x = offset + 1; x < xLen * yLen; x++){
			int row = Math.round(x / xLen);
			int col = x - row * xLen;
			if(pointStatus[row][col] == pointStatus[a.x][a.y])
				return new Point(row, col);
		}

		return new Point(-1, -1);
	}

	public int[][] getPointStatus() {
		return pointStatus;
	}

	public void setPointStatus(int[][] pointStatus) {
		this.pointStatus = pointStatus;
	}

	public int getxLen() {
		return xLen;
	}

	public void setxLen(int xLen) {
		this.xLen = xLen;
	}

	public int getyLen() {
		return yLen;
	}

	public void setyLen(int yLen) {
		this.yLen = yLen;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public boolean isImitate() {
		return imitate;
	}

	public void setImitate(boolean imitate) {
		this.imitate = imitate;
	}

	public Vector<GameLine> getVector() {
		return vector;
	}

	public void setVector(Vector<GameLine> vector) {
		this.vector = vector;
	}

	public GameMode getMode() {
		return mode;
	}

	public void setMode(GameMode mode) {
		this.mode = mode;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	
	
}
