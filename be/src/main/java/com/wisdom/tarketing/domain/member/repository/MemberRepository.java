package com.wisdom.tarketing.domain.member.repository;

import com.wisdom.tarketing.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
