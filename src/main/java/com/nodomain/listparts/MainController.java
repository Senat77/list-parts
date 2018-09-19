package com.nodomain.listparts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Controller
public class MainController {

    private final PartRepository partRepository;

    private static final int RECORDS_BY_PAGE = 10;
    private static final String SORT = "name";

    @Autowired

    public MainController(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @GetMapping("/")
    public String parts (
            @RequestParam(value = "q", required = false) String query,
            @RequestParam(value = "necessary", required = false) Boolean necessary,
            Model model,
            @PageableDefault(size = RECORDS_BY_PAGE, sort = SORT, direction = ASC) Pageable pageable
    ) {
        Page<Part> parts = partRepository.findByName((query != null) ? query : "", necessary, pageable);
        model.addAttribute("parts", parts);
        model.addAttribute("query", query);
        model.addAttribute("necessary", necessary);
        model.addAttribute("pccount", computersAmount());

        model.addAttribute("totalPages", parts.getTotalPages());
        model.addAttribute("current", pageable.getPageNumber());
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());

        return "parts";
    }

    @GetMapping("/part/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("part", partRepository.getOne(id));
        return "edit";
    }

    @PostMapping("/part")
    public String save(@ModelAttribute Part part) {
        partRepository.save(part);
        try {
            return "redirect:/?q=" + URLEncoder.encode(part.getName(), "UTF8");
        } catch (UnsupportedEncodingException ignore) {
            return "redirect:/";
        }
    }

    @GetMapping("/part/delete/{id}")
    public String delete(@PathVariable Long id) {
        partRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/part")
    public String create(Model model) {
        Part part = new Part();
        model.addAttribute("part", part);
        return "edit";
    }

    private Long computersAmount() {
        Part p = partRepository.findFirstByNecessaryIsTrueOrderByAmount();
        return p == null ? 0L : p.getAmount();
    }
}
