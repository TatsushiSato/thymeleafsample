package com.example.thymeleafsample.controller;

import com.example.thymeleafsample.entity.Member;
import com.example.thymeleafsample.service.ArtistService;
import com.example.thymeleafsample.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    public String registerMember(@ModelAttribute Member member, @RequestParam("member_cover") MultipartFile cover) {

        return "member/member";
    }
}
