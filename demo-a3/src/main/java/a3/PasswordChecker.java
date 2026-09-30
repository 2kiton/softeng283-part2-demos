package a3;

public class PasswordChecker {

  public boolean checkPwd(String password) {

    if (password.length() < 8 || password.length() > 20) {
      throw new InvalidPasswordException("lenght shoudl be between 8 and 20");
    }
    return true;
  }
}
