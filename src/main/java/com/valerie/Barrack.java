package com.valerie;

public class Barrack implements Runnable {

	private int firstBatchOfWorkers;
	private Gold gold;

	public Barrack(int firstBatchOfWorkers, Gold gold) {
		this.firstBatchOfWorkers = firstBatchOfWorkers;
		this.gold = gold;
	}

	public void run() {

		// создаем рабочих, которые изначально пошли в шахту
		for (int i = 0; i < firstBatchOfWorkers; i++) {
			new Worker(gold, "Worker#" + Integer.toString(i));
		}

		while (gold.getCountOfGold() > 0) {
			try {
				Thread.sleep(10000);
				if (gold.getCountOfGold() > 0) {
					new Worker(gold, "Worker#" + Integer.toString(++firstBatchOfWorkers));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
