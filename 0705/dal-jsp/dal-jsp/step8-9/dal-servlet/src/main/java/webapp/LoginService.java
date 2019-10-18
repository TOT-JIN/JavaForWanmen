package webapp;

public class LoginService implements AuthService{
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("joshua") && password.equals("dal");
	}

}