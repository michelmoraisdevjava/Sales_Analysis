//Analise de Vendas2
package com.desafio.main;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.desafio.model.Sale;
import com.desafio.util.CsvReader;

/** 
 * Main class of the sales analysis program. 
 * This class reads a CSV file containing sales data, 
 * processes the data to calculate the total sold by each seller 
 * and displays the results. 
 */

public class Program {
	
	/** 
	 * Main method that runs the program. 
	 * @param args Command line arguments (unused). 
	 */

	public static void main(String[] args) {
		// Set the default locale to US
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Prompt the user for the full path of the CSV file
		System.out.print("Enter full file path: ");
		String filePath = sc.nextLine();
		
		// Create an instance of CsvReader and read the CSV file
		CsvReader csvReader = new CsvReader();
		List<Sale> sales = csvReader.readCsv(filePath);
		
		// Generate a set of unique seller names
		Set<String> uniqueSellers = sales.stream()
				.map(Sale::getSeller)
				.collect(Collectors.toSet());
		
		// Calculates the total sold by each seller
		Map<String, Double> totalSalesPerSeller = new HashMap<String, Double>();
		for(String seller : uniqueSellers) {
			double totalSales = sales.stream()
					.filter(sale -> sale.getSeller().equals(seller))
					.mapToDouble(Sale::getTotal)
					.sum();
			totalSalesPerSeller.put(seller, totalSales);
		}
		
		// Displays the total sold by each seller
		System.out.println("\nTotal sales per seller:");
		totalSalesPerSeller.forEach((seller, total) ->
		System.out.println(seller + " - " + "R$ " + String.format("%.2f", total)));
		
		sc.close();

	}

}
