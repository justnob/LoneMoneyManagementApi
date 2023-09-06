package com.moneydiary.moneydiary.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GivenLoanDTO {

    private long id;

    private String title;

    private String type;

    private LocalDate givenDate;

    private LocalDate dueDate;

    private int amount;

    private String description;

}
