package hr.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class MainController {

    @InitBinder
    void initBinder(WebDataBinder binder) {

        //   binder.registerCustomEditor(LocalDateTime.class,
        //         new CustomDateEditor(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"), true));
    }


    @GetMapping("")
    public String index(Model model) {
        log.debug("dala 2323 ee");
        return "index";
    }

    @GetMapping("/form-date")
    public String formDate(@ModelAttribute("form") FormDateVM formDate) {
        formDate.setDate1(LocalDateTime.now());
        return "form-date";
    }


    @PostMapping("/form-date")
    public String formDateSave(@Valid @ModelAttribute("form") FormDateVM formDate, BindingResult result,
                               RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "form-date";
        }
        log.debug("Save form {}", formDate);
        attr.addFlashAttribute("msg", "sve ok sa formom  " + formDate);
        return "redirect:";
    }

}
