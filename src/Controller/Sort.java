package Controller;

import Model.Order;
import Model.Room;
import Model.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void sortRoomPrice(List<Room> rooms) {
        rooms.sort(Comparator.comparing(Room::getRoomPrice));
    }

    public static void sortUser(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getName().compareTo(u2.getName());
            }
        });
    }

    public static void sortOrder(List<Order> orders) {
        orders.sort(new Comparator<Order>() {
            @Override
            public int compare(Order u1, Order u2) {
                return u1.getUser().getName().compareTo(u2.getUser().getName());
            }
        });
    }
}
