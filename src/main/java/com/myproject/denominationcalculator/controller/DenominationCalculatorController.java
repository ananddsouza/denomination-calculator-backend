package com.myproject.denominationcalculator.controller;

import com.myproject.denominationcalculator.exception.CustomException;
import com.myproject.denominationcalculator.model.CalculationResult;
import com.myproject.denominationcalculator.model.ComputeData;
import com.myproject.denominationcalculator.service.DenominationCalculatorService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@Validated
@RequestMapping("/api")
public class DenominationCalculatorController {

    @Autowired
    DenominationCalculatorService denominationCalculatorService;

    @PostMapping("/denominations")
    public ResponseEntity<CalculationResult> calculateDenominations(@Valid @RequestBody ComputeData computeData) {

        final Logger logger = LoggerFactory.getLogger(DenominationCalculatorController.class);

        try {
            logger.info("Received input ------>" + computeData);

            // Call the service method
            CalculationResult result = denominationCalculatorService.calculateDenominations(computeData);

            logger.info("Returning result ------>" + result);

            return ResponseEntity.ok(result);
        } catch (CustomException e) {
            logger.error("An error occurred" + e);
            throw e;
        }
    }
}
