package TestesExceptions.application;

import TestesExceptions.models.entities.Reservation;
import TestesExceptions.models.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Number Room: ");
            int numberRoom = sc.nextInt();
            System.out.print("Check-In date: ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date: ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();

            System.out.println("Enter data to update reservation:");
            System.out.print("Check-In date: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date: ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDate(checkIn, checkOut);
            System.out.println(reservation);
        } catch (ParseException e) {
            throw new RuntimeException("Error in reservation: Date invalid");
        } catch (DomainException e) {
            System.out.println("ERROR IN RESERVATION: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
        }
        sc.close();
    }

}
