package com.example.demo;

import com.example.demo.flight.Flight;

import java.util.HashMap;
import java.util.Map;


public class ReservationSystem {

    private static ReservationSystem ourInstance = new ReservationSystem();


    private static Map<Integer,Flight> flightMap = new HashMap<>();

    public static ReservationSystem getInstance() {

        return ourInstance;
    }


    private ReservationSystem() {

    }


    public void addFlightToSystem(int flightNumber, Flight flight) {

        flightMap.put(flightNumber, flight);
    }


    public Flight getFlight(int flightNumber) {

        return flightMap.get(flightNumber);
    }


    public String reserveMySeat(Flight flight,String seatNumber){

        return flight.reserveSeat(seatNumber);
    }

    public String cancelReservation(Flight flight,String seatNumber){

        return flight.cancelSeat(seatNumber);
    }


    public boolean checkAvailable(Flight flight,String seatNumber){

        return flight.isSeatAvailable(seatNumber);
    }
}
