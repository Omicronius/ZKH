package by.pvt.zkh.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
    private String login;
    private String password;
    private int role;
	private String email;
	private String phone;

	public static class Builder {
		private int id;
		private String login;
		private String password;
		private int role;
		private String email;
		private String phone;
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder login(String login) {
			this.login = login;
			return this;
		}
		
		public Builder password(String password) {
			this.password = password;
			return this;
		}
		
		public Builder role(int role) {
			this.role = role;
			return this;
		}
		
		public Builder email(String email) {
			this.email = email;
			return this;
		}
		
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	private User(Builder builder) {
		id = builder.id;
		login = builder.login;
		password = builder.password;
		role = builder.role;
		email = builder.email;
		phone = builder.phone;
	}
    
    public User() {}
    
    public User(int id, String login, String password, int role, String email, String phone) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", role=" + role + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

}
