package com.link.core;

public enum GameMode {
	Easy(10, 1, 20), Normal(15, 2, 60), Hard(20, 3, 90);
	
	private int imgNumber;
	private int imgCouples;
	private int finishTime;
	
	GameMode(int imgNumber, int imgCouples, int finishTime) {
		this.imgNumber = imgNumber;
		this.imgCouples = imgCouples;
		this.finishTime = finishTime;
	}

	public int getImgNumber() {
		return imgNumber;
	}

	public void setImgNumber(int imgNumber) {
		this.imgNumber = imgNumber;
	}

	public int getImgCouples() {
		return imgCouples;
	}

	public void setImgCouples(int imgCouples) {
		this.imgCouples = imgCouples;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
	
	
}
