package src.java.practice.java;

public class FactoryDesignPatternImmutableObject {

	// client code.
	public static void main(String[] args) {
		ImmutableUser user = new ImmutableUser.UserBuilder("pumpkin", "password").build();
		System.out.println(user.getEmail());
		System.out.println(user);
		ImmutableUser user2 = new ImmutableUser.UserBuilder("pumpkin", "password").firstName("kahtri").build();
		System.out.println(user2);
	}
}

class ImmutableUser {
	private final String username;
	private final String password;
	private final String firstname;
	private final String lastname;
	private final String email;

	private ImmutableUser(UserBuilder usrBuild) {
		this.username = usrBuild.username;
		this.lastname = usrBuild.lastname;
		this.email = usrBuild.email;
		this.firstname = usrBuild.firstname;
		this.password = usrBuild.password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public static class UserBuilder {
		private final String username;
		private final String password;
		private String firstname;
		private String lastname;
		private String email;

		public UserBuilder(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public UserBuilder firstName(String firstName) {
			this.firstname = firstName;
			return this;
		}

		public UserBuilder lastName(String lastName) {
			this.lastname = lastName;
			return this;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public ImmutableUser build() {
			return new ImmutableUser(this);
		}

	}
}
