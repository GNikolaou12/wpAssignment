package auction.controllers;

import auction.entities.Offer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class OfferController {

    private ArrayList<Offer> offers = new ArrayList<>();
    private AtomicInteger incrID = new AtomicInteger();

    @PostMapping("/offer")
    @ResponseStatus(HttpStatus.CREATED)
    public Offer createOffer(@RequestBody Offer offer) {
        offer.setId(incrID.incrementAndGet());
        offer.setStartDate();
        offer.setEndDate();

        offers.add(offer);
        return offer;
    }

    @DeleteMapping("/offer/{id}")
    public String deleteOffer(@PathVariable("id") int id) {
        for (Offer offer : offers) {
            if(offer.getId()==id)
                offers.remove(offer);
            return "Success. Offer deleted.";
        }
        return "Not such offer.";
    }

    @GetMapping("/offers")
    public ArrayList<Offer> getAllOffers() {
        return offers;
    }

    @GetMapping("/ongoing")
    public ArrayList<Offer> getOngoingOffers() {
        ArrayList<Offer> ongoingOffers=new ArrayList<>();

        for (Offer offer : offers) {

            try{
                Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(offer.getEndDate());
                if (endDate.after(new Date())) {
                    ongoingOffers.add(offer);
                }
            }
            catch (ParseException pe){
                System.out.println(pe.getMessage());
            }

        }

        return ongoingOffers;
    }

    @GetMapping("/expired")
    public ArrayList<Offer> getExpiredOffers() {
        ArrayList<Offer> expiredOffers=new ArrayList<>();

        for (Offer offer : offers) {

            try{
                Date endDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(offer.getEndDate());
                if (endDate.before(new Date())) {
                    expiredOffers.add(offer);
                }
            }
            catch (ParseException pe){
                System.out.println(pe.getMessage());
            }

        }

        return expiredOffers;
    }

}
