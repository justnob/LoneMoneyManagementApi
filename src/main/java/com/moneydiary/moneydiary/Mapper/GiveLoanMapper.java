package com.moneydiary.moneydiary.Mapper;

import com.moneydiary.moneydiary.DTO.GivenLoanDTO;
import com.moneydiary.moneydiary.Entity.GivenLoan;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GiveLoanMapper {

    private final ModelMapper mapper;

    public GivenLoanDTO mapToDTO(GivenLoan givenLoan){

        return mapper.map(givenLoan, GivenLoanDTO.class);

    }

    public GivenLoan mapToEntity(GivenLoanDTO givenLoanDTO){

        return mapper.map(givenLoanDTO, GivenLoan.class);

    }

}
