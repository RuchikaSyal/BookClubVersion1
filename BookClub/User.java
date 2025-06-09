package BookClub;

public class User
{	
	private static int IdCounter=1;
	private int Id;
	private String Name;
	private String Username;
	private String Password;
	
	public User(String Name, String Username, String Password)
	{
		this.Id = IdCounter++;
		this.Name = Name;
		this.Username = Username;
		this.Password = Password;
	}
	public int getId()
	{
		return Id;
	}
	public void setId(int Id)
	{
		this.Id=Id;
	}
	public String getName()
	{
		return Name;
	}
	public void setName(String Name)
	{
		this.Name=Name;
	}
	public String getUsername()
	{
		return Username;
	}
	public void setUsername(String Username)
	{
		this.Username=Username;
	}
	//password should not have getter function
	public void setPassword(String Password)
	{
		this.Password=Password;
	}
	public String toString()
	{
		return "User{Id="+Id+", Name='"+Name+"', Username='"+Username+"'}";
	}
	
	public boolean checkPassword(String inputPassword)
	{
		return this.Password.equals(inputPassword);
	}
	
	public boolean validateLogin(String inputUsername, String inputPassword)
	{
		return this.Username.equals(inputPassword) && this.Password.equals(inputPassword);
	}
	
}
