package io.seb.bookmyshow.dtos;

import io.seb.bookmyshow.models.Show;
import io.seb.bookmyshow.models.ShowSeat;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookMovieRequestDto {

    private Long userId;
    private Long showId;
    private List<Long> showSeatIds;

}
