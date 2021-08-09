package br.com.supertrader.controller;

import java.math.BigDecimal;

public class CallUpdateRequest {

    private BigDecimal entryPrice;

    private BigDecimal partialExit;

    private BigDecimal finalTarget;

    private BigDecimal stopLoss;

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
