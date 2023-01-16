package preparedstatement_person;

import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		PersonCurd curd = new PersonCurd();
		boolean repeat = true;
		while (repeat) {
			System.out.println(
					"Enter the choice \n1.save person \n2.update person name \n3.delete person \n4.get All Person  \n5.exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the id");
				int id = scanner.nextInt();
				System.out.println("Enter the name");
				String name = scanner.next();
				System.out.println("Enter the phone number");
				long phone = scanner.nextLong();
				// SavePerson
				try {
					curd.savePerson(id, name, phone);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Some exception");
				}
			}
				break;
			case 2: {
				System.out.println("Enter the id to be updated");
				int id = scanner.nextInt();
				System.out.println("Enter the name to be updated");
				String name = scanner.next();
				curd.updatePerson(id, name);
			}
				break;
			case 3: {
				System.out.println("Enter the id to be deleted");
				int id = scanner.nextInt();
				curd.deletePerson(id);
			}
				break;
			case 4: {
				curd.getAllPerson();
			}
				break;
			case 5:
				repeat = false;
			}
			break;
		}
	}

}