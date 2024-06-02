import java.util.ArrayList;

 class Student {
	String ID;
	String status;
	
	Library lib;
	Account account;
	
	Book b;
	int duedate=lib.RequestBorrow(b, this);
	

}

class Library
{
	Student []List_of_Student;
	BookCatalogue BC;
	
	int RequestBorrow(Book b, Student s) 
	{
		b.getBookInfo();
		return s.account.AddtoBorrowedList(b);
	}
}
class BookCatalogue
{
	Book []List_of_books;
	Account []List_of_Account;
	}

class Book
{
	String ID;
	String title;
	int maxBorrowPeriod;
	int dueDate;
	
	Account []List_of_Account;
	BookCatalogue BC;
	
	String getBookInfo()
	{
		return title;
	}
}

class Account
{
	int Number_of_Renewals;
	int OverdueFees;
	ArrayList<Book> Borrowed_books= new ArrayList<Book>();
	
	int AddtoBorrowedList(Book b) 
	{
		Borrowed_books.add(b);
		return b.dueDate;
	}
	
	}