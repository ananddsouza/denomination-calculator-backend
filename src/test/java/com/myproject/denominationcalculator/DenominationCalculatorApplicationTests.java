package com.myproject.denominationcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.myproject.denominationcalculator.model.ComputeData;
import com.myproject.denominationcalculator.model.Denomination;
import com.myproject.denominationcalculator.model.CalculationResult;
import com.myproject.denominationcalculator.model.DenominationDifference;
import com.myproject.denominationcalculator.service.DenominationCalculatorService;

@SpringBootTest
class DenominationCalculatorApplicationTests {

	public class DenominationCalculatorServiceTest {

		@Mock
		private ComputeData computeData;

		@InjectMocks
		private DenominationCalculatorService denominationCalculatorService;

		@BeforeEach
		public void setUp() {
			MockitoAnnotations.openMocks(this);
		}

		// Test Case 1: Previous Amount is Non-Zero
		@Test
		public void testCalculateDenominationsWithNonZeroPreviousAmount() {
			// Set up mock data
			when(computeData.getCurrentAmount()).thenReturn(276.0);
			when(computeData.getPreviousAmount()).thenReturn(200.0);

			// Call the method
			CalculationResult result = denominationCalculatorService.calculateDenominations(computeData);

			// Verify the result
			assertNotNull(result);
			// Add assertions to verify the correctness of the CalculationResult object
			// For example:
			// assertEquals(expectedDenominations, result.getDenominations());
			// assertEquals(expectedDifferences, result.getDifferences());
		}

		// Test Case 2: Current Amount is Zero
		@Test
		public void testCalculateDenominationsWithZeroCurrentAmount() {
			// Set up mock data
			when(computeData.getCurrentAmount()).thenReturn(0.0);
			when(computeData.getPreviousAmount()).thenReturn(200.0);

			// Call the method
			CalculationResult result = denominationCalculatorService.calculateDenominations(computeData);

			// Verify the result
			assertNotNull(result);
			// Add assertions to verify the correctness of the CalculationResult object
			// For example:
			// assertTrue(result.getDenominations().isEmpty());
			// assertTrue(result.getDifferences().isEmpty());
		}

		// Test Case 3: Current and Previous Amounts are Zero
		@Test
		public void testCalculateDenominationsWithZeroAmounts() {
			// Set up mock data
			when(computeData.getCurrentAmount()).thenReturn(0.0);
			when(computeData.getPreviousAmount()).thenReturn(0.0);

			// Call the method
			CalculationResult result = denominationCalculatorService.calculateDenominations(computeData);

			// Verify the result
			assertNotNull(result);
			// Add assertions to verify the correctness of the CalculationResult object
			// For example:
			// assertTrue(result.getDenominations().isEmpty());
			// assertTrue(result.getDifferences().isEmpty());
		}

		// Test Case 4: Negative Current Amount
		@Test
		public void testCalculateDenominationsWithNegativeAmount() {
			// Set up mock data with negative current amount
			when(computeData.getCurrentAmount()).thenReturn(-100.0);
			when(computeData.getPreviousAmount()).thenReturn(0.0);

			// Verify that IllegalArgumentException is thrown
			assertThrows(IllegalArgumentException.class, () -> {
				denominationCalculatorService.calculateDenominations(computeData);
			});
		}

		// Test Case 5: Test calculate denominations
		@Test
		public void testCalculateDenominations() {
			// Set up mock data
			when(computeData.getCurrentAmount()).thenReturn(276.0);
			when(computeData.getPreviousAmount()).thenReturn(0.0);

			// Call the method
			CalculationResult result = denominationCalculatorService.calculateDenominations(computeData);

			// Verify the result
			assertNotNull(result);

			// Refine the expected output to match CalculationResult structure
			List<Denomination> expectedDenominations = Arrays.asList(
					new Denomination(100.0, 2),
					new Denomination(50.0, 1),
					new Denomination(20.0, 1),
					new Denomination(5.0, 1),
					new Denomination(1.0, 1));
			List<DenominationDifference> expectedDifferences = Arrays.asList(
					new DenominationDifference(100.0, 2),
					new DenominationDifference(50.0, 1),
					new DenominationDifference(20.0, 1),
					new DenominationDifference(5.0, 1),
					new DenominationDifference(1.0, 1));

			// Assert the result matches the expected structure
			assertEquals(expectedDenominations, result.getDenominations());
			assertEquals(expectedDifferences, result.getDifferences());
			assertEquals(computeData, result.getComputeData());
		}

	}

}