package com.desafio.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.desafio.model.Sale;

/** 
 * CsvReader class to read sales data from a CSV file. 
 * This class contains a method to read the CSV file and return a list of Sale objects. 
 */
public class CsvReader {
	
	/** 
	 * Reads a CSV file and returns a list of Sale objects. 
	 * @param filePath CSV file path. 
	 * @return List of Sale objects. 
	 */
	public List<Sale> readCsv(String filePath) {
		List<Sale> sales = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line = br.readLine();

			while (line != null) {
				String[] fields = line.split(",");
				Integer month = Integer.parseInt(fields[0]);
				Integer year = Integer.parseInt(fields[1]);
				String seller = fields[2];
				Integer items = Integer.parseInt(fields[3]);
				Double total = Double.parseDouble(fields[4]);

				sales.add(new Sale(month, year, seller, items, total));
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return sales;
	}

}
