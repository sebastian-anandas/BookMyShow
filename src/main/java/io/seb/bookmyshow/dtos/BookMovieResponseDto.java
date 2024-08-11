package io.seb.bookmyshow.dtos;

import io.seb.bookmyshow.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {

    private Booking booking;
    private ResponseStatus responseStatus;

}
