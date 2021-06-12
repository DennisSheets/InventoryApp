package InventoryApp.InventoryApp.controllers;

import InventoryApp.InventoryApp.data.BrandRepository;
import InventoryApp.InventoryApp.data.CategoryRepository;
import InventoryApp.InventoryApp.models.Brand;
import InventoryApp.InventoryApp.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("brands")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping ("")
    public String listBrands (Model model) {
        model.addAttribute("title","Brand List");
        List<Brand> listBrands = brandRepository.findAll();
        model.addAttribute("listBrands", listBrands);
        return "/brands/index";
    }

    @GetMapping ("new")
    public String displayCreateNewBrand (Model model) {
        model.addAttribute("title","Add New Brand");
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("listCategories",listCategories);
        model.addAttribute("brand",new Brand());
        return "/brands/new";
    }

    @PostMapping("save")
    public String saveBrand(Model model, Brand brand){
        brandRepository.save(brand);
        return "redirect:";
    }


    @GetMapping ("edit/{id}")
    public String displayEditBrand(@PathVariable("id") Integer id, Model model) {
        List<Category> listCategories = categoryRepository.findAll();
        Brand brand = brandRepository.findById(id).get();

        model.addAttribute("title","Edit Brand");
        model.addAttribute("listCategories",listCategories);
        model.addAttribute("brand", brand);
        return "/brands/new";
    }


}
