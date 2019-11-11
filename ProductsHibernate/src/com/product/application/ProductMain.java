package com.product.application;

import java.util.Scanner;

import com.product.beans.ProductDAO;

public class ProductMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		again: do {
			System.out.println();
			System.out.println("1 --> Add new product.");
			System.out.println("2 --> Delete product by product id.");
			System.out.println("3 --> Edit product information.");
			System.out.println("4 --> Search product by id.");
			System.out.println("5 --> Display all products.");
			System.out.println("6 --> EXIT.");
			System.out.println();
			System.out.print("Please enter your choice from the menu above (1-6) : ");
			int choice = sc.nextInt();
			sc.nextLine();
			System.out.println();

			if (choice < 1 || choice > 6) {
				System.out.println("Please enter a number from 1 to 6 only !!!");
				continue again;
			} else {

				switch (choice) {
				case 1:
					System.out.println("You have selected to add a new product");
					System.out.print("Enter the product name: ");
					String name = sc.nextLine();
					System.out.print("Enter the product description: ");
					String description = sc.nextLine();
					System.out.print("Enter the product price: ");
					double price = sc.nextDouble();
					System.out.print("Enter the product quantity: ");
					int quantity = sc.nextInt();
					int primKey = ProductDAO.addProduct(name, description, price, quantity);
					System.out.println("The product you just added is:");
					System.out.println(ProductDAO.getProductById(primKey));
					break;
				case 2:
					System.out.println("You have selected to delete an existing product");
					System.out.print("Enter id for the product you want to delete: ");
					int idDelete = sc.nextInt();
					ProductDAO.deleteProduct(idDelete);
					System.out.println("Product ID number " + idDelete + " has been deleted successfully");
					break;
				case 3:
					System.out.println("You have selected to update an existing product");
					System.out.print("Enter id for the product you want to edit: ");
					int idUpdate = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the product name: ");
					String nameUpdate = sc.nextLine();
					System.out.print("Enter the product description: ");
					String descriptionUpdate = sc.nextLine();
					System.out.print("Enter the product price: ");
					double priceUpdate = sc.nextDouble();
					System.out.print("Enter the product quantity: ");
					int quantityUpdate = sc.nextInt();
					ProductDAO.updateProduct(idUpdate, nameUpdate, descriptionUpdate, priceUpdate, quantityUpdate);
					System.out.println("Please review the updated information :");
					System.out.println(ProductDAO.getProductById(idUpdate));
					break;
				case 4:
					System.out.println("You have selected to search for an existing product");
					System.out.print("Enter id for the product you want to find: ");
					int idSearch = sc.nextInt();
					sc.hasNextLine();
					System.out.println("The Product you are looking for is:");
					System.out.println(ProductDAO.getProductById(idSearch));
					break;
				case 5:
					System.out.println("You have selected to get a list of all products:");
					System.out.println("List of Products:");
					ProductDAO.listProduct();
					break;
				case 6:
					System.out.println("You have selected to exit the application . Goodbye!!");
					sc.close();
					System.exit(0);
				}
			}
		} while (true);

	}

}
