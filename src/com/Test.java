package com;

public class Test {

	public static void main(String[] args) {

		int years =5;
		int n=years*12;
		double perc=5;
		double i = perc/100/12;
		double loan=10000;
		
		double pow = Math.pow((i+1),n);
		
		double payment = (loan * i * pow)/(pow-1);
		double total = payment * n;
		payment = Math.round(payment*100)/100.0;
		System.out.println(payment);

		total = Math.round(total*100)/100.0;
		System.out.println(total);
	}
}
