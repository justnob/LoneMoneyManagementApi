package com.moneydiary.moneydiary.Service.Implementation;

import com.moneydiary.moneydiary.DTO.GivenLoanDTO;
import com.moneydiary.moneydiary.Entity.GivenLoan;
import com.moneydiary.moneydiary.Mapper.GiveLoanMapper;
import com.moneydiary.moneydiary.Repository.GivenLoanRepository;
import com.moneydiary.moneydiary.Service.GivenLoanService;
import com.moneydiary.moneydiary.Validations.GivenLoanCreationRequestValidation;
import com.moneydiary.moneydiary.Validations.GivenLoanUpdateRequestValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GivenLoanServiceImpl implements GivenLoanService {

    private final GiveLoanMapper giveLoanMapper;
    private final GivenLoanRepository givenLoanRepository;
    private final GivenLoanCreationRequestValidation givenLoanCreationRequestValidation;
    private final GivenLoanUpdateRequestValidation givenloanUpdateRequestValidation;

    @Override
    public GivenLoanDTO giveLoan(GivenLoanDTO givenLoanDTO) {

        givenLoanCreationRequestValidation.validate(givenLoanDTO);

        GivenLoan givenLoanEntity = giveLoanMapper.mapToEntity(givenLoanDTO);
        givenLoanEntity.setGivenDate(LocalDate.now());

        GivenLoan saved = givenLoanRepository.save(givenLoanEntity);


        return giveLoanMapper.mapToDTO(saved);
    }

    @Override
    public GivenLoanDTO updateLoan(long id, GivenLoanDTO givenLoanDTO) {

        givenloanUpdateRequestValidation.validate(id, givenLoanDTO);

        GivenLoan givenloanById = givenLoanRepository.findById(id).get();

        givenloanById.setTitle(givenLoanDTO.getTitle());
        givenloanById.setType(givenLoanDTO.getType());
        givenloanById.setAmount(givenLoanDTO.getAmount());
        givenloanById.setDescription(givenLoanDTO.getDescription());
        givenloanById.setDueDate(givenLoanDTO.getDueDate());
        givenloanById.setGivenDate(givenLoanDTO.getGivenDate());

        GivenLoan saved = givenLoanRepository.save(givenloanById);

        return giveLoanMapper.mapToDTO(saved);
    }

    @Override
    public String deleteGivenLoan(long id) {

        Optional<GivenLoan> givenloanById = givenLoanRepository.findById(id);

        if (givenloanById.isEmpty()){

            throw new NoSuchElementException("Loan can not be found");

        }

        givenLoanRepository.deleteById(id);

        return String.format("The given loan detail has been deleted with id: " + id);
    }

    @Override
    public List<GivenLoanDTO> getAllGivenLoans() {

        List<GivenLoan> allGIvenloans = givenLoanRepository.findAll();

        if (allGIvenloans.isEmpty()){

            throw new NoSuchElementException("Loans can not be found");

        }

        return allGIvenloans.stream().map(loan -> giveLoanMapper.mapToDTO(loan)).collect(Collectors.toList());
    }
}
