package br.com.supertrader.callstrategy.service;

import br.com.supertrader.callstrategy.model.CallStrategy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CallStrategyRepository extends CrudRepository<CallStrategy, Integer> {
}
