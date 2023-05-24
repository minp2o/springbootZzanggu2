package likelion.springbootzzanggu2.service;

import likelion.springbootzzanggu2.domain.Member;
import likelion.springbootzzanggu2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
public interface MemberService {
    public void save(Member member);

    public Member findById(Long id);

    public List<Member> findAll();
}
