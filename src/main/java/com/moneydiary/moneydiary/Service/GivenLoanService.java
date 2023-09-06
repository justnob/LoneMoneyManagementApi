package com.moneydiary.moneydiary.Service;

import com.moneydiary.moneydiary.DTO.GivenLoanDTO;

import java.util.List;

public interface GivenLoanService {

    GivenLoanDTO giveLoan(GivenLoanDTO givenLoanDTO);

    GivenLoanDTO updateLoan(long id, GivenLoanDTO givenLoanDTO);

    String deleteGivenLoan(long id);

    List<GivenLoanDTO> getAllGivenLoans();

}
