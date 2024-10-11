package TestesExceptions.models;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer numberRoom;

    private Date checkIn;

    private Date checkOut;

    public Reservation () {

    }

    public Reservation(Integer numberRoom, Date checkIn, Date checkOut) {
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
        long result = checkIn.getTime() + checkOut.getTime();
        return TimeUnit.DAYS.convert(result, TimeUnit.MICROSECONDS);
    }



}
