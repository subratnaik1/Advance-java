package pack1;

import java.io.Serializable;

public class BookBean implements Serializable {
 
	private String book_Id;
	private String Book_Name;
	private String Book_Author_name;
	private String Book_Price;
	private String Book_quantity;
	
	public BookBean() {
		
	}

	public String getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(String book_Id) {
		this.book_Id = book_Id;
	}

	public String getBook_Name() {
		return Book_Name;
	}

	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}

	public String getBook_Author_name() {
		return Book_Author_name;
	}

	public void setBook_Author_name(String book_Author_name) {
		Book_Author_name = book_Author_name;
	}

	public String getBook_Price() {
		return Book_Price;
	}

	public void setBook_Price(String book_Price) {
		Book_Price = book_Price;
	}

	public String getBook_quantity() {
		return Book_quantity;
	}

	public void setBook_quantity(String book_quantity) {
		Book_quantity = book_quantity;
	}
	
}
