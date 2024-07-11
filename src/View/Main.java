package View;

import Controller.HotelManager;
import Menu.AllMenu;
import Model.Order;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HotelManager hotelManager = new HotelManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            AllMenu.allMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    UserCrud.userCrud(scanner, hotelManager);
                    break;
                case 2:
                    RoomCrud.roomCrud(scanner, hotelManager);
                    break;
                default:
                    break;
            }
        }
    }
}