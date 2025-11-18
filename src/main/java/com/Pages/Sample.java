package com.Pages;

public class Sample {

	public static void main(String[] args) {

		int num = 153;

		int original = num, numberOfDigits = 0, temp = original;
		while (temp != 0) {
			temp /= 10;
			numberOfDigits++;
		}
		int sumOfPowers = 0;
		temp = original;
		while (temp != 0) {
			int digit = temp % 10;
			int powerOfDigit = 1;
			for (int i = 0; i < numberOfDigits; i++) {
				powerOfDigit *= digit;
			}
			sumOfPowers += powerOfDigit;
			temp /= 10;
		}
		if (sumOfPowers == original) {
			System.out.println("The given is Armstrong number!");
		} else {
			System.out.println("The given is not an Armstrong number!");
		}

	}
}
