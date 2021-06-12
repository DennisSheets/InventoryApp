package InventoryApp.InventoryApp.controllers;
import InventoryApp.InventoryApp.data.CategoryRepository;
import InventoryApp.InventoryApp.data.ProductRepository;
import InventoryApp.InventoryApp.models.Category;
import InventoryApp.InventoryApp.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping ("products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping ("")
    public String listCategories (Model model) {
        List<Product> listProducts = productRepository.findAll();

        model.addAttribute("title","Product List");
        model.addAttribute("listProducts", listProducts);
        return "/products/index";
    }

    @GetMapping ("new")
    public String displayCreateNewProduct (Model model) {
        List<Category> listCategories = categoryRepository.findAll();

        model.addAttribute("title","Add New Product");
        model.addAttribute("listCategories",listCategories);
        model.addAttribute("product",new Product());
        return "/products/new";
    }

    @PostMapping ("save")
    public String saveProduct(Product product, HttpServletRequest request){
        String[] detailIDs = request.getParameterValues("detailID");
        String[] detailNames = request.getParameterValues("detailName");
        String[] detailValues = request.getParameterValues("detailValue");

        for (int i =0; i< detailNames.length; i++) {
            if (detailIDs != null && detailIDs.length > 0) {
                product.setDetail(Integer.valueOf(detailIDs[i]), detailNames[i], detailValues[i]);
            } else {
                product.addDetail(detailNames[i], detailValues[i]);
            }
        }

        productRepository.save(product);
        return "redirect:";
    }

    @GetMapping ("edit/{id}")
    public String displayEditProduct(@PathVariable("id") Integer id, Model model) {
        List<Category> listCategories = categoryRepository.findAll();
        Product product = productRepository.findById(id).get();

        model.addAttribute("listCategories",listCategories);
        model.addAttribute("title","Edit Product");
        model.addAttribute("product", product);
        return "/products/new";
    }

    @GetMapping ("delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productRepository.deleteById(id);
        return "redirect:/products ";
    }


}
