package com.example.thymeleafsample.controller;

import com.example.thymeleafsample.entity.Member;
import com.example.thymeleafsample.service.ArtistService;
import com.example.thymeleafsample.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MemberController {

    private final MemberService memberService;

    private final ArtistService artistService;

    @Autowired
    public MemberController(MemberService memberService, ArtistService artistService) {
        this.memberService = memberService;
        this.artistService = artistService;
    }

    @GetMapping("/members")
    public String findAll(Model model){
        var members = memberService.findAll();
        model.addAttribute("members", members);
        return "member/members";
    }

    @GetMapping("/members/register")
    public String displayRegister(Model model){
        model.addAttribute("member", new Member());
        var artists = artistService.findAll();
        model.addAttribute("artists", artists);
        return "/member/register";
    }

    @PostMapping("/members")
    public String registerMember(@ModelAttribute @Validated Member member, BindingResult result, @RequestParam("member_cover") MultipartFile cover) {
        if(result.hasErrors()){
            return "/member/register";
        }

        memberService.registerMember(member);
        return "redirect:/members";
    }
}
