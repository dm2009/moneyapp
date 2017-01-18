package org.moneyproj.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.moneyproj.entities.Coin;
import org.moneyproj.service.CoinService;
import org.moneyproj.validator.CoinValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CoinsController {

    @Autowired
    private CoinService coinService;

    @Autowired
    private MessageSource message;

    @Autowired
    private CoinValidator coinValidator;

    /**
     * Logger for this class.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "coin/list", method = RequestMethod.GET)
    public String showCoinList(Model model,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOrNull) {

        if (dateOrNull == null) {
            dateOrNull = new Date();
        }

        model.addAttribute("date", dateOrNull);

        List<Coin> coins = coinService.getCoins(dateOrNull);
        model.addAttribute("coins", coins);

        return "coin/list";
    }

    @RequestMapping(value = "coin/list", method = RequestMethod.POST)
    public String deleteCoinList(Model model,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateOrNull,
            Integer[] coinIds, RedirectAttributes redirectAttributes) {

        if (coinIds != null) {
            for (Integer ids : coinIds) {
                if (ids != null) {
                    coinService.delete(ids.intValue());
                }
            }
        }

        if (dateOrNull != null) {
            redirectAttributes.addAttribute("date", dateOrNull);
        }

        return "redirect:/coin/list";

    }

    @RequestMapping(value = "coin/edit", method = RequestMethod.GET)
    public String showCoinForm(Model model, @RequestParam(value = "id", required = false) Integer idOrNull) {
        Coin coin = null;
        if (idOrNull == null) {
            coin = new Coin();
            coin.setDate(new Date());
        } else {
            coin = coinService.read(idOrNull);
        }

        model.addAttribute("coin", coin);
        //model.addAttribute("coinTypes", coinService.getCoinTypesSelector());

        return "coin/edit";
    }

    @RequestMapping(value = "coin/edit", method = RequestMethod.POST)
    public String saveCoinForms(@ModelAttribute("coin") @Valid Coin coin, BindingResult result, ModelMap model,
            RedirectAttributes redirectAttributes) {

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                message.getMessage("common.date.format", null, Locale.getDefault()), Locale.getDefault());

        if (result.hasErrors()) {
            logger.info("saveCoinForms {} {}", result.getErrorCount(), result.getAllErrors());
            //model.addAttribute("coinTypes", coinService.getCoinTypesSelector());
            return "coin/edit";
        }

        // Save data
        coin.setStrCode(coinService.getStrCode(coin.getNumCode()));
        coinService.save(coin);

        redirectAttributes.addAttribute("date", dateFormat.format(coin.getDate()));

        return "redirect:/coin/list";
    }

    @ModelAttribute("coinTypes")
    public Map<Integer, String> populateMap() {
        return coinService.getCoinTypesSelector();
    }
    
    @InitBinder(value = "coin")
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                message.getMessage("common.date.format", null, Locale.getDefault()), Locale.getDefault());
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.addValidators(coinValidator);
    }
}
