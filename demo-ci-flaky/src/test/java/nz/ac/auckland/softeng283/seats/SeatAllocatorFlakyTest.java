package nz.ac.auckland.softeng283.seats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

@TestMethodOrder(MethodOrderer.Random.class)
class SeatAllocatorFlakyTest {

  SeatAllocator seatAllocator;

  @BeforeEach
  public void setUp() {
    seatAllocator = new SeatAllocator(List.of("A1", "A2"));
  }

  @Test
  void allocatorStartsWithTwoSeats() {
    assertEquals(2, seatAllocator.getAvailableSeatCount());
  }

  @Test
  void reservingA1LeavesOneSeat() {
     seatAllocator.reserve("A1");
    assertEquals(1, seatAllocator.getAvailableSeatCount());
  }

  @Test
  void firstRandomReservationIsA1() {

   Random random = Mockito.mock(Random.class);

    SeatAllocator allocator = new SeatAllocator(List.of("A1", "A2"), random);
    Mockito.when(random.nextInt(2)).thenReturn(0);
    assertEquals("A1", allocator.reserveRandomSeat());
  }
}
