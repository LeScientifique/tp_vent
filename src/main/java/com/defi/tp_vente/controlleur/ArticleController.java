package com.defi.tp_vente.controlleur;

import com.defi.tp_vente.model.Article;
import com.defi.tp_vente.service.ArticleService;
import com.defi.tp_vente.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ArticleController {
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ArticleService articleService;
    @GetMapping("/article/show")
    public String showAllArticle(Model model){
        model.addAttribute("listeArticle",articleService.showAllArticles());
        return "article/listeArticle";
    }
    @GetMapping("/article/form")
    public String ShowFormArticle(Model model){
        model.addAttribute("listeCategorie",categorieService.showAllCategories());
        return "article/formArticle";
    }
    @PostMapping("/article/save")
    public String saveArticle(Article article){
        article.setQteStock(0);
        article.setDateCreation(LocalDate.now());
        articleService.saveArticles(article);
        return "redirect:/article/show";
    }
    @GetMapping("/articleedit{id}")
    public String formEdit (@PathVariable("id") int id, Model model){
        model.addAttribute("Un_article", articleService.showOneArticle(id));
        model.addAttribute("ListeCategories", categorieService.showAllCategories());
        return "article/formEditArticle";
    }
    @PostMapping("/article/update")
    public String updateArticle(@ModelAttribute("article") Article article){
        articleService.saveArticles(article);
        return "redirect:/article/show";
    }
    @GetMapping("/articledelete{id}")
    public String deleteArticle(@PathVariable("id") int id){
        articleService.deleteArticle(id);
        return "redirect:/article/show";
    }

    @GetMapping("article/etat")
    public String listeSeuil(Model model){
        model.addAttribute("listeSeuil",articleService.articleEtatCritique(articleService.showAllArticles()));
        return "article/listeSeuil";
    }
}