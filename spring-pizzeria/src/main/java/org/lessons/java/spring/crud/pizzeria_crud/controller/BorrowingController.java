package org.lessons.java.spring.crud.pizzeria_crud.controller;

import org.lessons.java.spring.crud.pizzeria_crud.model.Borrowing;
import org.lessons.java.spring.crud.pizzeria_crud.repository.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/borrowings")
public class BorrowingController {
    
    @Autowired
    private BorrowingRepository borrowingRepository;

    @PostMapping
    public String store(@Valid @ModelAttribute("borrowing") Borrowing borrowingForm, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("borrowing", borrowingForm);
            return "borrowings/create";
        }

        //Se non ho errori creo il prestito
        borrowingRepository.save(borrowingForm);

        return "redirect:/pizze";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        borrowingRepository.deleteById(id);
        return "redirect:/pizze";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("borrowing", borrowingRepository.findById(id).get());
        return "borrowings/edit";
    }

    @PostMapping("/{id}")
    public String update (@PathVariable Integer id, @Valid @ModelAttribute("borrowing") Borrowing borrowingForm, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()){
            model.addAttribute("borrowing", borrowingForm);
            return "borrowings/edit";
        }

        borrowingRepository.save(borrowingForm);

        return "redirect:/pizze";
    }

    
}