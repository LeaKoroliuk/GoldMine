package com.valerie;

public class Main {

	public static void main(String[] args) {

		Gold gold = new Gold(1000);
		new Thread(new Barrack(5, gold)).start();

	}
}
