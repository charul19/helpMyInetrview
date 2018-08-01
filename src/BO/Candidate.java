package BO;


public class Candidate {
	private String fname;
	private String lname;
	private String email;
	private long contact_no;
    private String uname;
	private String password;
	private String rpassword;
	
	public Candidate(String fname, String lname, String email, long contact_no, String uname, String password,
			String rpassword) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact_no = contact_no;
		this.uname = uname;
		this.password = password;
		this.rpassword = rpassword;
	}

	public Candidate() {
		super();
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact_no() {
		return contact_no;
	}

	public void setContact_no(long contact_no) {
		this.contact_no = contact_no;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRpassword() {
		return rpassword;
	}

	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}

	@Override
	public String toString() {
		return "canditate [fname=" + fname + ", lname=" + lname + ", email=" + email + ", contact_no=" + contact_no
				+ ", uname=" + uname + ", password=" + password + ", rpassword=" + rpassword + "]";
	}
	
		
}
