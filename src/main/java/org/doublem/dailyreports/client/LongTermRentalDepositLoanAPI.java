package org.doublem.dailyreports.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 안전행정부 Open API
 */
@FeignClient(name = "loan", url = "http://api.hf.go.kr:8090/service/rest/rentloanrat/getRentLoanRat?" +
        "serviceKey=${api.hf.go.kr.key}")
public interface LongTermRentalDepositLoanAPI {

    @RequestMapping(method = RequestMethod.GET)
    public String getCurrentInfo();
}