package InventoryApp.InventoryApp.controllers;

import InventoryApp.InventoryApp.data.CategoryRepository;
import InventoryApp.InventoryApp.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping ("categories")
public class CategoryController {

    @Autowired
    private CategoryRepository repo;

    @GetMapping ("")
    public String listCategories (Model model) {
        model.addAttribute("title","Category List");
        List<Category> listCategories = repo.findAll();
        model.addAttribute("listCategories", listCategories);
        return "/categories/index";
    }

    @GetMapping ("new")
    public String displayNewCategoryForm (Model model) {
        model.addAttribute("title","Add New Category");
        model.addAttribute("category", new Category());
        return "/categories/new";
    }

    @PostMapping("save")
    public String saveCategory (Category category){
        repo.save(category);
        return "redirect:";
    }


}
