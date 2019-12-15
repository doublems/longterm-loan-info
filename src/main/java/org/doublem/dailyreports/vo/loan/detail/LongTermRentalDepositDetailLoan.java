package org.doublem.dailyreports.vo.loan.detail;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Data
public class LongTermRentalDepositDetailLoan {
    private Result result;

    public List<BaseList> getBaseList() {
        return Optional.ofNullable(result.getBaseList()).map(Arrays::asList).orElseGet(ArrayList::new);
    }

    public List<OptionList> getOptionList() {
        return Optional.ofNullable(result.getOptionList()).map(Arrays::asList).orElseGet(ArrayList::new);
    }
}