package com.myproject.denominationcalculator.service;

import com.myproject.denominationcalculator.model.CalculationResult;
import com.myproject.denominationcalculator.model.Denomination;
import com.myproject.denominationcalculator.model.DenominationDifference;
import com.myproject.denominationcalculator.model.ComputeData;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

@Service
public class DenominationCalculatorService {

    public CalculationResult calculateDenominations(ComputeData data) {

        if (data.getCurrentAmount() <= 0 || data.getPreviousAmount() <= 0) {
            throw new IllegalArgumentException("Amounts must be positive.");
        }

        List<Denomination> denominations = calculateDenominations(data.getCurrentAmount());
        List<DenominationDifference> differences = calculateDifferences(data);
        CalculationResult result = new CalculationResult(denominations, differences, data);
        return result;
    }

    private List<Denomination> calculateDenominations(double amount) {
        List<Denomination> denominations = new ArrayList<>();
        double[] values = { 200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01 };

        for (double value : values) {
            if (amount >= value) {
                int count = (int) Math.floor(amount / value);
                denominations.add(new Denomination(value, count));
                amount -= count * value;
                amount = Math.round(amount * 100.0) / 100.0; // Round to 2 decimal places
            }
        }

        return denominations;
    }

    private List<DenominationDifference> calculateDifferences(ComputeData data) {
        double previousAmount = data.getPreviousAmount();
        List<Denomination> currentDenominations = calculateDenominations(data.getCurrentAmount());

        List<DenominationDifference> differences = new ArrayList<>();

        if (previousAmount == 0) {
            // Add all current denominations with a positive difference
            for (Denomination denomination : currentDenominations) {
                differences.add(new DenominationDifference(denomination.getDenomination(), denomination.getQuantity()));
            }
        } else {
            // Calculate differences as before
            List<Denomination> previousDenominations = calculateDenominations(previousAmount);

            for (Denomination prevDenomination : previousDenominations) {
                Denomination current = currentDenominations.stream()
                        .filter(d -> d.getDenomination() == prevDenomination.getDenomination())
                        .findFirst().orElse(null);

                int previousQuantity = prevDenomination.getQuantity();
                int currentQuantity = (current != null) ? current.getQuantity() : 0;
                int difference = currentQuantity - previousQuantity;

                differences.add(new DenominationDifference(prevDenomination.getDenomination(), difference));
            }

            // Handle denominations present in current amount but missing in previous amount
            for (Denomination currDenomination : currentDenominations) {
                if (previousDenominations.stream()
                        .noneMatch(d -> d.getDenomination() == currDenomination.getDenomination())) {
                    differences.add(new DenominationDifference(currDenomination.getDenomination(),
                            currDenomination.getQuantity()));
                }
            }
        }

        // Sort differences in descending order based on denomination
        Collections.sort(differences, (d1, d2) -> Double.compare(d2.getDenomination(), d1.getDenomination()));

        return differences;
    }

}