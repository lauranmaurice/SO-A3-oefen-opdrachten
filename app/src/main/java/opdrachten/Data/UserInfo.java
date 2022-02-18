package opdrachten.Data;

import java.time.LocalDateTime;

import opdrachten.Domain.MovieTicket;

public class UserInfo {
    private int orderNr;
    private MovieTicket[] tickets;
    private LocalDateTime timeMovie;
    private String movieName;
    private String emailOrPhone;
    private String name;

    public UserInfo(int orderNr, MovieTicket[] tickets, LocalDateTime movieTime, String movieName, String emailOrPhoneOrPhone, String name) {
        this.setOrderNr(orderNr);
        this.setTickets(tickets);
        this.setTimeMovie(movieTime);
        this.setMovieName(movieName);
        this.setEmailOrPhone(emailOrPhone);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailOrPhone() {
        return emailOrPhone;
    }

    public void setEmailOrPhone(String emailOrPhone) {
        this.emailOrPhone = emailOrPhone;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public LocalDateTime getTimeMovie() {
        return timeMovie;
    }

    public void setTimeMovie(LocalDateTime timeMovie) {
        this.timeMovie = timeMovie;
    }

    public MovieTicket[] getTickets() {
        return tickets;
    }

    public void setTickets(MovieTicket[] tickets) {
        this.tickets = tickets;
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }
}
