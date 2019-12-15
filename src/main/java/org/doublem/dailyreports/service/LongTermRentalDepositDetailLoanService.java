package org.doublem.dailyreports.service;

import org.doublem.dailyreports.vo.loan.detail.BaseList;
import org.doublem.dailyreports.vo.loan.detail.LongTermRentalDepositDetailLoan;
import org.doublem.dailyreports.vo.loan.detail.LtrProduct;
import org.doublem.dailyreports.vo.loan.detail.OptionList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LongTermRentalDepositDetailLoanService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<LtrProduct> getLtrProductsBy(LongTermRentalDepositDetailLoan detailLoan) {

        List<BaseList> baseList = detailLoan.getBaseList();

        List<LtrProduct> ltrProducts =
                baseList.stream().map(bl -> LtrProduct.builder()
                        .fin_co_no(bl.getFin_co_no())
                        .fin_prdt_cd(bl.getFin_prdt_cd())
                        .baseList(bl)
                        .build()).collect(Collectors.toList());

        List<OptionList> optionList = detailLoan.getOptionList();

        optionList.forEach(ol ->
                ltrProducts.stream()
                        .filter(ltrProduct ->
                                ltrProduct.getFin_prdt_cd().equals(ol.getFin_prdt_cd())
                                        && ltrProduct.getFin_co_no().equals(ol.getFin_co_no()))
                        .forEach(ltrProduct -> ltrProduct.setOptionList(ol)));

        return ltrProducts;
    }


}