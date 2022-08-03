package marvelapi.services;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/")
    public String indexPage(Model model){
        Integer id = 1010699;
        model.addAttribute("character_id", id);
        return "index";
    }
}
