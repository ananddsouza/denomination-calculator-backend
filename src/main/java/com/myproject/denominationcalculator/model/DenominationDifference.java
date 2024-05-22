package com.myproject.denominationcalculator.model;

import java.io.Serializable;
import java.util.Objects;

public class DenominationDifference implements Serializable {

    private double denomination;
    private int difference;

    /**
     * @return the denomination
     */
    public double getDenomination() {
        return denomination;
    }

    /**
     * @param denomination the denomination to set
     */
    public void setDenomination(double denomination) {
        this.denomination = denomination;
    }

    /**
     * @return the difference
     */
    public int getDifference() {
        return difference;
    }

    /**
     * @param difference the difference to set
     */
    public void setDifference(int difference) {
        this.difference = difference;
    }

    /**
     * @param denomination
     * @param difference
     */
    public DenominationDifference(double denomination, int difference) {
        this.denomination = denomination;
        this.difference = difference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DenominationDifference that = (DenominationDifference) o;
        return Double.compare(denomination, that.denomination) == 0 && difference == that.difference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, difference);
    }

    @Override
    public String toString() {
        return "DenominationDifference{" +
                "denomination=" + denomination +
                ", difference=" + difference +
                '}';
    }
}
