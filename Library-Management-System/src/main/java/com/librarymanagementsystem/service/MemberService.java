package com.librarymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagementsystem.entity.Member;
import com.librarymanagementsystem.repository.MemberRepository;

@Service
public class MemberService {
	
    @Autowired
    private MemberRepository memberRepository;
    

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

}
