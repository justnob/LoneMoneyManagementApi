package com.moneydiary.moneydiary.Validations;

import com.moneydiary.moneydiary.DTO.GivenLoanDTO;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class GivenLoanCreationRequestValidation {

    public void validate(GivenLoanDTO givenLoanDTO){

        if (givenLoanDTO.getTitle() == null || givenLoanDTO.getTitle().isEmpty()){

            throw new NoSuchElementException("Title should not be null or empty");

        }

        if (givenLoanDTO.getAmount() <= 0){

            throw new NoSuchElementException("Amount can not be zero or less");

        }

        if (givenLoanDTO.getDescription() == null || givenLoanDTO.getDescription().isEmpty()){

            throw new NoSuchElementException("Description can not be null or empty");

        }

        if (givenLoanDTO.getDueDate() == null){

            throw new NoSuchElementException("Due date can not be null");

        }

        if (givenLoanDTO.getType() == null || givenLoanDTO.getType().isEmpty()){

            throw new NoSuchElementException("Type can not be null or empty");

        }

    }

}
