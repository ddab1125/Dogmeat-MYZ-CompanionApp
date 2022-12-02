package pl.coderslab.dogmeat.mutation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dogmeat.mutation.entity.Mutation;


@Transactional
public interface MutationRepository extends JpaRepository<Mutation, Long> {

}
