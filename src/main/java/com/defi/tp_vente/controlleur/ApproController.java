package com.defi.tp_vente.controlleur;

import com.defi.tp_vente.model.Approvisionnement;
import com.defi.tp_vente.service.ApproService;
import com.defi.tp_vente.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ApproController {
    @Autowired
    private ApproService approService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/appro/show")
    public String showAllAppro(Model model){
        model.addAttribute("listeAppro",approService.showAllAppro());
        //pas obligé d'avoir le mm nom que le return
        return "appro/listeAppro";
    }

    @GetMapping("/appro/form")
    public String ShowFormAppro(Model model){
        model.addAttribute("listeAppro",articleService.showAllArticles());
        return "appro/formAppro";
    }

    @PostMapping("/appro/save")
    public String saveAppro(Approvisionnement appro){
        appro.setQteAppro(appro.getQteAppro());
        appro.setDateAppro(LocalDate.now());
        approService.saveAppro(appro);
        articleService.updateStockArticle(appro.getQteAppro(),appro.getArticleId());
        return "redirect:/appro/show";
    }

    @GetMapping("/approedit{id}")
    public String approEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Un_approvisionnement",approService.showOneAppro(id));
        model.addAttribute("listeAppro",articleService.showAllArticles());
        return "appro/approEdit";
    }
    @PostMapping("appro/update")
    public  String updateAppro(@ModelAttribute("approvisionnement") Approvisionnement appro){
        approService.saveAppro(appro);
        return "redirect:/appro/show";
    }
    @GetMapping("/approdelete{id}")
    public String deleteAppro(@PathVariable("id") int id){
        approService.deleteAppro(id);
        return "redirect:/appro/show";
    }
}
