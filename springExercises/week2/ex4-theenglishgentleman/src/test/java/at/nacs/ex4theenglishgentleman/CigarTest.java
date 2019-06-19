package at.nacs.ex4theenglishgentleman;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CigarTest {

  @Autowired
  Cigar cigar;

  @Test
  void smokeSucceeds() throws CigarWasNotLitException {
    assertFalse(cigar.isLit());
    cigar.setLit(true);
    cigar.smoke();
  }

  @Test
  void smokeFails() {
    assertFalse(cigar.isLit());
    assertThrows(CigarWasNotLitException.class, () -> cigar.smoke());
  }


}