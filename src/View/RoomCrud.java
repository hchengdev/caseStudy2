package View;

import Controller.HotelManager;
import Menu.AllMenu;
import Menu.CrudMenu;

import java.util.Scanner;

public class RoomCrud {
    public static void roomCrud(Scanner scanner, HotelManager hotelManager) {


        boolean flag = true;
        while (flag) {
            AllMenu.menuRoom();
            System.out.println("┠ ▹ Xin mời nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    hotelManager.addRoom(scanner);
                    break;
                case 2:
                    CrudMenu.editRoom();
                    editRoom(hotelManager, scanner);
                    break;
                case 3:
                    hotelManager.roomDelete(scanner);
                    break;
                case 4:
                    hotelManager.showRoomList();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void editRoom(HotelManager hotelManager, Scanner scanner) {
        System.out.println("┠ ▹ Xin mới nhập lựa chọn: ");
        int choice2 = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        while (flag) {
            switch (choice2) {
                case 1:
                    hotelManager.roomEditName(scanner);
                    flag=false;
                    break;
                case 2:
                    hotelManager.roomEditType(scanner);
                    flag=false;
                    break;
                case 3:
                    hotelManager.roomEditPrice(scanner);
                    flag=false;
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
