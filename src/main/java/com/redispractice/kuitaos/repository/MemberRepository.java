package com.redispractice.kuitaos.repository;

import com.redispractice.kuitaos.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
