package id.co.bri.dce.CRUD.controller;


import id.co.bri.dce.CRUD.entity.Selling;
import id.co.bri.dce.CRUD.entity.User;
import id.co.bri.dce.CRUD.repository.SellingDao;
import id.co.bri.dce.CRUD.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.awt.print.Pageable;
import java.util.List;

@Controller
public class CrudController {
    @Autowired
    private UserDao userDao;
    private SellingDao sellingDao;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        List<User> users = (List<User>) userDao.findByStatus("ACTIVE");
        mv.addObject("users", users);
        return mv;
    }

    @GetMapping("/home1")
    public ModelAndView homeWithJoinTable() {
        ModelAndView mv = new ModelAndView("home1");
//        List<Selling> selling = (List<Selling>) sellingDao.findByUserIdAndActive();
//        mv.addObject("selling", selling);
        return mv;
    }

//    @GetMapping("/home2")
//    public ModelAndView homeWithPagination() {
//        ModelAndView mv = new ModelAndView("home2");
//        List<User> users = userDao.findByStatus("ACTIVE", (Pageable) PageRequest.of(1, 20));
//        mv.addObject("users", users);
//        return mv;
//    }

    @GetMapping("/addUser")
    public String addUser(User user) {
        return "add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid User user) {
        user.setStatus("ACTIVE");
        userDao.save(user);
        return "redirect:/home";
    }

    @GetMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model) {
        User user = userDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid User user){
        userDao.save(user);
        return "redirect:/home";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") int id) {
        User user = userDao.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user.setStatus("DISABLED");
        userDao.save(user);
        return "redirect:/home";
    }

}
