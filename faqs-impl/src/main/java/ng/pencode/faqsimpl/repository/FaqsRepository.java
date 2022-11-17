package ng.pencode.faqsimpl.repository;

import ng.pencode.faqsimpl.model.Faqs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqsRepository extends JpaRepository<Faqs, Long> {
}
