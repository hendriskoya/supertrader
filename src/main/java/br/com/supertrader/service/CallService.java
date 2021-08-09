package br.com.supertrader.service;

import br.com.supertrader.callstrategy.model.CallStrategy;
import br.com.supertrader.callstrategy.service.CallStrategyService;
import br.com.supertrader.controller.CallCreationRequest;
import br.com.supertrader.controller.CallUpdateRequest;
import br.com.supertrader.model.Call;
import br.com.supertrader.repository.CallRepository;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CallService {

    private final CallRepository callRepository;
    private final CallStrategyService callStrategyService;

    public CallService(CallRepository callRepository, CallStrategyService callStrategyService) {
        this.callRepository = callRepository;
        this.callStrategyService = callStrategyService;
    }

    public Call createCall(CallCreationRequest request) {
        Call call = buildCall(request);
        return callRepository.save(call);
    }

    public Call updateCall(Integer id, CallUpdateRequest request) {
        Call call = callRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        call.setEntryPrice(request.getEntryPrice());
        call.setPartialExit(request.getPartialExit());
        call.setFinalTarget(request.getFinalTarget());
        call.setStopLoss(request.getStopLoss());

        return callRepository.save(call);
    }

    public Optional<Call> findByStock(String stock) {
        Assert.notNull(stock, "stock must be not null");
        return callRepository.findByStock(stock);
    }

    private Call buildCall(CallCreationRequest request) {
        Assert.notNull(request, "request must be not null");
        Assert.notNull(request.getStrategyId(), "request.strategyId must be not null");

        CallStrategy callStrategy = callStrategyService.findById(request.getStrategyId()).orElseThrow(EntityNotFoundException::new);

        Call call = new Call();
        call.setStock(request.getStock());
        call.setType(request.getType());
        call.setStrategy(callStrategy);
        call.setEntryPrice(request.getEntryPrice());
        call.setPartialExit(request.getPartialExit());
        call.setFinalTarget(request.getFinalTarget());
        call.setStopLoss(request.getStopLoss());
        return call;
    }

    public Iterable<Call> findAll() {
        return callRepository.findAll();
    }
}
