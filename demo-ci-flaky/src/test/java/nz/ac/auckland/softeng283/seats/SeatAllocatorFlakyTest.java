package nz.ac.auckland.softeng283.seats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
class SeatAllocatorFlakyTest {

  private static final SeatAllocator SHARED_ALLOCATOR =
      new SeatAllocator(List.of("A1", "A2"));

  @Test
  void allocatorStartsWithTwoSeats() {
    assertEquals(2, SHARED_ALLOCATOR.getAvailableSeatCount());
  }

  @Test
  void reservingA1LeavesOneSeat() {
    assertTrue(SHARED_ALLOCATOR.reserve("A1"));

    assertEquals(1, SHARED_ALLOCATOR.getAvailableSeatCount());
  }

  @Test
  void firstRandomReservationIsA1() {
    SeatAllocator allocator = new SeatAllocator(List.of("A1", "A2"), new Random());

    assertEquals("A1", allocator.reserveRandomSeat());
  }
}
