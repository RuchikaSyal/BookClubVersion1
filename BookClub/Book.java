package BookClub;

public class Book 
{	
	private static int IdCounter=1;
	private int Id;
	private String Author;
	private String Title;
	private String Genre;
	private String Description;
	private int TotalVotes;
	
	Book(String Title, String Author, String Genre, String Description)
	{
		this.Id=IdCounter++;
		this.Title=Title;
		this.Author=Author;
		this.Genre=Genre;
		this.Description=Description;
	}
	public int getId()
	{
		return Id;
	}
	public void setId(int Id)
	{
		this.Id=IdCounter++;
	}
	public String getAuthor()
	{
		return Author;
	}
	public void setAuthor(String Author)
	{
		this.Author=Author;
	}
	public String getTitle()
	{
		return Title;
	}
	public void setTitle(String Title)
	{
		this.Title=Title;
	}
	public String toString()
	{
		return "Book{" +"Id=" + Id +", Title='" + Title + '\'' +", Author='" + Author + '\'' +", Genre='" + Genre + '\'' +'}';
	}
	public String getGenre()
	{
		return Genre;
	}
	public void setGenre(String Genre)
	{
		this.Genre=Genre;
	}
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String Description)
	{
		this.Description=Description;
	}
	public int getTotalVotes()
	{
		return TotalVotes;
	}
	public void setTotalVotes(int TotalVotes)
	{
		this.TotalVotes=TotalVotes;
	}

}
