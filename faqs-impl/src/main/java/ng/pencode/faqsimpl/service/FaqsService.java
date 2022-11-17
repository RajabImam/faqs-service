package ng.pencode.faqsimpl.service;

import ng.pencode.apimodule.dto.FaqsDTO;
import ng.pencode.apimodule.service.IFaqsService;
import ng.pencode.faqsimpl.model.Faqs;
import ng.pencode.faqsimpl.repository.FaqsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FaqsService implements IFaqsService {
    @Autowired
    FaqsRepository faqsRepository;

    @Autowired
    ModelMapper modelMapper;

    public FaqsService(FaqsRepository faqsRepository) {
        this.faqsRepository = faqsRepository;
    }


    @Override
    public List<FaqsDTO> getAllFaqs() {
        return faqsRepository.findAll().stream().map(faqs -> modelMapper.map(faqs, FaqsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public FaqsDTO getFaqsById(Long id) {
        return modelMapper.map(faqsRepository.getById(id),FaqsDTO.class);
    }

    @Override
    public FaqsDTO createFaqs(FaqsDTO faqsDTO) {
        Faqs faqs = modelMapper.map(faqsDTO,Faqs.class);
        return modelMapper.map(faqsRepository.save(faqs),FaqsDTO.class);
    }

    @Override
    public FaqsDTO updateFaqs(FaqsDTO faqsDTO, Long id) {
        Optional<Faqs> oldFaqs = faqsRepository.findById(id);
        if (oldFaqs.isPresent()){
            Faqs faqs = modelMapper.map(faqsDTO,Faqs.class);
            faqs.setId(oldFaqs.get().getId());
            return modelMapper.map(faqsRepository.save(faqs),FaqsDTO.class);
        }
        return null;
    }

    @Override
    public void deleteFaqs(Long id) {
        faqsRepository.deleteById(id);
    }



}
