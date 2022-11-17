package ng.pencode.faqsimpl.controller;

import ng.pencode.apimodule.dto.FaqsDTO;
import ng.pencode.apimodule.service.IFaqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/faqs")
//@CrossOrigin(origins = "*")
public class FaqsController {

    @Autowired
    IFaqsService iFaqsService;

    public FaqsController(IFaqsService iFaqsService) {
        this.iFaqsService = iFaqsService;
    }

    @GetMapping
    public ResponseEntity<List<FaqsDTO>> getAllFaqs(){
        return new ResponseEntity<>(iFaqsService.getAllFaqs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FaqsDTO> getFaqsById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(iFaqsService.getFaqsById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FaqsDTO> updateFaqs(FaqsDTO faqsDTO,@PathVariable(name = "id") Long id){
        FaqsDTO faqsDTOUpdate = iFaqsService.updateFaqs(faqsDTO, id);
        if(faqsDTOUpdate == null) return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(faqsDTOUpdate, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FaqsDTO> createFaqs(@RequestBody FaqsDTO faqsDTO) {
        FaqsDTO faqs = iFaqsService.createFaqs(faqsDTO);
        return new ResponseEntity<>(faqs, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <?> deleteActivities(@PathVariable(name = "id") Long id){
        iFaqsService.deleteFaqs(id);
        HashMap<String,String> data = new HashMap<>();
        data.put("message", "success to delete");
        return new ResponseEntity(data,HttpStatus.OK);
    }


}
