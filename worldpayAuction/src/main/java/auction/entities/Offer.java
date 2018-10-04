package auction.entities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Offer {
    private int id;
    private String title;
    private String description;
    private String currency;
    private double price;
    private String duration;
    private String startDate;
    private String endDate;

    public Offer() { }

    public Offer(int id, String title, String description, String currency, double price, String duration) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.currency= currency;
        this.price = price;
        this.duration=duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return description;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        this.startDate = dateFormat.format(new Date());;;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        String[] durArray=this.duration.split( " ");
        int dateIncrement= Integer.parseInt(durArray[0]);

        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(startDate)); // sets calendar time/date
        }catch (ParseException pe){
            System.out.println(pe.getMessage());
        }

        if(durArray[1].contains("minute")){
            cal.add(Calendar.MINUTE, dateIncrement); // adds one hour
        }
        else if (durArray[1].contains("hour")){
            cal.add(Calendar.HOUR_OF_DAY, dateIncrement); // adds one hour
        }
        else if (durArray[1].contains("day")){
            cal.add(Calendar.DATE, dateIncrement); // adds one hour
        }
        else if (durArray[1].contains("week")){
            cal.add(Calendar.DATE, dateIncrement*7); // adds one hour
        }

        this.endDate = dateFormat.format(cal.getTime());;
    }
}

