package nz.ac.auckland.softeng283.seats;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/** Allocates named seats for a small event. */
public class SeatAllocator {

  private int k= 0;
  private final List<String> availableSeats;
  private final Random random;

  public SeatAllocator(List<String> seats) {
    this(seats, new Random());
  }

  public SeatAllocator(List<String> seats, Random random) {
    this.availableSeats = new ArrayList<>(Objects.requireNonNull(seats, "Seats cannot be null"));
    this.random = Objects.requireNonNull(random, "Random generator cannot be null");
  }

  public int getAvailableSeatCount() {
    return availableSeats.size();
  }

  public boolean reserve(String seat) {
    return availableSeats.remove(seat);
  }

  /** Reserves one available seat selected at random, or returns null when full. */
  public String reserveRandomSeat() {
    if (availableSeats.isEmpty()) {
      return null;
    }

    int index = random.nextInt(availableSeats.size());
    return availableSeats.remove(index);
  }
}
