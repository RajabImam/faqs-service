package ng.pencode.apimodule.service;

import ng.pencode.apimodule.dto.FaqsDTO;

import java.util.List;

public interface IFaqsService {

    List<FaqsDTO> getAllFaqs();

    FaqsDTO getFaqsById(Long id);

    FaqsDTO createFaqs(FaqsDTO faqsDTO);

    FaqsDTO updateFaqs(FaqsDTO faqsDTO, Long id);

    void deleteFaqs(Long id);


}
