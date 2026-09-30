package a3;

public class PasswordChecker {

  public boolean checkPwd(String password) {

    if (password.length() < 8) {
      throw new InvalidPasswordException("length is not enough");
    }
    return true;
  }
}
