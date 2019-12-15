package org.doublem.dailyreports.vo.loan.detail;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 전세자금대출 상세 항목
 */
@Getter
@Setter
@Builder
public class LtrProduct {
    private String fin_co_no;
    private String fin_prdt_cd;
    private BaseList baseList;
    private OptionList optionList;
}
