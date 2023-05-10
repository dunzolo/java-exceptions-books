package org.lessons.java.obj;

public class Libro {
	private String title;
	private int pages_number;
	private String author;
	private String editor;
	
	public Libro (String title, int pages_number, String author, String editor) throws Exception {
		setTitle(title);
		setPages_number(pages_number);
		setAuthor(author);
		setEditor(editor);
	}

	//get and set with exception
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) throws Exception {
		
		if(title.isEmpty()) {
			throw new Exception("Il titolo non può essere vuoto!");
		}
		
		this.title = title;
	}
	public int getPages_number() {
		return pages_number;
	}
	public void setPages_number(int pages_number) throws Exception {
		
		if(pages_number <= 0) {
			throw new Exception("Il numero di pagine non può essere minore di 0");
		}
		this.pages_number = pages_number;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) throws Exception {
		
		if(author.isEmpty()) {
			throw new Exception("L'autore non può essere vuoto!");
		}
		
		this.author = author;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	//metodo per stampare tutti gli attributi
	protected String getBookString() {
		return "Titolo: " + getTitle() 
			+ "\nNumero di pagine: " + getPages_number()
			+ "\nAutore: " + getAuthor()
			+ "\nEditore: " + getEditor();
	}
	
	@Override
	public String toString() {
		return "(L)\n" + getBookString() + "\n-----------------";
	}
	
}
