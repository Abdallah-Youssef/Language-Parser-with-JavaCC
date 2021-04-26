package lab1;

import egtry.lab1.Grammar;
import egtry.lab1.ParseException;

public class test {
	public static void main(String[] args) {
		try {
			new egtry.lab1.Grammar(System.in).start();
			System.out.println("YES");
		} catch (ParseException e) {
			System.out.println("NOO");
		}
		System.out.println("Hi");
	}
}
