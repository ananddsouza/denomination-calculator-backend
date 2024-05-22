package com.myproject.denominationcalculator.model;

import java.io.Serializable;
import java.util.Objects;

public class Denomination implements Serializable {
    private double denomination;
    private int quantity;

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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @param denomination
     * @param quantity
     */
    public Denomination(double denomination, int quantity) {
        this.denomination = denomination;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Denomination that = (Denomination) o;
        return Double.compare(denomination, that.denomination) == 0 && quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, quantity);
    }

    @Override
    public String toString() {
        return "Denomination{" +
                "denomination=" + denomination +
                ", quantity=" + quantity +
                '}';
    }
}
