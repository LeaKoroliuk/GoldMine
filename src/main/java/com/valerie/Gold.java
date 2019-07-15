package com.valerie;

public class Gold {

	private volatile int countOfGold;

	public Gold(int countOfGold) {
		this.countOfGold = countOfGold;
	}

	public int getCountOfGold() {
		return countOfGold;
	}

	public void setCountOfGold(int countOfGold) {
		this.countOfGold = countOfGold;
	}

	public synchronized int miningGold(int gold) {
		if (gold <= countOfGold) {
			countOfGold -= gold;
		} else {
			gold = countOfGold;
			countOfGold = 0;
			System.out.println("THERE IS NO MORE GOLD IN THE MINE!");
		}
		return gold;
	}

}
