package View;

import Controller.HotelManager;
import Menu.AllMenu;
import Menu.CrudMenu;
import Model.Order;

import java.util.Scanner;

public class UserCrud {
    public static void userCrud(Scanner scanner, HotelManager hotelManager) {
        Order order = new Order();
        boolean flag = true;
        while (flag) {
            AllMenu.menuUser();
            System.out.println("┠ ▹ Xin mới nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    hotelManager.addUser(scanner);
                    break;
                case 2:
                    CrudMenu.editUser();
                    editUser(hotelManager, scanner);
                    break;
                case 3:
                    hotelManager.removeUser(scanner);
                    break;
                case 4:
                    hotelManager.showUserList();
                    break;
                case 5:
                    hotelManager.hotelList(scanner, order);
                    flag = false;
                    break;
                case 6:
                    hotelManager.showHoteList();
                    flag = false;
                    break;
                case 7:
                    hotelManager.calculateThePrice(scanner, order);
                    flag=false;
                    break;
                case 8:
                    hotelManager.searchUserByName(scanner);
                    flag=false;
                    break;
                case 9:
                    hotelManager.searchHotel(scanner);
                    flag=false;
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void editUser(HotelManager hotelManager, Scanner scanner) {
        System.out.println("┠ ▹ Xin mới nhập lựa chọn: ");
        int choice2 = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        while (flag) {
            switch (choice2) {
                case 1:
                    hotelManager.editUserName(scanner);
                    flag=false;
                    break;
                case 2:
                    hotelManager.editUserAge(scanner);
                    flag=false;
                    break;
                case 3:
                    hotelManager.editUserIdCardNumber(scanner);
                    flag=false;
                    break;

                case 0:
                    flag = false;
                    break;
            }
        }
    }
}
