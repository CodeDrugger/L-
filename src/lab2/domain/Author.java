package lab2.domain;


public class Author {
	private int authorid;
	private String authorname;
	private String age;
	private String country;
		
	public int getAuthorid() {
		return authorid;
	}

	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void Copy(Author au)
	{
		this.setAge(au.getAge());
		this.setAuthorid(au.getAuthorid());
		this.setAuthorname(au.getAuthorname());
		this.setCountry(au.getCountry());
	}
	
}
