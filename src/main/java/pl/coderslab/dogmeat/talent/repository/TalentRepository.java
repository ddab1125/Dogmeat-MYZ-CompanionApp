package pl.coderslab.dogmeat.talent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.dogmeat.mutation.entity.Mutation;
import pl.coderslab.dogmeat.talent.entity.Talent;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TalentRepository extends JpaRepository<Talent, Long> {

    @Query("SELECT t FROM Talent t")
    List<Mutation> allTalents();

}
