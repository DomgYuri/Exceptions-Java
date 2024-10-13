package TestesExceptions.models.entities;

import TestesExceptions.models.exceptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer numberRoom;

    private Date checkIn;

    private Date checkOut;

    public Reservation () {

    }

    public Reservation(Integer numberRoom, Date checkIn, Date checkOut) {
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Check-Out date after Check-In date.");
        }
        this.numberRoom = numberRoom;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration () {
        long result = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(result, TimeUnit.MILLISECONDS);
    }

    public void updateDate (Date checkIn, Date checkOut) {
        Date date = new Date();
        if (checkIn.before(date) || checkOut.before(date)) {
            throw  new DomainException("Reservation dates for update must be future dates ");
        }
        if (!checkOut.after(checkIn)) {
            throw  new DomainException("Check-Out date after Check-In date.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Reservation: Room: " + numberRoom
                + ", ChekIn: " + sdf.format(checkIn)
                + ", Chekout: " + sdf.format(checkOut)
                + ", Duration: " + duration() + " nights";
    }
}
