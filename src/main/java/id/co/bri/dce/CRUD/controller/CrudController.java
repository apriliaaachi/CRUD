package id.co.bri.dce.CRUD.controller;

import id.co.bri.dce.CRUD.entity.Publisher;
import id.co.bri.dce.CRUD.repository.PublisherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CrudController {
    @Autowired
    private PublisherDao publisherDao;

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");
        List<Publisher> publishers = (List<Publisher>) publisherDao.findByStatus("ACTIVE");
        mv.addObject("publishers", publishers);
        return mv;
    }

    @GetMapping("/home1")
    public ModelAndView homeWithJoinTable() {
        ModelAndView mv = new ModelAndView("home1");
//        List<Publisher> publishers = (List<Publisher>) publisherDao.findAllByBookName();
//        mv.addObject("publsihers", publishers);
        return mv;
    }

    @GetMapping("/home2")
    public ModelAndView homeWithPagination() {
        ModelAndView mv = new ModelAndView("home2");
        Pageable paging = PageRequest.of(0, 5, Sort.by("name"));
        Page<Publisher> publishers = publisherDao.findByStatus("ACTIVE", paging);
        mv.addObject("page", publishers);
        mv.addObject("publishers", publishers.getContent());
        return mv;
    }

    @GetMapping("/add")
    public String add(Publisher publisher) {
        return "add-form";
    }

    @PostMapping("/save")
    public String save(@Valid Publisher publisher) {
        publisher.setStatus("ACTIVE");
        publisherDao.save(publisher);
        return "redirect:/home";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        Publisher publisher = publisherDao.findById(id);

        model.addAttribute("publisher", publisher);
        return "update-form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Publisher publisher){
        publisher.setStatus("ACTIVE");
        publisherDao.save(publisher);
        return "redirect:/home";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
        Publisher publisher = publisherDao.findById(id);
        publisher.setStatus("DISABLED");
        publisherDao.save(publisher);
        return "redirect:/home";
    }

}
