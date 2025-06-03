package com.example.thymeleafsample.service;

import com.example.thymeleafsample.entity.Member;
import com.example.thymeleafsample.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findByArtistId(int artistId){
        return  memberRepository.findByArtistId(artistId);
    }

    public void registerMember(Member member){
        memberRepository.save(member);
    }

    public Optional<Member> findById(Integer id){
        return  memberRepository.findById(id);
    }
}
