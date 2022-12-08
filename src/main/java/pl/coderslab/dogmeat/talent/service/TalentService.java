package pl.coderslab.dogmeat.talent.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.talent.entity.Talent;
import pl.coderslab.dogmeat.talent.repository.TalentRepository;

import java.util.List;

@Service
@Data
public class TalentService {
    private final TalentRepository talentRepository;

    public List<Talent> allTalents() {
        return talentRepository.findAll();
    }

}
