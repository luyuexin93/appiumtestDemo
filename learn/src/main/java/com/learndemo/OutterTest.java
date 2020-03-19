package com.learndemo;

public class OutterTest {
	public static void main(String[] args) {
		Outter outter = new Outter.Builder().setName("jack").buider();
		System.out.println(outter.toString());
		Outter outter2 = new Outter();
		System.out.println(outter2.toString());
	}
}
