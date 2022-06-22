package com.example.battleships.web;

import com.example.battleships.models.DTOs.CreateShipDTO;
import com.example.battleships.models.entities.Ship;
import com.example.battleships.services.ShipService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ShipController {

    private final ShipService shipService;
    @Autowired
    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @ModelAttribute("createShipDTO")
    public CreateShipDTO initCreateShipDTO() {
        return new CreateShipDTO();
    }

    @GetMapping("/ships/add")
    public String addShip() {
        return "ship-add";
    }

    @PostMapping("/ships/add")
    public String ships(@Valid CreateShipDTO createShipDTO, BindingResult bindingResult,
                        RedirectAttributes redAtrs) {

        if (bindingResult.hasErrors()) {
            redAtrs.addFlashAttribute("createShipDTO", createShipDTO);
            redAtrs.addFlashAttribute
                    ("com.springframework.validation.BindingResult.createShipDTO",
                            bindingResult);
            return "redirect:/ships/add";
        }
        this.shipService.addShip(createShipDTO);
        return "redirect:/home";
    }
}
