package com.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.librarymanagementsystem.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}
