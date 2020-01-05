package com.example.sandeep.transferservice.controller;


import com.example.sandeep.transferservice.model.TransferRequest;
import com.example.sandeep.transferservice.model.TransferResponse;
import com.example.sandeep.transferservice.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

    @Autowired
    private TransferService service;

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ResponseEntity<TransferResponse> makeTransfer(@RequestBody TransferRequest transferRequest){
        TransferResponse response= service.doTransfer(transferRequest);

        return new ResponseEntity<TransferResponse>(response,HttpStatus.OK);
    }

}
