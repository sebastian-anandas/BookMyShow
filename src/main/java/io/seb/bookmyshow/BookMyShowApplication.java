package io.seb.bookmyshow;

import io.seb.bookmyshow.controllers.UserController;
import io.seb.bookmyshow.dtos.SignUpRequestDto;
import io.seb.bookmyshow.dtos.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {

    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDto requestDto = new SignUpRequestDto();
        requestDto.setName("MohitCool");
        requestDto.setEmail("MohitCool1@scaler.com");
        requestDto.setPassword("scaler123");

        SignUpResponseDto responseDto = userController.signUp(requestDto);
        System.out.println("DEBUG");

    }
}
