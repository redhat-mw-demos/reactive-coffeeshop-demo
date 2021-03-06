package me.escoffier.quarkus.coffeeshop.model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Beverage {

    private String beverage;
    private String customer;
    private String preparedBy;
    private String orderId;
    private State preparationState;

    public Beverage() {

    }

    public static Beverage queued(Order order) {
        return new Beverage(order, null, State.IN_QUEUE);
    }

    public enum State {
        IN_QUEUE,
        BEING_PREPARED,
        READY,
        FAILED;
    }

    public Beverage(Order order, String baristaName, State state) {
        this.beverage = order.getProduct();
        this.customer = order.getName();
        this.orderId = order.getOrderId();
        this.preparedBy = baristaName;
        this.preparationState = state;
    }

    public String getBeverage() {
        return beverage;
    }

    public Beverage setBeverage(String beverage) {
        this.beverage = beverage;
        return this;
    }

    public String getCustomer() {
        return customer;
    }

    public Beverage setCustomer(String customer) {
        this.customer = customer;
        return this;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public Beverage setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public Beverage setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public State getPreparationState() {
        return preparationState;
    }

    public Beverage setPreparationState(State preparationState) {
        this.preparationState = preparationState;
        return this;
    }
}
