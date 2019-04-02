package com.example.demo.flight.seating;

public class Seat {

    private String seatNumber;
    private SeatType seatType;
    private SeatStatus seatStatus;


    public Seat(String seatNumber, SeatType seatType, SeatStatus seatStatus) {

        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }


    public String getSeatNumber() {

        return seatNumber;
    }


    public void setSeatNumber(String seatNumber) {

        this.seatNumber = seatNumber;
    }


    public SeatType getSeatType() {

        return seatType;
    }


    public void setSeatType(SeatType seatType) {

        this.seatType = seatType;
    }


    public SeatStatus getSeatStatus() {

        return seatStatus;
    }


    public void setSeatStatus(SeatStatus seatStatus) {

        this.seatStatus = seatStatus;
    }
}
