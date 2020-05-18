package com.masivian.test;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * Class Refactor
 * 
 * @author Melisa Castro
 */
public class Refactor {

	private int ROWOFFSET;
	private final String PHRASE1;
	private final String PHRASE2;
	private final int LIMIT;
	private final int ROWS;
	private final int COLUMNS;

	/**
	 * Function to identify primes numbers
	 */
	Function<Integer, Boolean> isPrime = a -> IntStream.range(2, Math.round(a / 2)).filter(item -> item % 2 != 0)
			.filter(item -> a % item == 0).boxed().collect(Collectors.toList()).isEmpty();

	/**
	 * Method constructor
	 */
	public Refactor() {
		PHRASE1 = "The First ";
		PHRASE2 = " Prime Numbers === Page ";
		LIMIT = 1000;
		ROWS = 50;
		COLUMNS = 4;
	}

	/**
	 * Method to print static text
	 * 
	 * @param n
	 *            number of page
	 */
	public void print(int n) {
		System.out.println(PHRASE1 + LIMIT + PHRASE2 + n + "\n");
	}

	/**
	 * Method for setting primes numbers
	 * 
	 * @param position
	 *            number where start position of array
	 * @param number
	 *            number to identify if is prime
	 * @param primes
	 *            array of primes numbers
	 */
	private void setPrimes(int position, int number, int primes[]) {
		while (position < LIMIT) {
			number += 2;
			if (isPrime.apply(number)) {
				position++;
				primes[position] = number;
			}
		}
	}
	/**
	 * Method that print array of primes numbers
	 */
	public void getPrimes() {

		int primes[] = new int[LIMIT + 1];
		int pageNumber = 1;
		int pageOffset = 1;
		int number = 1;
		int position = 1;
		primes[1] = 2;

		setPrimes(position, number, primes);

		while (pageOffset <= LIMIT) {
			print(pageNumber);
			for (ROWOFFSET = pageOffset; ROWOFFSET <= pageOffset + ROWS - 1; ROWOFFSET++) {
				IntStream.range(0, COLUMNS).filter(item -> (ROWOFFSET + item * ROWS <= LIMIT))
						.forEach(item -> System.out.printf("%10d", primes[ROWOFFSET + item * ROWS]));
				System.out.println();
			}

			System.out.println("\f");
			pageNumber++;
			pageOffset += ROWS * COLUMNS;
		}

	}

	public static void main(String[] args) {
		Refactor refactor = new Refactor();
		refactor.getPrimes();

	}
}
