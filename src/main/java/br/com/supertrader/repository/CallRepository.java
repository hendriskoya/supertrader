package br.com.supertrader.repository;

import br.com.supertrader.model.Call;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends CrudRepository<Call, Integer> {

    Optional<Call> findByStock(String stock);
}
