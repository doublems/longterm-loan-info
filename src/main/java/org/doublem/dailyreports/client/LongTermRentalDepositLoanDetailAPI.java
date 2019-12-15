package org.doublem.dailyreports.client;

import org.doublem.dailyreports.vo.loan.detail.LongTermRentalDepositDetailLoan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 금융감독원 Open API
 */

//todo paging 수정
@FeignClient(name = "loanDetail", url = "http://finlife.fss.or.kr")
public interface LongTermRentalDepositLoanDetailAPI {

    @RequestMapping(method = RequestMethod.GET,
            path = "/finlifeapi/rentHouseLoanProductsSearch.json?auth={apiKey}&topFinGrpNo=050000&pageNo=1"
    )
    public LongTermRentalDepositDetailLoan getCurrentInfo(@PathVariable("apiKey") String apiKey);
}