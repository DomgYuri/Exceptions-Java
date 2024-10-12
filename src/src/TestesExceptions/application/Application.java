package TestesExceptions.application;

import TestesExceptions.models.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Number Room: ");
        int numberRoom = sc.nextInt();
        System.out.print("Check-In date: ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out date: ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("ERROR IN RESERVATION!!!");
            System.out.println("Check-Out date after Check-In date.");
        } else {
            Reservation reservation = new Reservation(numberRoom, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();

            System.out.println("Enter data to update reservation:");
            System.out.print("Check-In date: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date: ");
            checkOut = sdf.parse(sc.next());

            Date date = new Date();

            if (checkIn.before(date) || checkOut.before(date)) {
                System.out.println("ERROR IN RESERVATION!!!");
                System.out.println("Reservation dates for update must be future dates ");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("ERROR IN RESERVATION!!!");
                System.out.println("Check-Out date after Check-In date.");
            } else {
                reservation.updateDate(checkIn,checkOut);
                System.out.println(reservation);
            }
        }
        sc.close();
    }

}
