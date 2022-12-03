package pl.coderslab.dogmeat.mutation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dogmeat.mutation.entity.Mutation;

import java.util.List;


@Transactional
public interface MutationRepository extends JpaRepository<Mutation, Long> {

    @Query("SELECT m FROM Mutation m")
    List<Mutation> allMutations();

}
