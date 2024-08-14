package io.seb.bookmyshow.controllers;

import io.seb.bookmyshow.dtos.ResponseStatus;
import io.seb.bookmyshow.dtos.SignUpRequestDto;
import io.seb.bookmyshow.dtos.SignUpResponseDto;
import io.seb.bookmyshow.models.User;
import io.seb.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignUpResponseDto signUp(SignUpRequestDto requestDto) {

        SignUpResponseDto responseDto = new SignUpResponseDto();

        try {
            User user = userService.signUp(
                    requestDto.getName(),
                    requestDto.getEmail(),
                    requestDto.getPassword()
            );
            responseDto.setUser(user);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }


        return responseDto;
    }

}
