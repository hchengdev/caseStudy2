package Controller;

import Model.Order;
import Model.Room;
import Model.User;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManager {
    List<User> userList = new ArrayList<>();
    List<Room> roomList = new ArrayList<>();
    List<Order> orderList = new ArrayList<>();

    public HotelManager() {
        readFromFileRoom();
        readFromFileUser();
        readFromFileHotel();
    }

    public HotelManager(List<User> userList, List<Room> roomList) {
        this.userList = userList;
        this.roomList = roomList;
    }


    //    Đọc ghi file Room
    public void saveToFileRoom() {
        try {
            Sort.sortRoomPrice(roomList);
            File file = new File("/Users/nguyenhuutrang/Documents/Codegym/JAVA/CaseStudyMd2/src/FileText/rooms.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Room room : roomList) {
                String line = room.getRoomName() + "," + room.getRoomType() + "," + room.getRoomPrice();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readFromFileRoom() {
        try {
            List<String[]> roomList = new ArrayList<String[]>();
            File file = new File("/Users/nguyenhuutrang/Documents/Codegym/JAVA/CaseStudyMd2/src/FileText/rooms.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                roomList.add(line.split(","));
            }

            br.close();
            fr.close();

            for (String[] row : roomList) {
                String roomName = row[0];
                String roomType = row[1];
                long roomPrice = Long.parseLong(row[2]);
                Room room = new Room(roomName, roomType, roomPrice);

                this.roomList.add(room);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    //    CRUD Rooms
    public void addRoom(Scanner scanner) {
        try {
            System.out.println("┎──────────[ADD ROOM]──────────┒");
            System.out.println("[\uD83D\uDD11] Mời bạn nhập thông tin:");
            System.out.println("--------------------------------------");
            System.out.print("┠ ▹ Nhập tên phòng: ");
            String roomName = scanner.nextLine();
            System.out.print("┠ ▹ Nhập kiểu phòng: ");
            String roomType = scanner.nextLine();
            System.out.print("┠ ▹ Nhập giá phòng: ");
            long roomPrice = Long.parseLong(scanner.nextLine());

            Room room = new Room(roomName, roomType, roomPrice);
            this.roomList.add(room);

            saveToFileRoom();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void roomEditName(Scanner scanner) {
        System.out.print("┠ ▹ Nhập tên phòng: ");
        String roomName = scanner.nextLine();
        for (Room room : roomList) {
            if (room.getRoomName().equals(roomName)) {
                System.out.print("┠ ▹ Nhập tên mới của phòng: ");
                String newName = scanner.nextLine();
                room.setRoomName(newName);
            }
        }
        saveToFileRoom();
    }

    public void roomEditType(Scanner scanner) {
        System.out.print("┠ ▹ Nhập tên phòng: ");
        String roomName = scanner.nextLine();
        for (Room room : roomList) {
            if (room.getRoomType().equals(roomName)) {
                System.out.print("┠ ▹ Nhập kiểu phòng: ");
                String roomType = scanner.nextLine();
                room.setRoomType(roomType);
            }
        }
        saveToFileRoom();
    }

    public void roomEditPrice(Scanner scanner) {
        System.out.print("┠ ▹ Nhập tên phòng: ");
        String roomName = scanner.nextLine();
        for (Room room : roomList) {
            if (room.getRoomName().equals(roomName)) {
                System.out.print("┠ ▹ Nhập giá phòng: ");
                long roomPrice = scanner.nextLong();
                room.setRoomPrice(roomPrice);
            }
        }
        saveToFileRoom();
    }

    public void roomDelete(Scanner scanner) {
        System.out.println("┠ ▹ Nhập tên phòng muốn xoá: ");
        String roomName = scanner.nextLine();
        for (Room room : roomList) {
            if (room.getRoomName().equals(roomName)) {
                roomList.remove(room);
                break;
            }
        }
        saveToFileRoom();
    }

    public void showRoomList() {
        for (Room room : roomList) {
            System.out.println(room);
        }
    }


    //    Đọc ghi file User
    private void saveToFileUser() {
        try {
            Sort.sortUser(userList);
            File file = new File("/Users/nguyenhuutrang/Documents/Codegym/JAVA/CaseStudyMd2/src/FileText/user.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (User user : userList) {
                String line = user.getName() + "," + user.getAge() + "," + user.getIdCardNumber();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void readFromFileUser() {
        try {
            List<String[]> userList = new ArrayList<String[]>();
            File file = new File("/Users/nguyenhuutrang/Documents/Codegym/JAVA/CaseStudyMd2/src/FileText/user.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                userList.add(line.split(","));
            }

            br.close();
            fr.close();

            for (String[] row : userList) {
                String userName = row[0];
                int userAge = Integer.parseInt(row[1]);
                double userIdCardNumber = Double.parseDouble(row[2]);
                User user = new User(userName, userAge, userIdCardNumber);

                this.userList.add(user);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    //    CRUD User
    public void addUser(Scanner scanner) {
        try {
            System.out.println("┎──────────[ADD USER]──────────┒");
            System.out.println("[\uD83D\uDD11] Mời bạn nhập thông tin:");
            System.out.println("--------------------------------------");
            System.out.print("┠ ▹ Nhập tên khách hàng: ");
            String userName = scanner.nextLine();
            System.out.print("┠ ▹ Nhập tuổi: ");
            int userAge = Integer.parseInt(scanner.nextLine());
            System.out.print("┠ ▹ Nhập số CCCD: ");
            double userIdCardNumber = Double.parseDouble(scanner.nextLine());

            User user = new User(userName, userAge, userIdCardNumber);
            this.userList.add(user);

            saveToFileUser();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    public void editUserName(Scanner scanner) {
        System.out.println("┠ ▹ Nhập tên khách hàng: ");
        String userName = scanner.nextLine();
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                System.out.println("┠ ▹ Nhập tên mới khách hàng: ");
                String newName = scanner.nextLine();
                user.setName(newName);
            }
        }
    }

    public void editUserAge(Scanner scanner) {
        System.out.println("┠ ▹ Nhập tên khách hàng: ");
        String userName = scanner.nextLine();
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                System.out.println("┠ ▹ Nhập tuổi khách hàng: ");
                int newAge = Integer.parseInt(scanner.nextLine());
                user.setAge(newAge);
            }
        }
    }

    public void editUserIdCardNumber(Scanner scanner) {
        System.out.println("┠ ▹ Nhập tên khách hàng: ");
        String userName = scanner.nextLine();
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                System.out.println("┠ ▹ Nhập số CCCD mới: ");
                double newIdCardNumber = Double.parseDouble(scanner.nextLine());
                user.setIdCardNumber(newIdCardNumber);
            }
        }
    }

    public void removeUser(Scanner scanner) {
        System.out.println("┠ ▹ Nhập tên khách hàng: ");
        String userName = scanner.nextLine();
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                userList.remove(user);
                break;
            }
        }
        saveToFileUser();
    }

    public void showUserList() {
        for (User user : userList) {
            System.out.println(user);
        }
    }

    public void calculateThePrice(Scanner scanner, Order order) {
        System.out.println("┠ ▹ Nhập tên khách hàng: ");
        String userName = scanner.nextLine();
        System.out.println("┠ ▹ Nhập tên phòng: ");
        String roomName = scanner.nextLine();

        System.out.println("┠ ▹ Nhập ngày vào: ");
        int checkinDay = Integer.parseInt(scanner.nextLine());
        System.out.println("┠ ▹ Nhập tháng: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("┠ ▹ Nhập năm: ");
        int year = Integer.parseInt(scanner.nextLine());

        int checkoutDay;
        do {
            System.out.println("┠ ▹ Nhập ngày ra: ");
            checkoutDay = Integer.parseInt(scanner.nextLine());
            if (checkoutDay < checkinDay) {
                System.out.println("Ngay ra khong duoc nho hon ngay vao. Moi nhap lai");
            }
        }while (checkoutDay <= checkinDay);

        for (User user : userList) {
            if (user.getName().equals(userName)) {
                order.setUser(user);
            }
        }

        for (Room room : roomList) {
            if (room.getRoomName().equals(roomName)) {
                order.setRoom(room);
                room.setStatus(false);
            }
        }
        order.setCheckIn(LocalDate.of(year, month, checkinDay));
        order.setCheckOut(LocalDate.of(year, month, checkoutDay));
        System.out.println("┠ ▹ Số tiền cần thanh toán: " + order.getTotalPrice());
    }

    public void searchUserByName(Scanner scanner) {
        System.out.println("┠ ▹ Nhập tên khách hàng: ");
        String userName = scanner.nextLine();
        for (User user : userList) {
            if (user.getName().equals(userName)) {
                System.out.println(user);
            }
        }
    }

    //    add User va Room
    public void hotelList(Scanner scanner, Order order) {
        System.out.println("┠ ▹ Nhập tên khách hàng: ");
        String userName = scanner.nextLine();
        System.out.println("┠ ▹ Nhập tên phòng: ");
        String roomName = scanner.nextLine();

        for (User user : userList) {
            if (user.getName().equals(userName)) {
                order.setUser(user);
                break;
            }
        }

        for (Room room : roomList) {
            if (room.getRoomName().equals(roomName)) {
                order.setRoom(room);
                room.setStatus(true);
                break;
            }
        }

        orderList.add(order);
        Sort.sortOrder(orderList);

        try {

            File file = new File("/Users/nguyenhuutrang/Documents/Codegym/JAVA/CaseStudyMd2/src/FileText/hotelList.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String line = order.getUser().getName() + "," + order.getUser().getAge() + "," + order.getUser().getIdCardNumber()
                    + "," + order.getRoom().getRoomName() + "," + order.getRoom().getRoomType() + "," + order.getRoom().getRoomPrice();


            bufferedWriter.write(line);
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showHoteList() {
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    public void searchHotel(Scanner scanner) {
        System.out.println("┠ ▹ Nhập tên khách hàng: ");
        String userName = scanner.nextLine();
        for (Order o : orderList) {
            if (o.getUser().getName().equals(userName)) {
                System.out.println(o);
            }
        }
    }

    public void readFromFileHotel() {
        try {
            List<String[]> orderList = new ArrayList<String[]>();
            File file = new File("/Users/nguyenhuutrang/Documents/Codegym/JAVA/CaseStudyMd2/src/FileText/hotelList.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                orderList.add(line.split(","));
            }

            br.close();
            fr.close();

            for (String[] row : orderList) {
                String userName = row[0];
                int userAge = Integer.parseInt(row[1]);
                double userCCCD = Double.parseDouble(row[2]);
                String roomName = row[3];
                String roomType = row[4];
                long roomPrice = Long.parseLong(row[5]);
                User user = new User(userName, userAge, userCCCD);
                Room room = new Room(roomName, roomType, roomPrice);

                Order order = new Order(user, room);

                this.orderList.add(order);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
