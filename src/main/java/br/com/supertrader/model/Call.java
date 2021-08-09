package br.com.supertrader.model;

import br.com.supertrader.callstrategy.model.CallStrategy;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "st_call")
@Audited
@AuditTable(value = "st_call_audit")
public class Call {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "stock", nullable = false)
    private String stock;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CallType type;

    @ManyToOne
    @JoinColumn(name = "strategy_id", nullable = false)
//    @Column(name = "strategy_id", nullable = false)
    private CallStrategy strategy;

    @Column(name = "entry_price", nullable = false)
    private BigDecimal entryPrice;

    @Column(name = "partial_exit", nullable = false)
    private BigDecimal partialExit;

    @Column(name = "final_target", nullable = false)
    private BigDecimal finalTarget;

    @Column(name = "stop_loss", nullable = false)
    private BigDecimal stopLoss;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private CallStatus status;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersit() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public CallStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(CallStrategy strategy) {
        this.strategy = strategy;
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

    public CallStatus getStatus() {
        return status;
    }

    public void setStatus(CallStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
