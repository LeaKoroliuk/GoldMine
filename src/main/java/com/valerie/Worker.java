package com.valerie;

public class Worker implements Runnable {

	private Gold gold;
	private int sumOfGold;
	private String name;

	public Worker(Gold gold, String name) {
		this.gold = gold;
		this.name = name;
		System.out.println("------------------------------------------------------------------");
		System.out.printf("%s went down the mine ... \n", name);
		System.out.println("------------------------------------------------------------------");
		new Thread(this).start();
	}

	public void run() {
		int countOfGoldMiningAtOnce;
		while (gold.getCountOfGold() > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (gold) {
				if (gold.getCountOfGold() > 0) {
					System.out.printf("AT THE MOMENT IN MINE - %d GOLD\n", gold.getCountOfGold());
					countOfGoldMiningAtOnce = gold.miningGold(3);
					sumOfGold += countOfGoldMiningAtOnce;

					System.out.println(name + " mined " + countOfGoldMiningAtOnce + " gold. And in general he has: "
							+ sumOfGold + " gold");
					System.out.println();
				}
			}
		}			
		System.out.println(name + " stopped work. In total, he mined " + sumOfGold + " gold.");
	}
	
}
