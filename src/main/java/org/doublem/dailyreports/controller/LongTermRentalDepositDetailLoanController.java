package org.doublem.dailyreports.controller;

import org.doublem.dailyreports.client.LongTermRentalDepositLoanDetailAPI;
import org.doublem.dailyreports.service.LongTermRentalDepositDetailLoanService;
import org.doublem.dailyreports.vo.loan.detail.LongTermRentalDepositDetailLoan;
import org.doublem.dailyreports.vo.loan.detail.LtrProduct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LongTermRentalDepositDetailLoanController {

    private LongTermRentalDepositLoanDetailAPI longTermRentalDepositLoanDetailAPI;
    private LongTermRentalDepositDetailLoanService longTermRentalDepositDetailLoanService;

    @Value("${finlife.fss.or.kr.key}")
    private String apiKey;

    public LongTermRentalDepositDetailLoanController(
            LongTermRentalDepositLoanDetailAPI longTermRentalDepositLoanDetailAPI,
            LongTermRentalDepositDetailLoanService longTermRentalDepositDetailLoanService) {
        this.longTermRentalDepositLoanDetailAPI = longTermRentalDepositLoanDetailAPI;
        this.longTermRentalDepositDetailLoanService = longTermRentalDepositDetailLoanService;
    }

    @GetMapping("/loan-detail")
    public List<LtrProduct> test() {
        return longTermRentalDepositDetailLoanService.getLtrProductsBy(
                longTermRentalDepositLoanDetailAPI.getCurrentInfo(apiKey)
        );
    }
}