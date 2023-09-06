package com.moneydiary.moneydiary.Controller;

import com.moneydiary.moneydiary.DTO.GivenLoanDTO;
import com.moneydiary.moneydiary.Service.GivenLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GivenLoanController {

    private final GivenLoanService givenLoanService;

    @PostMapping("/api/v1/givenloan")
    private ResponseEntity<GivenLoanDTO> giveLoan(@RequestBody GivenLoanDTO givenLoanDTO){

        return new ResponseEntity<>(givenLoanService.giveLoan(givenLoanDTO), HttpStatus.CREATED);

    }

    @PutMapping("/api/v1/givenloan/{id}")
    private ResponseEntity<GivenLoanDTO> updateGivenLoan(@PathVariable long id, @RequestBody GivenLoanDTO givenLoanDTO){

        return new ResponseEntity<>(givenLoanService.updateLoan(id, givenLoanDTO), HttpStatus.OK);

    }

    @DeleteMapping("/api/v1/givenloan/{id}")
    private String deleteGivenLone(@PathVariable long id){

        return givenLoanService.deleteGivenLoan(id);

    }

    @GetMapping("/api/v1/givenloan")
    private ResponseEntity<List<GivenLoanDTO>> getAllGivenLones(){

        return new ResponseEntity<>(givenLoanService.getAllGivenLoans(), HttpStatus.OK);

    }

}
