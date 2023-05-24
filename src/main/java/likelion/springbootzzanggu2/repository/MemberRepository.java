package likelion.springbootzzanggu2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import likelion.springbootzzanggu2.domain.Member;
public interface MemberRepository extends JpaRepository<Member, Long> {
}
