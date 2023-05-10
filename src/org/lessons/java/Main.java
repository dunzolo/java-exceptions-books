package org.lessons.java;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.lessons.java.obj.Libro;

public class Main {
	
	private static final String FILENAME = "C:\\Users\\rossi\\eclipse-workspace\\2023_05_10_Exceptions\\temp\\temp.txt";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quanti libri vuoi inserire?");
		int n = sc.nextInt();
		sc.nextLine();
		
		Libro[] arrBooks = new Libro[n];
		
		int count = 0;

		while(count < n) {
			System.out.println("Inserisci il titolo del libro");
			String title = sc.nextLine();
			System.out.println("Inserisci il numero di pagine");
			int pages_number = sc.nextInt();
			sc.nextLine();
			System.out.println("Inserisci il nome dell'autore");
			String author = sc.nextLine();
			System.out.println("Inserisci il nome dell'editore");
			String editor = sc.nextLine();
			
			try {
				Libro book = new Libro(title, pages_number, author, editor);
				arrBooks[count++] = book;
				
			} catch(Exception e) {
				System.err.println("Errore!\n" + e.getMessage());
			}
		}
		
		printBookToFile(arrBooks);
		System.out.println("-----------------");
		getBookFromFile();
		System.out.println("The end");
	}
	
	public static void printBookToFile(Libro[] arrBooks) {
		
		try {
			FileWriter writer = new FileWriter(FILENAME);
			for(int i = 0; i < arrBooks.length; i++) {
				
				Libro book = arrBooks[i];
				
				writer.write(book + "\n");
				
			}
			
			writer.close();
			
			
		} catch (Exception e ) {
			System.err.println("Errore nella scrittura del libro\n" + e.getMessage());
		}
	}
	
	public static void getBookFromFile() {
		try {
			
			File my_file = new File(FILENAME);
			Scanner reader = new Scanner(my_file);
			 
			while (reader.hasNextLine()) {
				
			   String str = reader.nextLine();
			   System.out.println(str);
			}

			reader.close();
		} catch (Exception e) {
			
			System.err.println("Errore nella lettura del libro\n" + e.getMessage());
		}
	}
}
