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

@Test
  public void validatePassword_length9_returnsOk(){
 // ARANGE
    String password = "Aa1!xxxxy";
    PasswordChecker checker = new PasswordChecker();
    // ACT
    boolean result = checker.checkPwd(password);
    // ASSERT
    assertTrue(result);
    assertDoesNotThrow(() -> checker.checkPwd(password), "exception should not throw");
  }

  @Test
  public void validatePassword_length19_returnsOk(){
 // ARANGE
    String password = "Aa1!xxxxy1234567890";
    PasswordChecker checker = new PasswordChecker();
    // ACT
    boolean result = checker.checkPwd(password);
    // ASSERT
    assertTrue(result);
    assertDoesNotThrow(() -> checker.checkPwd(password), "exception should not throw");
  }

    @Test
  public void validatePassword_length20_returnsOk(){
 // ARANGE
    String password = "Aa1!xxxxy12345678901";
    PasswordChecker checker = new PasswordChecker();
    // ACT
    boolean result = checker.checkPwd(password);
    // ASSERT
    assertTrue(result);
    assertDoesNotThrow(() -> checker.checkPwd(password), "exception should not throw");
  }

  @Test
  public void validatePassword_length21_returnsOk(){
 // ARANGE
    String password = "Aa1!xxxxy123456789012";
    PasswordChecker checker = new PasswordChecker();
    // ACT
    assertThrows(InvalidPasswordException.class, () -> checker.checkPwd(password));
  }




}
