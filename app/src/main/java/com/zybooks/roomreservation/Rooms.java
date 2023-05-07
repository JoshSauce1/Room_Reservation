package com.zybooks.roomreservation;

public class Rooms {
    private String buildingName;
    private String roomNumber;
    private String startTime;
    private String endTime;
    private String Day;
    private String Features;
    private String Name;
    private Integer Id;

    public Rooms(String buildingName, String roomNumber, String day, String startTime, String endTime, String Features) {
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        this.Day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.Features = Features;
    }

    //Setters
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public void setroomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setstartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setendTime(String endTime) {
        this.endTime = endTime;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setFeatures(Integer Features) {
        this.Features = Rooms.this.Features;
    }

    public void setDat(String Day) {
        this.Day = Day;
    }

    public void setID(Integer id) {
        this.Id = id;
    }


    //Getters
    public String getBuildingName() {
        return buildingName;
    }

    public String getroomNumber() {
        return roomNumber;
    }

    public String getstartTime() {
        return startTime;
    }

    public String getendTime() {
        return endTime;
    }

    public String getName() {
        return Name;
    }

    public String getFeatures() {
        return Features;
    }

    public String getDay() {
        return Day;
    }

    public Integer getID() {
        return Id;

    }
}