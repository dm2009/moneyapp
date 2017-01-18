package org.moneyproj.validator;

import java.math.BigDecimal;

import org.moneyproj.entities.Coin;
import org.moneyproj.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CoinValidator implements Validator {
    @Autowired
    private CoinService coinService;

    public final int SIZE_CODE = 3;

    @Override
    public boolean supports(Class<?> Clazz) {
        return Coin.class.isAssignableFrom(Clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Coin coin = (Coin) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numCode", "validate.numCode.Empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "baseNumCode", "validate.baseNumCode.Empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "validate.date.Empty");

        if (coin.getNumCode().toString().length() > SIZE_CODE) {
            errors.rejectValue("numCode", "validate.numCode.Digits");
        }

        if (coin.getBaseNumCode().toString().length() > SIZE_CODE) {
            errors.rejectValue("baseNumCode", "validate.numCode.Digits");
        }
        if (coin.getScale() < 0) {
            errors.rejectValue("scale", "validate.Min");
        }
        if (coin.getRate().compareTo(BigDecimal.ZERO) < 1) {
            errors.rejectValue("rate", "validate.Min");
        }

        if (coinService.isDoubleExist(coin) == true) {
            errors.rejectValue("date", "validate.Duplicate");
        }

    }

}
