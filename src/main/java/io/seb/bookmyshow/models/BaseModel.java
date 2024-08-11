package io.seb.bookmyshow.models;

import jakarta.persistence.*;
import jdk.jfr.MemoryAddress;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    private Date createdAt;
    private Date lastModifiedAt;

}
