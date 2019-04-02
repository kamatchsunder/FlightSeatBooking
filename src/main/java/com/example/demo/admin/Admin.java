package com.example.demo.admin;

import com.example.demo.flight.Boeing;
import com.example.demo.ReservationSystem;
import com.example.demo.flight.Flight;
import com.example.demo.flight.FlightType;
import com.example.demo.flight.MyFlight;


public class Admin {

    int flightNumber=0;
    int totalNumberOfSeats=0;
    int nuOfBuisnessClass=0;
    int nuOfEconomyClass=0;

    public Admin(Builder builder){

        int flightNumber=builder.flightNumber;
        int totalNumberOfSeats=builder.totalNumberOfSeats;
        int nuOfBuisnessClass=builder.nuOfBuisnessClass;
        int nuOfEconomyClass=builder.nuOfEconomyClass;
    }

    public void addFlight(FlightType flightType){

        switch (flightType) {

        case MYFLIGHT: {
            Flight flight = new MyFlight(totalNumberOfSeats, nuOfBuisnessClass, nuOfEconomyClass);

            ReservationSystem.getInstance().addFlightToSystem(flightNumber, flight);
        }

        case BOEING: {

            Flight flight = new Boeing(totalNumberOfSeats, nuOfBuisnessClass, nuOfEconomyClass);

            ReservationSystem.getInstance().addFlightToSystem(flightNumber, flight);
        }
        default:
            break;

        }

    }


    static class Builder{

        private int flightNumber=0;
        private int totalNumberOfSeats=0;
        private int nuOfBuisnessClass=0;
        private int nuOfEconomyClass=0;

        public Builder() {}


        public Builder setFlightNumber(int flightNumber) {

            this.flightNumber = flightNumber;
            return this;
        }


        public Builder setTotalNumberOfSeats(int totalNumberOfSeats) {

            this.totalNumberOfSeats = totalNumberOfSeats;
            return this;
        }


        public Builder setNuOfBuisnessClass(int nuOfBuisnessClass) {

            this.nuOfBuisnessClass = nuOfBuisnessClass;
            return this;
        }


        public Builder setNuOfEconomyClass(int nuOfEconomyClass) {

            this.nuOfEconomyClass = nuOfEconomyClass;
            return this;
        }

        public Admin build(){
            return new Admin(this);
        }
    }

}
