package com.example.Cursor_HW6;

import com.example.Cursor_HW6.models.User;
import com.example.Cursor_HW6.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class CursorHw6Application implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CursorHw6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String choice;
		Scanner scanner;

		do {
			scanner = new Scanner(System.in);
			System.out.println("\nОберіть дію:");
			System.out.println("1. Створити користувача");
			System.out.println("2. Видалити користувача по id");
			System.out.println("3. Список усіх користувачів");
			System.out.println("4. Вивести користувача по id");
			System.out.println("5. Вивести користувача по email");
			System.out.println("6. Оновити користувача");
			System.out.println("7. Завершити виконання програми");
			System.out.print("Введіть обрану дію: ");
			choice = scanner.nextLine();

			switch (choice) {
				case "1":
					try {
						System.out.print("Enter first name: ");
						String firstName = scanner.nextLine();
						System.out.print("Enter last name: ");
						String lastName = scanner.nextLine();
						System.out.print("Enter email: ");
						String email = scanner.nextLine();
						System.out.print("Enter age: ");
						int age = Integer.parseInt(scanner.nextLine());

						if (age >= 0) {
							User user = new User();
							user.setFirstName(firstName);
							user.setLastName(lastName);
							user.setEmail(email);
							user.setAge(age);

							userService.createUser(user);
							System.out.println("Додано користувача: " + user);
						} else {
							System.out.println("Введено неприпустимий вік користувача");
						}

					} catch (Exception ex) {
						System.out.println("Помилка! Не вдалося додати користувача");
					}
					break;

				case "2":
					System.out.print("Enter user ID to delete: ");
					try {
						Long idToDelete = Long.parseLong(scanner.nextLine());

						userService.deleteUserById(idToDelete);
					} catch (Exception ex) {
						System.out.println("Помилка! Не вдалося видалити користувача із заданим Id");
					}
					break;

				case "3":
					List<User> users = userService.getAllUsers();
					System.out.println("Список користувачів: ");
					for (User user : users) {
						System.out.println(user);
					}
					break;

				case "4":
					try {
						System.out.print("Введіть id користувача: ");
						Long idToRetrieve = Long.parseLong(scanner.nextLine());

						User userById = userService.getUserById(idToRetrieve);
						if (userById != null) {
							System.out.println("Користувач із заданим id: " + userById);
						} else {
							System.out.println("Не вдалося знайти користувача із заданим id");
						}
					} catch (Exception ex) {
						System.out.println("Не вдалося знайти користувача із заданим id");
					}
					break;

				case "5":
					try {
						System.out.print("Введіть email користувача: ");
						String emailToRetrieve = scanner.nextLine();

						User userByEmail = userService.getUserByEmail(emailToRetrieve);
						if (userByEmail != null) {
							System.out.println("Користувач із заданим email: " + userByEmail);
						} else {
							System.out.println("Не вдалося знайти користувача із заданим email");
						}
					} catch (Exception ex) {
						System.out.println("Не вдалося знайти користувача із заданим email");
					}
					break;

				case "6":
					try {
						System.out.print("Enter user ID to update: ");
						Long idToUpdate = Long.parseLong(scanner.nextLine());
						User userToUpdate = userService.getUserById(idToUpdate);

						if (userToUpdate != null) {
							System.out.print("Введіть нове first name (залиште порожнім, щоб залишити поточне): ");
							String newFirstName = scanner.nextLine();
							System.out.print("Введіть нове last name (залиште порожнім, щоб залишити поточне): ");
							String newLastName = scanner.nextLine();
							System.out.print("Введіть новий email (залиште порожнім, щоб залишити поточне): ");
							String newEmail = scanner.nextLine();
							System.out.print("Введіть новий вік (-1, щоб залишити поточне): ");
							int newAge = Integer.parseInt(scanner.nextLine());

							if (newAge >= -1) {
								if (!newFirstName.isEmpty()) {
									userToUpdate.setFirstName(newFirstName);
								}
								if (!newLastName.isEmpty()) {
									userToUpdate.setLastName(newLastName);
								}
								if (!newEmail.isEmpty()) {
									userToUpdate.setEmail(newEmail);
								}
								if (newAge != -1) {
									userToUpdate.setAge(newAge);
								}

								userService.updateUser(userToUpdate);
								System.out.println("Користувача змінено успішно");
							} else {
								System.out.println("Вік введено неправильно");
							}

						} else {
							System.out.println("Користувача не знайдено");
						}
					} catch (Exception ex) {
						System.out.println("Не вдалося змінити користувача із заданим id");
					}
					break;

				case "7":
					break;

				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (!choice.equals("7"));
		scanner.close();
	}

}
