package com.myproject.denominationcalculator.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class ComputeData implements Serializable {

    @NotNull(message = "Current amount is required")
    @Min(value = 0, message = "Current amount must be non-negative")
    private double currentAmount;

    @NotNull(message = "Previous amount is required")
    @Min(value = 0, message = "Previous amount must be non-negative")
    private double previousAmount;

    @NotNull(message = "isCalculateOnServer flag is required")
    private boolean isCalculateOnServer;

    /**
     * @return the currentAmount
     */

    public double getCurrentAmount() {
        return currentAmount;
    }

    /**
     * @param currentAmount the currentAmount to set
     */
    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    /**
     * @return the previousAmount
     */
    public double getPreviousAmount() {
        return previousAmount;
    }

    /**
     * @param previousAmount the previousAmount to set
     */
    public void setPreviousAmount(double previousAmount) {
        this.previousAmount = previousAmount;
    }

    /**
     * @return the isCalculateOnServer
     */
    public boolean isCalculateOnServer() {
        return isCalculateOnServer;
    }

    /**
     * @param isCalculateOnServer the isCalculateOnServer to set
     */
    public void setCalculateOnServer(boolean isCalculateOnServer) {
        this.isCalculateOnServer = isCalculateOnServer;
    }

    public ComputeData(double currentAmount, double previousAmount, boolean isCalculateOnServer) {
        this.currentAmount = currentAmount;
        this.previousAmount = previousAmount;
        this.isCalculateOnServer = isCalculateOnServer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputeData that = (ComputeData) o;
        return Double.compare(currentAmount, that.currentAmount) == 0 && Double.compare(previousAmount, that.previousAmount) == 0 && isCalculateOnServer == that.isCalculateOnServer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentAmount, previousAmount, isCalculateOnServer);
    }

    @Override
    public String toString() {
        return "ComputeData{" +
                "currentAmount=" + currentAmount +
                ", previousAmount=" + previousAmount +
                ", isCalculateOnServer=" + isCalculateOnServer +
                '}';
    }
}
