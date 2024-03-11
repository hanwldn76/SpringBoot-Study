package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/signup")
    public String signUpPage(){
        return "members/new";
    }

    @PostMapping("/join")
    public String join(MemberForm form){
        log.info(form.toString());
        //System.out.println(form.toString());
        // 1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        log.info(member.toString());
        //System.out.println(member.toString());
        // 2. 리파지토리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        //System.out.println(saved.toString());
        return "";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        log.info("id = "+id);
        // 1. id를 조회해 데이터 가져오기
        Member memberEntity = memberRepository.findById(id).orElse(null);
        // 2. 모델에 데이터 등록하기
        model.addAttribute("member", memberEntity);
        // 3. 뷰 페이지 반환하기
        return "/members/show";
    }

    @GetMapping("/members")
    public String index(Model model){
        // 1. id를 조회해 데이터 가져오기
        ArrayList<Member> memberListEntity = memberRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("memberList", memberListEntity);
        // 3. 뷰 페이지 반환하기
        return "/members/index";
    }
}
