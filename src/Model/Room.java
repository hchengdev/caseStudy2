package Model;

public class Room {
    private String roomName;
    private String roomType;
    private long roomPrice;
    private boolean status;

    public Room() {
    }

    public Room(String roomName, String roomType, long roomPrice) {
        this.roomName = roomName;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.status = false;
    }

    public Room(String userName, int userAge, double idCardNumber) {
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public long getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(long roomPrice) {
        this.roomPrice = roomPrice;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomName='" + roomName + '\'' +
                ", roomType='" + roomType + '\'' +
                ", roomPrice='" + roomPrice + '\'' +
                '}';
    }
}
