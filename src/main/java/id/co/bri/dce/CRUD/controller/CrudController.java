package id.co.bri.dce.CRUD.controller;


import id.co.bri.dce.CRUD.entity.User;
import id.co.bri.dce.CRUD.repository.DataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CrudController {
    @Autowired
    private DataDao dataDao;

    @GetMapping("/home")
    public ModelAndView home(User user) {
        ModelAndView mv = new ModelAndView("home");

        List<User> users = (List<User>) dataDao.findAll();
        mv.addObject("users", users);
        return mv;
    }

    @GetMapping("/addUser")
    public String showSignUpForm(User user) {
        return "add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid User user) {
        user.setStatus("ACTIVE");
        dataDao.save(user);
        return "redirect:/home";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        User user = dataDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid User user){
        dataDao.save(user);
        return "redirect:/home";
    }

    @RequestMapping(value = "/del-user", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id) {
        User user = dataDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user.setStatus("DISABLED");
        return "redirect:/home";

    }

}
