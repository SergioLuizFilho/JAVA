package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.*;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birthdate (DD/MM/YYYY): ");
		String data = sc.nextLine();
		
		Date date = Client.formatter1.parse(data);
		
		Client client = new Client(nome, email, date);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		OrderStatus statusOfc = OrderStatus.valueOf(status);
		
		Order order = new Order(new Date(), statusOfc, client);
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			System.out.printf("Enter #%d item data: \n", i + 1);
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product Price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			
			Product product = new Product(productName, productPrice);
			
			Integer quantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}







