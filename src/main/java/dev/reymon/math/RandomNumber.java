package dev.reymon.math;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
	
	/**
	 * Mid Square Algorithm
	 * 
	 * @param List<String>
	 * */
	public static List<Double> midSquare(List<String> list) {
		
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();
		
		long seed      = Long.parseLong(list.getFirst());
		int digits     = Integer.parseInt(list.get(1));
		int iterations = Integer.parseInt(list.getLast());
		
		if (seed < Math.pow(10, digits - 1) || seed >= Math.pow(10, digits))
			return List.of();

		List<Double> listNumbers = new ArrayList<>();

		for (int i = 0; i < iterations; i++) {

			String number = String.format("%0" + (2 * digits) + "d", seed * seed);

			int start = (number.length() - digits) / 2;
			
			seed = Long.parseLong(
					number.substring(start, start + digits)
				);

			double r = seed / Math.pow(10, digits);
			
			listNumbers.add(r);
		}

		return listNumbers;
	}
	
	/**
	 * Mid Product Algorithm
	 * 
	 * @param List<String>
	 * */
	public static List<Double> midProduct(List<String> list) {
		
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();
		
		long seed       = Long.parseLong(list.getFirst());
		long seed2      = Long.parseLong(list.get(1));
		int  digits     = Integer.parseInt(list.get(2));
		int  iterations = Integer.parseInt(list.getLast());
		
		if (seed  < Math.pow(10, digits - 1) || seed  >= Math.pow(10, digits)) return List.of();
		if (seed2 < Math.pow(10, digits - 1) || seed2 >= Math.pow(10, digits)) return List.of();
		
		List<Double> listNumbers = new ArrayList<Double>();
		
		for (int i = 0; i < iterations; i++) {
			
			String centrals = String.format("%0" + (2 * digits) + "d", seed * seed2);
			
			int start = (centrals.length() - digits) / 2;
			
			centrals = centrals.substring(start, start + digits);
			
			long next = Long.parseLong(centrals);
			
			seed  = seed2;
			seed2 = next;
			
			double r = next / Math.pow(10, digits);
			
			listNumbers.add(r);
			
		}
		
		return listNumbers;
	}
	
	/**
	 * Quadratic Congruential Algorithm
	 * 
	 * @param List<String>
	 * */
	public static List<Double> quadraticCongruential(List<String> list) {
		
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();
		
		long seed       = Long.parseLong(list.getFirst());
		int  m          = Integer.parseInt(list.get(1));
		int  a          = Integer.parseInt(list.get(2));
		int  b          = Integer.parseInt(list.get(3));
		int  c          = Integer.parseInt(list.get(4));
		int  iterations = Integer.parseInt(list.getLast());
		
		List<Double> listNumbers = new ArrayList<Double>();
		
		//if ((a % 2) != 0 || Math.floorMod(b - a, 4) != 1 || (c % 2) == 0)
		//	return List.of();
		
		for (int i = 0; i < iterations; i++) {
			
			seed = Math.floorMod(((a * seed * seed ) + (b * seed + c)), m);
			
			double r = (double) seed / (m - 1);
			
			listNumbers.add(r);
			
		}
		
		return listNumbers;
	}
	
	/**
	 * Constant Multiply Algorithm
	 * 
	 * @param List<String>
	 * */
	public static List<Double> constantMultiplicative(List<String> list) {
		
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();
		
		long seed      = Long.parseLong(list.getFirst());
		long constant  = Long.parseLong(list.get(1));
		int  digits     = Integer.parseInt(list.get(2));
		int  iterations = Integer.parseInt(list.getLast());
		
		List<Double> listNumber = new ArrayList<Double>();
		
		for (int i = 0; i < iterations; i++) {
			long product = constant * seed;
			
			String centrals = String.format("%0"+ Long.toString(2 * digits) +"d", product);
			
			int start = (centrals.length() - digits) / 2;
			
			centrals = centrals.substring(start, start + digits);
			
			seed = Long.parseLong(centrals);
			
			double r = seed / Math.pow(10, digits);
			
			listNumber.add(r);
			
		}
		
		return listNumber;
	}
	
	/**
	 * Congruential Lineal Algorithm
	 * 
	 * @param List<String>
	 * */
	public static List<Double> congruentialLineal(List<String> list) {
		
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();
		
		long seed       = Long.parseLong(list.getFirst());
		int  module     = Integer.parseInt(list.get(1));
		int  Multiplier = Integer.parseInt(list.get(2));
		int  constant   = Integer.parseInt(list.get(3));
		int iterations  = Integer.parseInt(list.getLast());
		
		List<Double> listNumber = new ArrayList<Double>();
		
		for (int i = 0; i < iterations; i++) {
			
			seed = Math.floorMod(Multiplier * seed + constant, module);
			double r = (double) seed / (module - 1);
			listNumber.add(r);
			
		}
		
		return listNumber;
	}
	
	public static List<Double> congruentialMultiplicative(List<String> list) {
		
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();
		
		long seed             = Long.parseLong(list.getFirst());
		int  k                = Integer.parseInt(list.get(1));
		int  g                = Integer.parseInt(list.get(2));
		int iterations        = Integer.parseInt(list.getLast());
		
		List<Double> listNumber = new ArrayList<Double>();
		
		int m = Math.powExact(2, g);
		int a = 3 + 8 * k;
		
		for (int i = 0; i < iterations; i++) {
			
			seed     = Math.floorMod(a * seed, m);
			double r = (double) seed / (m - 1);
			
			listNumber.add(r);
			
		}
		
		return listNumber;
		
	}
	
	public static List<Double> congruentialAdditive(List<String> list) {
		
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();
		
		List<Long> results = new ArrayList<Long>();
		
		for (String s : list.getFirst().split(","))
			results.add(Long.parseLong(s));
		
		int  module     = Integer.parseInt(list.get(1));
		int  iterations = Integer.parseInt(list.getLast());
		
		int k = results.size();
		
		List<Double> listNumber = new ArrayList<Double>();
		
		for (int i = 0; i < iterations; i++) {
			
			long next = Math.floorMod(results.get(i) + results.get(i + k - 1), module);
			
			results.add(next);
			
			double r = (double) next / (module - 1);
			
			listNumber.add(r);
		}
		
		return listNumber;
		
	}
}