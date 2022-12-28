package com.cg.controller;

import com.cg.util.AppUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private AppUtils appUtils;

    @GetMapping
    public String showListPage(Model model) {
        String username = appUtils.getPrincipalUsername();

        if (Objects.equals(username, "anonymousUser")) {
            return "login";
        }

        model.addAttribute("username", username);
        return "product/home";
    }

    @GetMapping("/list")
    public String showListProduct(Model model) {
        String username = appUtils.getPrincipalUsername();

        if (Objects.equals(username, "anonymousUser")) {
            return "login";
        }

        model.addAttribute("username", username);
        return "product/list";
    }

    @GetMapping("/shop")
    public String showShopProduct(Model model) {
        String username = appUtils.getPrincipalUsername();

        if (Objects.equals(username, "anonymousUser")) {
            return "login";
        }

        model.addAttribute("username", username);
        return "product/shop";
    }



}
