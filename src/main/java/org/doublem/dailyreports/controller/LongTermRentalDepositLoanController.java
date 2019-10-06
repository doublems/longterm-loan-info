package org.doublem.dailyreports.controller;

import org.doublem.dailyreports.client.LongTermRentalDepositLoanAPI;
import org.doublem.dailyreports.service.LongTermRentalDepositLoanService;
import org.doublem.dailyreports.vo.LongTermRentalDepositLoanVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LongTermRentalDepositLoanController {

    private LongTermRentalDepositLoanAPI longTermRentalDepositLoanAPI;
    private LongTermRentalDepositLoanService longTermRentalDepositLoanService;

    public LongTermRentalDepositLoanController(LongTermRentalDepositLoanAPI longTermRentalDepositLoanAPI,
                                               LongTermRentalDepositLoanService longTermRentalDepositLoanService)
    {
        this.longTermRentalDepositLoanAPI = longTermRentalDepositLoanAPI;
        this.longTermRentalDepositLoanService = longTermRentalDepositLoanService;
    }

    @GetMapping("/loan")
    public LongTermRentalDepositLoanVO test() {
        return longTermRentalDepositLoanService.getCurrentInfo(longTermRentalDepositLoanAPI.getCurrentInfo());
    }
}