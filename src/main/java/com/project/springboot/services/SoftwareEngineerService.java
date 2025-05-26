package com.project.springboot.services;


import com.project.springboot.ai.AiService;
import com.project.springboot.model.SoftwareEngineer;
import com.project.springboot.repository.SoftwareEngineerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class SoftwareEngineerService {
    private final SoftwareEngineerRepository softwareEngineerRepository;
    private final AiService aiService;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository, AiService aiService) {
        this.softwareEngineerRepository = softwareEngineerRepository;
        this.aiService = aiService;
    }


    public List<SoftwareEngineer> getSoftwareEngineers() {

        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        String prompt = """
                Based on the Programming TechStack %s that %s has given Provide a full learning path for this person.
                """.formatted(softwareEngineer.getTechStack(),softwareEngineer.getFirstName());
        softwareEngineerRepository.save(softwareEngineer);
        String chatRes =aiService.chat(prompt);
        softwareEngineer.setLearningPathRecommendation(chatRes);
        softwareEngineerRepository.save(softwareEngineer);
    }

   public SoftwareEngineer getSoftwareEngineerById(Integer id){
        return softwareEngineerRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("SoftwareEngineer with id " + id + " not found"));
   }

    public void deleteSoftwareEngineer(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    id+" not found"
            );

        }
        softwareEngineerRepository.deleteById(id);
    }

    public SoftwareEngineer updateSoftwareEngineerById(
            Integer id,
            SoftwareEngineer softwareEngineer
    ) {
        softwareEngineer.setId(id);
        return softwareEngineerRepository.save(softwareEngineer);
    }
}
