package com.example.battleships.web;

import com.example.battleships.models.DTOs.dataExport.BattleShipDTO;
import com.example.battleships.services.ShipService;
import com.example.battleships.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final LoggedUser loggedUser;

    @ModelAttribute("battleShipDTO")
    public BattleShipDTO initBattleBindingDTO() {
        return new BattleShipDTO();
    }

    @Autowired
    public HomeController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/home")
    public String loggedInHome(Model model) {
        if (this.loggedUser.getId() == 0) {
            return "redirect:/";
        }
        model.addAttribute("currentUserShips",
                this.shipService.getOwnShipsOrdered(this.loggedUser.getId()));
        model.addAttribute("otherUserShips", this.shipService.getOtherShipsOrdered(this.loggedUser.getId()));
        model.addAttribute("allShips", this.shipService.visualiseAll());
        return "home";
    }

    @GetMapping("/")
    public String loggedOutIndex() {
        return "index";
    }

    @PostMapping("/home/battle")
    public String combat(@Valid BattleShipDTO battleShipDTO, BindingResult bindingResult,
                         RedirectAttributes redAttrs) {
        if (bindingResult.hasErrors()) {
            redAttrs.addFlashAttribute("battleShipDTO", battleShipDTO);
            redAttrs.addFlashAttribute("org.springframework.validation.BindingResult.battleShipDTO", bindingResult);
            return "redirect:/home";
        }
        this.shipService.attack(battleShipDTO.getAttacker(), battleShipDTO.getDefender());
        return "redirect:/home";
    }
}
