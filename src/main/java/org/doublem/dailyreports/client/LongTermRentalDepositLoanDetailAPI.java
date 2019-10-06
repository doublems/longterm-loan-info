package org.doublem.dailyreports.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 금융감독원 Open API
 */

//todo paging 수정
@FeignClient(name = "loanDetail", url = "http://finlife.fss.or.kr/finlifeapi/rentHouseLoanProductsSearch.xml?" +
        "auth=${finlife.fss.or.kr.key}&topFinGrpNo=050000&pageNo=1")
public interface LongTermRentalDepositLoanDetailAPI {

    @RequestMapping(method = RequestMethod.GET)
    public String getCurrentInfo();
}