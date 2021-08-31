package InventoryApp.InventoryApp.controllers;

import InventoryApp.InventoryApp.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @GetMapping ("")
    public String viewHomePage(Model model) {
        model.addAttribute("title", "Welcome to Inventory App");
            return "index";
    }

    @GetMapping ("/403")
    public String error403(){
        return "403";
    }

    @GetMapping ("/404")
    public String error404(){
        return "404";
    }

}
