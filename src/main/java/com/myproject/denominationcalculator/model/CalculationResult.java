package com.myproject.denominationcalculator.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CalculationResult implements Serializable {
    private List<Denomination> denominations;
    private List<DenominationDifference> differences;
    private ComputeData computeData;

    /**
     * @return the denominations
     */
    public List<Denomination> getDenominations() {
        return denominations;
    }

    /**
     * @param denominations the denominations to set
     */
    public void setDenominations(List<Denomination> denominations) {
        this.denominations = denominations;
    }

    /**
     * @return the differences
     */
    public List<DenominationDifference> getDifferences() {
        return differences;
    }

    /**
     * @param differences the differences to set
     */
    public void setDifferences(List<DenominationDifference> differences) {
        this.differences = differences;
    }

    /**
     * @return the computeData
     */
    public ComputeData getComputeData() {
        return computeData;
    }

    /**
     * @param computeData the computeData to set
     */
    public void setComputeData(ComputeData computeData) {
        this.computeData = computeData;
    }

    /**
     * @param denominations
     * @param differences
     * @param computeData
     */
    public CalculationResult(List<Denomination> denominations, List<DenominationDifference> differences,
            ComputeData computeData) {
        this.denominations = denominations;
        this.differences = differences;
        this.computeData = computeData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculationResult that = (CalculationResult) o;
        return Objects.equals(denominations, that.denominations) && Objects.equals(differences, that.differences) && Objects.equals(computeData, that.computeData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(denominations, differences, computeData);
    }

    @Override
    public String toString() {
        return "CalculationResult{" +
                "denominations=" + denominations +
                ", differences=" + differences +
                ", computeData=" + computeData +
                '}';
    }


}
