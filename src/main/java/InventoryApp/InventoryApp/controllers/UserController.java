package InventoryApp.InventoryApp.controllers;

import InventoryApp.InventoryApp.data.RoleRepository;
import InventoryApp.InventoryApp.data.UserRepository;
import InventoryApp.InventoryApp.models.Role;
import InventoryApp.InventoryApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("")
    public String listUsers (Model model) {
        List<User> listUsers = userRepository.findAll();

        model.addAttribute("title","User List");
        model.addAttribute("listUsers", listUsers);
        return "/users/index";
    }

    @GetMapping ("new")
    public String displayCreateNewUser (Model model) {
        List<Role> listRoles = roleRepository.findAll();

        model.addAttribute("title","Add User");
        model.addAttribute("user",new User());
        model.addAttribute("listRoles", listRoles);
        return "/users/new";
    }

    @PostMapping("save")
    public String saveUser(Model model, User user){
        String password = user.getPwHash();
        String hash = encoder.encode(password);
        user.setPwHash(hash);
        userRepository.save(user);
        return "redirect:";
    }

    @GetMapping ("edit/{id}")
    public String displayEditUser(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).get();
        List<Role> listRoles = roleRepository.findAll();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("title","Edit User");
        model.addAttribute("user", user);
        return "/users/new";
    }

    @GetMapping ("delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
        return "redirect:/users ";
    }


}
