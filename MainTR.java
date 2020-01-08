package taschenrechner;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	private Scanner scanner = new Scanner(System.in);
	
	private HashSet<Float> overTenNumbers = new HashSet<>(); 

	private Calculation sum = (a, b) -> a + b;
	private Calculation sub = (a, b) -> a - b;
	private Calculation mul = (a, b) -> a * b;
	private Calculation div = (a, b) -> a / b;

	private float number1;
	private float number2;
	private boolean isRunning = true;
	private boolean notEnoughInput = true;

	public static void main(String[] args) {
		Main mainMethod = new Main();
		mainMethod.loop();
	}

	private void loop() {
		while (isRunning) {
			if (notEnoughInput) {
				System.out.println("Geben Sie die erste Zahl ein");
				String num1String = scanner.next();

				try {
					number1 = Float.parseFloat(num1String);
				} catch (Exception e) {
					System.out.println("Ungültige Eingabe");
					continue;
				}

				System.out.println("Geben Sie die zweite Zahl ein");
				String num2String = scanner.next();
				try {
					number2 = Float.parseFloat(num2String);
					notEnoughInput = false;
				} catch (Exception e) {
					System.out.println("Ungültige Eingabe");
					continue;
				}
			}
			chooseMathOperations();
		}

	}

	private void chooseMathOperations() {
		chooseOptions();
		String choosedOperator = scanner.next();
		switch (choosedOperator) {
		case "0":
			overTenNumbers.forEach(e -> System.out.println(e));
			isRunning = false;
			break;
		case "1":
			float calculatedSum = sum.calculate(number1, number2);
			System.out.println(number1 + " + " + number2 + " = " + calculatedSum);
			addNumberToHashSet(calculatedSum);
			break;
		case "2":
			float calculatedSub = sub.calculate(number1, number2);
			System.out.println(number1 + " - " + number2 + " = " + calculatedSub);
			addNumberToHashSet(calculatedSub);
			break;
		case "3":
			float calculatedMult = mul.calculate(number1, number2);
			System.out.println(number1 + " * " + number2 + " = " + calculatedMult);
			addNumberToHashSet(calculatedMult);
			break;
		case "4":
			if (number2 == 0) {
				System.out.println("Durch 0 teilen ist nicht erlaubt du Idiot");
				break;
			}
			float calculatedDiv = div.calculate(number1, number2);
			System.out.println(number1 + " / " + number2 + " = " + calculatedDiv);
			addNumberToHashSet(calculatedDiv);
			break;
		default:
			System.out.println("Keine Option");
			break;
		}
	}

	private void chooseOptions() {
		System.out.println("Wähle eine Option aus:");
		System.out.println("0. Exit");
		System.out.println("1. Summieren");
		System.out.println("2. Subtrahieren");
		System.out.println("3. Multiplizieren");
		System.out.println("4. Dividieren");
	}
	
	private void addNumberToHashSet(float number) {
		if (number > 10) {
			overTenNumbers.add(number);
		}
	}
}
