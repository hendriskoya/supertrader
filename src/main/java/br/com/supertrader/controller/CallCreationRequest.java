package br.com.supertrader.controller;

import br.com.supertrader.model.Call;
import br.com.supertrader.model.CallType;
import java.math.BigDecimal;

public class CallCreationRequest {

    private String stock;

    private CallType type;

    private Integer strategyId;

    private BigDecimal entryPrice;

    private BigDecimal partialExit;

    private BigDecimal finalTarget;

    private BigDecimal stopLoss;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public CallType getType() {
        return type;
    }

    public void setType(CallType type) {
        this.type = type;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public BigDecimal getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(BigDecimal entryPrice) {
        this.entryPrice = entryPrice;
    }

    public BigDecimal getPartialExit() {
        return partialExit;
    }

    public void setPartialExit(BigDecimal partialExit) {
        this.partialExit = partialExit;
    }

    public BigDecimal getFinalTarget() {
        return finalTarget;
    }

    public void setFinalTarget(BigDecimal finalTarget) {
        this.finalTarget = finalTarget;
    }

    public BigDecimal getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(BigDecimal stopLoss) {
        this.stopLoss = stopLoss;
    }

}
