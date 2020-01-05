package com.example.sandeep.limitservice.controller;

import com.example.sandeep.limitservice.model.LimitModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

    @RequestMapping(value = "/findLimit", method = RequestMethod.GET)
    public ResponseEntity<LimitModel> getLimit(){

        return new ResponseEntity<LimitModel>(new LimitModel(5000,1000,2000), HttpStatus.OK);
    }
}
