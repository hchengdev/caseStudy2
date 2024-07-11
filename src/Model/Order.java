package Model;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Order {
    private LocalDate checkIn;
    private LocalDate checkOut;
    private User user;
    private Room room;

    public Order() {
    }

    public Order(User user, Room room) {
        this.user = user;
        this.room = room;
    }

    public Order(LocalDate checkIn, LocalDate checkOut, User user, Room room) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.user = user;
        this.room = room;
    }

    public long getTotalPrice() {
        long result;
        long numDay = DAYS.between(checkIn, checkOut);
        long roomPrice = room.getRoomPrice();
        result = numDay * roomPrice;
        return result;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Order {" +
                getUser().getName() + "," + getUser().getAge() + "," + getUser().getIdCardNumber()
                + "," + getRoom().getRoomName() + "," + getRoom().getRoomType() + "," + getRoom().getRoomPrice() +
                '}';
    }
}
