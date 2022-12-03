package pl.coderslab.dogmeat.mutation.service;


import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.dogmeat.mutation.entity.Mutation;
import pl.coderslab.dogmeat.mutation.repository.MutationRepository;

import java.util.List;

@Service
@Data
public class MutationService {

    private final MutationRepository mutationRepository;

    public List<Mutation> allMutations() {
       return mutationRepository.allMutations();
    }

    public void saveMutation(Mutation mutation) {
        mutationRepository.save(mutation);
    }

}
