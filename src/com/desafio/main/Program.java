package com.desafio.main;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.desafio.model.Sale;
import com.desafio.util.CsvReader;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String filePath = sc.nextLine();
		
		CsvReader csvReader = new CsvReader();
		List<Sale> sales = csvReader.readCsv(filePath);
		
		List<Sale> topSales2016 = sales.stream()
				.filter(sale -> sale.getYear() == 2016)
				.sorted(Comparator.comparingDouble(Sale::averageTotal).reversed())
				.limit(5)
				.collect(Collectors.toList());
		
		topSales2016.forEach(sale -> System.out.println(sale));
		
		double totalLogan = sales.stream()
				.filter(sale -> sale.getSeller().equalsIgnoreCase("Logan") && (sale.getMonth() == 1 || sale.getMonth() == 7 ))
				.mapToDouble(Sale::getTotal)
				.sum();
		
		System.out.println("\nTotal value sold by seller Logan in months 1 and 7 = " + String.format("%.2f", totalLogan));
		
		sc.close();

	}

}
