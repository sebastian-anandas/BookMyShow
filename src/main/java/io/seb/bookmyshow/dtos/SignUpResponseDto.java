package io.seb.bookmyshow.dtos;

import io.seb.bookmyshow.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {

    private User user;
    private ResponseStatus responseStatus;

}
