package a3;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @Test
  public void validatePassword_length8_returnsOk() {
    // ARANGE
    String password = "Aa1!xxxx";
    PasswordChecker checker = new PasswordChecker();
    // ACT
    boolean result = checker.checkPwd(password);
    // ASSERT
    assertTrue(result);
    assertDoesNotThrow(() -> checker.checkPwd(password), "exception should not throw");
  }
}
