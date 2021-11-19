package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class PublisherController {

    private final PublisherRepository publisherRepository;

    @RequestMapping("/publishers")
    public String getPublishers(Model model){
        model.addAttribute("publishers",publisherRepository.findAll());
        return "publishers/list";
    }
}
