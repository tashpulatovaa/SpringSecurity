package peaksoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.User;
//import peaksoft.other.Countries;
import peaksoft.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    //define dependency
    private UserService userService;

    //inject dependency
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userList")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    //main page
    @GetMapping("/main")
    public String showMain(Model theModel) {
        return "main_page";
    }

    //save form page
    @GetMapping("/save_user")
    public String showSaveUserForm(Model theModel) {
        theModel.addAttribute("t", "A");
        theModel.addAttribute("user", new User());
        return "save_user";
    }

    //save user to db
    @PostMapping("/save")
    public String saveToDB(@ModelAttribute("user") User user) {
        userService.saveOrUpdate(user);
        return "redirect:/user/main";
    }

    //delete
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id , Model theModel) {

        //get from database
        userService.deleteById(id);

        return "redirect:/user/main";
    }

    //update
    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model theModel) {
        theModel.addAttribute("t", "U");
        theModel.addAttribute("user", userService.getById(id));
        return "save_user";
    }

//    @ModelAttribute("countries")
//    public String[] countries() {
//        return Countries.getCountries();
//    }

}
