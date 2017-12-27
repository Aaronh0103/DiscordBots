package de.maxkroner.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.Function;

public class UserInput {
	private Scanner scanner;

	public UserInput(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	/**
	 * Prints the provided question and returns the users answer as Boolean
	 * 
	 * @param question
	 *            question to ask the user
	 * @param scanner
	 *            Scanner object to use
	 * @return users answer
	 */
	public Boolean getYesNoResult(String question) {
		String answer = "";
		while (!answer.equals("y") && !answer.equals("n")) {
			System.out.println(question + " (y/n)");
			answer = scanner.next();
		}

		return answer.equals("y");
	}

	/**
	 * Prints the provided question an the possible answers
	 * 
	 * @param question
	 *            the question to ask the user
	 * @param answers
	 *            the answers the user has to choose from
	 * @return int representing the answer chosen by the user, starting with 1
	 */
	public int getMultipleChoiceResult(String question, String... answers) {
		int result = 0;

		while (result > answers.length | result < 1) {
			System.out.println(question);
			for (int i = 1; i <= answers.length; i++) {
				System.out.println("(" + i + ") " + answers[i - 1]);
			}
			
			try{
			result = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("wrong input");
				scanner.next();
			}
		}

		return result;
	}

	/**
	 * Prints the provided question an the possible enums
	 * 
	 * @param question
	 *            the question to ask the user
	 * @param answers
	 *            the answers the user has to choose from
	 * @return enum chosen by the user
	 */
	public Enum<?> getMultipleChoiceResult(String question, Enum<?>... answers) {
		int result = 0;

		while (result > answers.length | result < 1) {
			System.out.println(question);
			for (int i = 1; i <= answers.length; i++) {
				System.out.println("(" + i + ") " + answers[i - 1].toString());
			}
			
			try{
				result = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.err.println("wrong input");
					scanner.next();
				}
			
		}

		return answers[result - 1];
	}

	/**
	 * Prints the provided question and the options to choose from
	 * @param <T>
	 * 
	 * @param question
	 *            the question to ask the user
	 * @param options
	 *            list of objects the user can choose from
	 * @return chosen object
	 */
	public <T> T getMultipleChoiceResult(String question, List<T> options, Function<T, String> toString) {
		int result = 0;

		while (result > options.size() | result < 1) {
			System.out.println(question);
			for (int i = 1; i <= options.size(); i++) {
				System.out.println("(" + i + ") " + toString.apply(options.get(i - 1)));
			}
			
			try{
				result = scanner.nextInt();
				} catch (InputMismatchException e) {
					System.err.println("wrong input");
					scanner.next();
				}
			
		}

		return options.get(result - 1);
	}
	
	/**
	 * Prints the provided question and returns user answer
	 * @param question
	 * 			the question to ask the user
	 * @return the provided user answer as String
	 */
	public String getStringAnswer(String question){
		System.out.println(question);
		String answer = "";
		while(answer.isEmpty()){
			answer = scanner.nextLine();
		}
		return answer;
	}
}
