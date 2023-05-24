package likelion.springbootzzanggu2.repository;

import likelion.springbootzzanggu2.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}