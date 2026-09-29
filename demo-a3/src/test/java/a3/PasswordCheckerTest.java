package a3;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PasswordCheckerTest {

  @Test
  public void validatePassword_length7_returnsError() {
    // ARANGE
    String password = "Aa1!xxx";
    PasswordChecker checker = new PasswordChecker();
    // ACT
    // ASSERT
    assertThrows(InvalidPasswordException.class, () -> checker.checkPwd(password));
  }
}
