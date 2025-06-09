package BookClub;
import java.util.*;

public class Main
{

	static List<Book> bookList = new ArrayList<>();
	static List<User> userList = new ArrayList<>();
	static List<Review> reviewList = new ArrayList<>();
	
	//adding sample user for testing ease
	//User newUser = new User("USer", "User", "12345");
	//userList.add(newUser);
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the Book Club");
		Boolean mainView = true;
		
		while(mainView)
		{
			System.out.println("\nLogin as:");
			System.out.println("1. Manager Login");
			System.out.println("2. User Login");
			System.out.println("3. User Register");
			System.out.println("4. Exit");
			System.out.println("\nEnter Choice: ");
			
			int choice=0;
			if (sc.hasNextInt()) 
			{
			    choice = sc.nextInt();
			    sc.nextLine();
			} 
			else 
			{
			    System.out.println("\nInvalid input! Please enter a number.");
			    sc.nextLine();
			}
			
			switch(choice)
			{
				case 1: System.out.println("Enter Username: ");
						String username = sc.nextLine();
						System.out.println("Enter Password: ");
						String password = sc.nextLine();
						
						if (username.equals("admin") && password.equals("12345"))
						{	

							System.out.println("\n\nLogin Successful.");
							System.out.println("\nWelcome Manager!");
							
							Boolean managerView = true;
							while(managerView)
							{	
								System.out.println("--- Manager Features ---");
								System.out.println("1. Add A Book");
								System.out.println("2. View All Books");
								System.out.println("3. Delete A Book");
								System.out.println("4. View All Users");
								System.out.println("5. View Reviews");
								System.out.println("6. Logout");
								System.out.println("\nEnter Choice: ");
								
								int ManagerChoice = 0;
								if (sc.hasNextInt()) 
								{
								    ManagerChoice = sc.nextInt();
								    sc.nextLine();
								} 
								else 
								{
								    System.out.println("Invalid input! Please enter a number.");
								    sc.nextLine();
								}
								
								switch(ManagerChoice)
								{
									case 1: //Add a Book
											addBook(sc);
											System.out.println("New Book Added !");
											break;
											
									case 2: //View All Books
											viewAllBooks();
											break;
											
									case 3: //Delete a Book
											deleteBook(sc);
											System.out.println("The Book is Deleted.");
											break;
											
									case 4: //View All Users
											viewAllUsers();
											break;
									
									case 5: //View Reviews
											viewReviews(sc);
											break;
											
									case 6: System.out.println("Come again, Bye !!");
											managerView = false;
											break;
											
									default: System.out.println("Invalid Entry");
								}
								System.out.println("\n");
							}
						}
						else
						{
							System.out.println("\n\nLogin Failed !");
							System.out.println("Try Again !!");
							break;
						}
						break;
				
				case 2:	//User login
						int UserId = loginUser(sc);
						
						if (UserId == -1)
						{
							System.out.println("\nNo Such User Exists");
						}
						else
						{	
							Boolean userView = true;
							while(userView)
							{
								System.out.println("\n--- User Features ---");
								System.out.println("1. Search For A Book");
								System.out.println("2. Write A Review");
								System.out.println("3. Delete A Review");
								System.out.println("4. Update My Review");
								System.out.println("5. Read All My Reviews");
								System.out.println("6. View Average Rating Of A Book");
								System.out.println("7. Change Password");
								System.out.println("8. Exit");
								System.out.println("\nEnter Choice: ");
						
								int UserChoice = 0;
								if (sc.hasNextInt()) 
								{
								    UserChoice = sc.nextInt();
								    sc.nextLine();
								} 
								else 
								{
								    System.out.println("Invalid input! Please enter a number.");
								    sc.nextLine();
								}
								
								switch(UserChoice)
								{	
									case 1: //Search for a book
											boolean searchBookView = true;
											while(searchBookView)
											{
												System.out.println("---Search For A Book---");
												System.out.println("1. By Title");
												System.out.println("2. By Author");
												System.out.println("3. Exit");
												System.out.println("\nEnter Choice: ");
												
												int SearchBookChoice = 0;
												if (sc.hasNextInt()) 
												{
												    SearchBookChoice = sc.nextInt();
												    sc.nextLine();
												} 
												else 
												{
												    System.out.println("Invalid input! Please enter a number.");
												    sc.nextLine();
												}
												
												switch(SearchBookChoice)
												{
													case 1: searchBookByTitle(sc);
															break;
													case 2: searchBookByAuthor(sc);
															break;
													case 3: searchBookView = false;
															break;
													default: System.out.println("Invalid Entry");
												}
											}
											break;
											
									case 2: //Write A Review
											writeReview(sc, UserId);
											break;
									
									case 3: //Delete A Review
											deleteReview(sc, UserId);
											break;
											
									case 4: //Update A Review
											updateReview(sc, UserId);
											break;
										
									case 5:	// Read My Reviews
											readMyReviews(UserId);
											break;
									
									case 6: //View Average Rating of a Book
											bookRating(sc);
											break;
										
									case 7: //Change Password
											changePassword(sc, UserId);
											break;
											
									case 8:	System.out.println("Come again, Bye !!");
											userView = false;
											break;
								}
							}
						}
						break;
				
				case 3: //Register User
						addUser(sc);
						break;
						
				case 4:	System.out.print("Do visit again !");
						mainView = false;
						break;
						
				default: System.out.println("Invalid Entry");
				System.out.println("\n\n");
			}
		}
	}
	
	public static void addBook(Scanner sc)
	{
		System.out.println("Enter Book Title: ");
		String Title = sc.nextLine();
		
		System.out.println("Enter Book Author: ");
		String Author = sc.nextLine();
		
		System.out.println("Enter Genre: ");
		String Genre = sc.nextLine();
		
		System.out.println("Enter Description: ");
		String Description = sc.nextLine();
		
		Book newBook = new Book(Title, Author, Genre, Description);
		bookList.add(newBook);
	}
	
	public static void addUser(Scanner sc)
	{
		System.out.println("Enter Name: ");
		String Name = sc.nextLine();
		
		System.out.println("Enter Username: ");
		String Username = sc.nextLine();
		
		System.out.println("Enter Password: ");
		String Password =  sc.nextLine();
		
		User newUser = new User(Name, Username, Password);
		userList.add(newUser);
		
		System.out.println("New user added.");
	}
	
	public static void viewAllBooks()
	{
		if(bookList.isEmpty())
		{
			System.out.println("No Books Available."); 
		}
		else
		{
			System.out.println("List of Books: ");
			for(Book book: bookList)
			{
				System.out.println(book);
			}
		}
	}
	
	public static void deleteBook(Scanner sc)
	{
		System.out.println("Enter Book ID to delete: ");
		
		int id=0;
		if(sc.hasNextInt())
		{
			id = sc.nextInt();
			sc.nextLine();
		}
		else
		{
			System.out.println("\nInvalid Id.");
			sc.nextLine();
		}
		boolean removed = false;
		for(int i=0; i<bookList.size(); i++)
		{
			if(bookList.get(i).getId() == id)
			{
	            System.out.println("\nBook removed: " + bookList.get(i).getTitle());
	            bookList.remove(i);
	            removed = true;
	            break;
			}
		}
		if(!removed)
		{
			System.out.println("Book with Id "+ id +" not found.");
		}
	}
	
	public static void viewAllUsers()
	{
		if(userList.isEmpty())
		{
			System.out.println("\nNo User Found."); 
		}
		else
		{
			System.out.println("List of Users: ");
			for(User user: userList)
			{
				System.out.println(user);
			}
		}
	}
	
	public static void viewReviews(Scanner sc)
	{
		System.out.println("Enter Book ID to view reviews: ");
		int BookID=0;
		if(sc.hasNextInt())
		{
			BookID = sc.nextInt();
			sc.nextLine();
		}
		else
		{
			System.out.println("\nInvalid input.");
			sc.nextLine();
		}
		boolean found = false;
		for(Review review : reviewList)
		{
			if(review.getBookId() == BookID)
			{
				System.out.println(review);
				found = true;
			}
		}
		if(!found)
		{
			System.out.println("\nNo reviews found for this book.");
		}
	}
	
	public static int loginUser(Scanner sc)
	{
		int UserId = -1;
		System.out.println("Enter Username: ");
		String Username = sc.nextLine();
		System.out.println("Enter Password: ");
		String Password = sc.nextLine();
		
		for(User user : userList)
		{
			if(user.getUsername().equals(Username) && user.checkPassword(Password))
			{
				System.out.println("\nLogin successful. Welcome, "+Username);
				UserId = user.getId();
				break;
			}
		}
		return UserId;
	}
	
	public static void searchBookByTitle(Scanner sc)
	{
		System.out.println("Enter Book Title: ");
		String title = sc.nextLine();
		int found = 0;
		for(Book book : bookList)
		{
			if(book.getTitle().equals(title))
			{
				System.out.println(book);
				found = 1;
			}
		}
		if (found==0)
		{
			System.out.println("\nNo such title exists.");
		}
	}
	
	public static void searchBookByAuthor(Scanner sc)
	{
		System.out.println("Enter Book Author: ");
		String author = sc.nextLine();
		int found = 0;
		for(Book book : bookList)
		{
			if(book.getAuthor().equals(author))
			{
				System.out.println(book);
				found = 1;
			}
		}
		if (found == 0)
		{
			System.out.println("\nNo such author exists");
		}
	}
	
	public static void writeReview(Scanner sc, int UserId)
	{
		System.out.println("Enter Book Title");
		String Title = sc.nextLine();
		
		int BookId = -1;
		for(Book book : bookList)
		{
			if(book.getTitle().equals(Title))
			{
				BookId = book.getId();
			}
		}
		
		if(BookId != -1)
		{
			System.out.println("Enter Review: ");
			String Review = sc.nextLine();
			System.out.println("Enter Rating: ");
			int Rating = sc.nextInt();
			
			Review newReview = new Review(UserId, BookId, Review, Rating);
			reviewList.add(newReview);
			System.out.println("\nNew review added.");
		}
		else
		{
			System.out.println("Invalid Input, try again later.");
		}
	}
	
	public static void deleteReview(Scanner sc, int UserId)
	{
		System.out.println("Enter ReviewId: ");
		int ReviewId = sc.nextInt();
		boolean findId = false;
		
		for(Review review : reviewList)
		{
			if((review.getId() == ReviewId) && (review.getUserId()==UserId))
			{
				findId = true;
			}
		}
		if(findId)
		{
			reviewList.remove(ReviewId);
			System.out.println("Your review is removed");
		}
		else
		{
			System.out.println("Entered Review Id doesn't exist.");
		}
	}
	
	public static void updateReview(Scanner sc, int UserId)
	{
		System.out.println("Enter Book Id: ");
		int BookId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter New Review: ");
		String Review = sc.nextLine();
		for(Review review : reviewList)
		{
			if (review.getUserId()==UserId && review.getBookId()==BookId)
			{
				review.setReviewText(Review);
				System.out.println("Review updated.");
				break;
			}
		}
	}
	
	public static void readMyReviews(int UserId)
	{
		for(Review review : reviewList)
		{
			if (review.getUserId() == UserId)
			{
				System.out.println(review);
			}
		}
	}
	
	public static void bookRating(Scanner sc)
	{
		System.out.println("Enter Book Title: ");
		String title = sc.nextLine();
		int BookId = -1;
		
		for(Book book : bookList)
		{
			if (book.getTitle() == title)
			{
				BookId = book.getId();
			}
		}
		
		if(BookId == -1)
		{
			System.out.println("\nDidn't find the book.");
		}
		else
		{
			float rating = 0;
			int bookCount = 0;
			int sumRating = 0;
			
			for(Review review : reviewList)
			{
				sumRating += review.getRating();
				bookCount += 1;
			}
			rating = sumRating/bookCount;
			System.out.println("Rating of the BookId "+ BookId +" = "+rating);
		}
	}
	
	public static void changePassword(Scanner sc, int UserId)
	{
		System.out.println("Enter Current Password: ");
		String Password = sc.nextLine();
		Boolean correctPass = false;
		
		for(User user : userList)
		{
			if (user.getId() == UserId)
			{
				correctPass = user.checkPassword(Password);			
				break;
			}
		}
		if(correctPass)
		{
			System.out.println("Enter New Password: ");
			String Pass1 = sc.nextLine();
			System.out.println("Enter New Password Again: ");
			String Pass2 = sc.nextLine();
			
			if(Pass1.equals(Pass2))
			{
				for(User user : userList)
				{
					if (user.getId() == UserId)
					{
						user.setPassword(Pass1);
						System.out.println("\nPassword Changed.");
						break;
					}
				}
			}
			else
			{
				System.out.println("\nPasswords do not match, try later.");
			}
		}
	}
	
}

