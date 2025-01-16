package com.octaviookumu.springdemo.mvc.controller;

import com.octaviookumu.springdemo.mvc.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @InitBinder // pre-process all web requests coming into our Controller
    public void initBinder(WebDataBinder dataBinder) {
        // StringTrimmerEditor removes whitespace, leading and trailing
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    // Model allows us to share information between controllers and view pages (Thymeleaf)
    @GetMapping("/")
    public String showForm(Model theModel) {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    // Valid tells Spring MVC to perform validation
    // - since we're using data binding we need to give reference to the model
    // the results of that validation will be placed in the BindingResult (the result of the validation)
    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResult
    ) {
        System.out.println("Last name: |" + theCustomer.getLastName() + "|");
        if (theBindingResult.hasErrors()) {
            return "customer-form";
        }
        return "customer-confirmation";
    }

}
