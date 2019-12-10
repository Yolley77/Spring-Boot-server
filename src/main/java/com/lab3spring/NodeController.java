package com.lab3spring;

import com.lab3spring.Action.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
// Это MVC контроллер, из него юзер управляет моделью
@Controller
public class NodeController {
    private NodeService service;

    @Autowired
    public void setNoteService(NodeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list() {
        return "firstPage";
    }

    @GetMapping("/firstPage.html")
    public String firstPage() {
        return "firstPage";
    }

    @GetMapping("/secondPage.html")
    public String secondPage() {
        return "secondPage";
    }

    @GetMapping("/thirdPage.html")
    public String thirdPage(Model model) {
        List<Node> nodes = service.findAll();
        model.addAttribute("nodes", nodes);
        return "thirdPage";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        service.deleteNode(id);
        return "redirect:/thirdPage.html";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Node node = service.getNode(id);
        model.addAttribute("node", node);
        return "edit";
    }

    @PostMapping("/update")
    public String updateNode(@RequestParam Integer id, @RequestParam String name,
                             @RequestParam String country, @RequestParam boolean status) {
        service.updateNode(id, name, country, status);
        return "redirect:/thirdPage.html";
    }

    @GetMapping("/new")
    public String add() {
        return "new";
    }

    @PostMapping("/save")
    public String addNote(@RequestParam String name,
                          @RequestParam String country, @RequestParam boolean status) {
        service.addNode(new Node(name, country, status));
        return "redirect:/thirdPage.html";
    }

    @PostMapping("/calculate")
    public String calculate(Model model, @RequestParam String request) {
        service.setAction(new Action());
        String result = service.getResult(request);
        model.addAttribute("result", result);
        return "secondPage.html";
    }

    public void clearAll() {
        service.clearAll();
    }
}
