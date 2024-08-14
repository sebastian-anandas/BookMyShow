package io.seb.bookmyshow.controllers;

import io.seb.bookmyshow.dtos.BookMovieRequestDto;
import io.seb.bookmyshow.dtos.BookMovieResponseDto;
import io.seb.bookmyshow.dtos.ResponseStatus;
import io.seb.bookmyshow.models.Booking;
import io.seb.bookmyshow.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookMovieResponseDto bookMovie(BookMovieRequestDto requestDto) {

        BookMovieResponseDto responseDto = new BookMovieResponseDto();

        try {
            Booking booking = bookingService.bookMovie(
                    requestDto.getUserId(),
                    requestDto.getShowId(),
                    requestDto.getShowSeatIds()
            );

            responseDto.setBooking(booking);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }

}
