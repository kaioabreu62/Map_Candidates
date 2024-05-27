package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votesCandidates = new LinkedHashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while(line != null) {
				
				String[] fields = line.split(",");
				String names = fields[0];
				int count = Integer.parseInt(fields[1]);
				
				if (votesCandidates.containsKey(names)) {
					int votes = votesCandidates.get(names);
					votesCandidates.put(names, count + votes);
				} else {
					votesCandidates.put(names, count);
				}
				
				line = br.readLine();
			}
			
			for (String key : votesCandidates.keySet()) {
				System.out.println(key + ": " + votesCandidates.get(key));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}
}
