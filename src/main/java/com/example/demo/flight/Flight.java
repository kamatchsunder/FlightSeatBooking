package com.example.demo.flight;

import com.example.demo.flight.seating.Seat;
import com.example.demo.flight.seating.SeatStatus;
import com.example.demo.flight.seating.SeatType;


public abstract class Flight {

    private int totalNumberOfSeats;
    private int numberOfBuisnessClassSeats;
    private int numberOfEconomyClassSeats;


    private Seat[][] seatingArrangements;


    public Flight(final int totalNumberOfSeats, final int numberOfBuisnessClassSeats, final int numberOfEconomyClassSeats) {

        this.totalNumberOfSeats = totalNumberOfSeats;
        this.numberOfBuisnessClassSeats = numberOfBuisnessClassSeats;
        this.numberOfEconomyClassSeats = numberOfEconomyClassSeats;
        initializeSeats();
    }


    private void initializeSeats() {

        int rows = Math.round(totalNumberOfSeats/4);

        String[] columnArray = {"A","B","C","D"};

        seatingArrangements = new Seat[rows][columnArray.length];

        int buisnessClassCount =0;

        for(int i=0;i<rows;i++){

            for(int j=0;j<columnArray.length;j++) {

                if(buisnessClassCount >= numberOfBuisnessClassSeats){
                    seatingArrangements[i][j] = new Seat(i+""+columnArray[j],SeatType.ECONOMY,SeatStatus.AVAILABLE);

                }
                else {
                    seatingArrangements[i][j] = new Seat(i+""+columnArray[j], SeatType.BUISNESS, SeatStatus.AVAILABLE);
                    buisnessClassCount++;
                }
            }
        }
    }


    public String reserveSeat(String number){

        String[] columnArray = {"A","B","C","D"};
        for (Seat[] seatingArrangement : seatingArrangements) {

            for (int j = 0; j < columnArray.length; j++) {
                Seat seat = seatingArrangement[j];
                if (seat.getSeatNumber().equals(number) && seat.getSeatStatus() == SeatStatus.AVAILABLE) {

                    seat.setSeatStatus(SeatStatus.BOOKED);

                    return "seat Booked";
                }
            }
        }
        return "seat No Available";
    }

    public String cancelSeat(String number){

        String[] columnArray = {"A","B","C","D"};
        for (Seat[] seatingArrangement : seatingArrangements) {

            for (int j = 0; j < columnArray.length; j++) {
                Seat seat = seatingArrangement[j];
                if (seat.getSeatNumber().equals(number) && seat.getSeatStatus() == SeatStatus.BOOKED) {

                    seat.setSeatStatus(SeatStatus.AVAILABLE);

                    return "seat Cancelled";
                }
            }
        }
        return "seat could not be cancelled";
    }

    public boolean  isSeatAvailable(String number){

        String[] columnArray = { "A", "B", "C", "D" };
        for (Seat[] seatingArrangement : seatingArrangements) {

            for (int j = 0; j < columnArray.length; j++) {
                Seat seat = seatingArrangement[j];
                if (seat.getSeatNumber().equals(number) && seat.getSeatStatus() == SeatStatus.AVAILABLE) {

                    return true;

                }
            }
        }
        return false;
    }

}
