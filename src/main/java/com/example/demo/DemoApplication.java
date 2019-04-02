package com.example.demo;

import com.example.demo.admin.Admin;
import com.example.demo.flight.Flight;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.example.demo.flight.FlightType.MYFLIGHT;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        Admin admin = new Admin.Builder()
                .setNuOfBuisnessClass(4).setNuOfEconomyClass(6).setTotalNumberOfSeats(10).build();

        admin.addFlight(MYFLIGHT);

        ReservationSystem reservationSystem = ReservationSystem.getInstance();

        Flight flight = reservationSystem.getFlight(111);

        System.out.println(reservationSystem.checkAvailable(flight,"1A"));

        reservationSystem.reserveMySeat(flight,"1A");

    }

}
