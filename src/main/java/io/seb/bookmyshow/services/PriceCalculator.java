package io.seb.bookmyshow.services;

import io.seb.bookmyshow.models.Show;
import io.seb.bookmyshow.models.ShowSeat;
import io.seb.bookmyshow.models.ShowSeatType;
import io.seb.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculator {

    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculator(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }

    public int priceCalculator(List<ShowSeat> showSeats, Show show) {
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        int amount = 0;

        for(ShowSeat showSeat : showSeats) {
            for(ShowSeatType showSeatType : showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())) {
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;

    }

}
