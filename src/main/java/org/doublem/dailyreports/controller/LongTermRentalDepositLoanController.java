package org.doublem.dailyreports.controller;

import org.doublem.dailyreports.client.LongTermRentalDepositLoanAPI;
import org.doublem.dailyreports.service.LongTermRentalDepositLoanService;
import org.doublem.dailyreports.vo.loan.LongTermRentalDepositLoanVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LongTermRentalDepositLoanController {

    private LongTermRentalDepositLoanAPI longTermRentalDepositLoanAPI;
    private LongTermRentalDepositLoanService longTermRentalDepositLoanService;

    @Value("${api.hf.go.kr.key}")
    private String apiKey;

    public LongTermRentalDepositLoanController(LongTermRentalDepositLoanAPI longTermRentalDepositLoanAPI,
                                               LongTermRentalDepositLoanService longTermRentalDepositLoanService) {
        this.longTermRentalDepositLoanAPI = longTermRentalDepositLoanAPI;
        this.longTermRentalDepositLoanService = longTermRentalDepositLoanService;
    }

    @GetMapping("/loan")
    public LongTermRentalDepositLoanVO test() {
        return longTermRentalDepositLoanService.getCurrentInfo(longTermRentalDepositLoanAPI.getCurrentInfo(apiKey));
    }
}