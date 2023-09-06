package com.moneydiary.moneydiary.Validations;

import com.moneydiary.moneydiary.DTO.GivenLoanDTO;
import com.moneydiary.moneydiary.Entity.GivenLoan;
import com.moneydiary.moneydiary.Repository.GivenLoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GivenLoanUpdateRequestValidation {

    private final GivenLoanRepository givenLoanRepository;

    public void validate(long id, GivenLoanDTO givenLoanDTO){

        Optional<GivenLoan> givenloanById = givenLoanRepository.findById(id);

        if (givenloanById.isEmpty()){

            throw new NoSuchElementException("loan can not be found");

        }

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
