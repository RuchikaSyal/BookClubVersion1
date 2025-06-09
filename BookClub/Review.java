package BookClub;

import java.time.LocalDateTime;

public class Review 
{
	private static int IdCounter=1;
	private int Id;
	private int UserId;
	private int BookId;
	private String ReviewText;
	private int Rating; //1-5 stars 
	private LocalDateTime ReviewDate;
	
	Review(int UserId, int BookId, String ReviewText, int Rating)
	{
		this.Id=IdCounter++;
		this.UserId=UserId;
		this.BookId=BookId;
		this.ReviewText=ReviewText;
		this.Rating=Rating;
		this.ReviewDate = LocalDateTime.now();
	}
	public int getId()
	{
		return Id;
	}
	public int getUserId()
	{
		return UserId;
	}
	public int getBookId()
	{
		return BookId;
	}
	public String getReviewText()
	{
		return ReviewText;
	}	
	public void setReviewText(String ReviewText)
	{
		this.ReviewText=ReviewText;
	}
	public int getRating()
	{
		return Rating;
	}
	public void setRating(int Rating)
	{
		this.Rating=Rating;
	}
	public LocalDateTime getReviewDate()
	{
		return ReviewDate;
	}
	public String toString()
	{
		return "Review{Id="+Id+", BookId='"+BookId+"', ReviewText='"+ReviewText+"', Rating='"+Rating+"' ReviewDate='"+ReviewDate+"'}";
	}

}
