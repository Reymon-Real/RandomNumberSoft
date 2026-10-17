package dev.reymon.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.statistics.distribution.ChiSquaredDistribution;
import org.apache.commons.statistics.distribution.NormalDistribution;

import smile.math.Histogram;

public class RandomNumber {

	/**
	 * Mid Square Algorithm
	 * 
	 * @param List<String>
	 */
	public static List<Double> midSquare(List<String> list) {

		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();

		long seed = Long.parseLong(list.getFirst());
		int digits = Integer.parseInt(list.get(1));
		int iterations = Integer.parseInt(list.getLast());

		if (seed < Math.pow(10, digits - 1) || seed >= Math.pow(10, digits))
			return List.of();

		List<Double> listNumbers = new ArrayList<>();

		for (int i = 0; i < iterations; i++) {

			String number = String.format("%0" + (2 * digits) + "d", seed * seed);

			int start = (number.length() - digits) / 2;

			seed = Long.parseLong(number.substring(start, start + digits));

			double r = seed / Math.pow(10, digits);

			listNumbers.add(r);
		}

		return listNumbers;
	}

	/**
	 * Mid Product Algorithm
	 * 
	 * @param List<String>
	 */
	public static List<Double> midProduct(List<String> list) {

		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();

		long seed = Long.parseLong(list.getFirst());
		long seed2 = Long.parseLong(list.get(1));
		int digits = Integer.parseInt(list.get(2));
		int iterations = Integer.parseInt(list.getLast());

		if (seed < Math.pow(10, digits - 1) || seed >= Math.pow(10, digits))
			return List.of();
		if (seed2 < Math.pow(10, digits - 1) || seed2 >= Math.pow(10, digits))
			return List.of();

		List<Double> listNumbers = new ArrayList<Double>();

		for (int i = 0; i < iterations; i++) {

			String centrals = String.format("%0" + (2 * digits) + "d", seed * seed2);

			int start = (centrals.length() - digits) / 2;

			centrals = centrals.substring(start, start + digits);

			long next = Long.parseLong(centrals);

			seed = seed2;
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
	 */
	public static List<Double> quadraticCongruential(List<String> list) {

		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();

		long seed = Long.parseLong(list.getFirst());
		int m = Integer.parseInt(list.get(1));
		int a = Integer.parseInt(list.get(2));
		int b = Integer.parseInt(list.get(3));
		int c = Integer.parseInt(list.get(4));
		int iterations = Integer.parseInt(list.getLast());

		List<Double> listNumbers = new ArrayList<Double>();

		// if ((a % 2) != 0 || Math.floorMod(b - a, 4) != 1 || (c % 2) == 0)
		// return List.of();

		for (int i = 0; i < iterations; i++) {

			seed = Math.floorMod(((a * seed * seed) + (b * seed + c)), m);

			double r = (double) seed / (m - 1);

			listNumbers.add(r);

		}

		return listNumbers;
	}

	/**
	 * Constant Multiply Algorithm
	 * 
	 * @param List<String>
	 */
	public static List<Double> constantMultiplicative(List<String> list) {

		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();

		long seed = Long.parseLong(list.getFirst());
		long constant = Long.parseLong(list.get(1));
		int digits = Integer.parseInt(list.get(2));
		int iterations = Integer.parseInt(list.getLast());

		List<Double> listNumber = new ArrayList<Double>();

		for (int i = 0; i < iterations; i++) {
			long product = constant * seed;

			String centrals = String.format("%0" + Long.toString(2 * digits) + "d", product);

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
	 */
	public static List<Double> congruentialLineal(List<String> list) {

		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();

		long seed = Long.parseLong(list.getFirst());
		int module = Integer.parseInt(list.get(1));
		int Multiplier = Integer.parseInt(list.get(2));
		int constant = Integer.parseInt(list.get(3));
		int iterations = Integer.parseInt(list.getLast());

		List<Double> listNumber = new ArrayList<Double>();

		for (int i = 0; i < iterations; i++) {

			seed = Math.floorMod(Multiplier * seed + constant, module);
			double r = (double) seed / (module - 1);
			listNumber.add(r);

		}

		return listNumber;
	}

	/**
	 * Congruential Multiplicative
	 * 
	 * @param List<String>
	 */
	public static List<Double> congruentialMultiplicative(List<String> list) {

		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();

		long seed = Long.parseLong(list.getFirst());
		int k = Integer.parseInt(list.get(1));
		int g = Integer.parseInt(list.get(2));
		int iterations = Integer.parseInt(list.getLast());

		List<Double> listNumber = new ArrayList<Double>();

		int m = Math.powExact(2, g);
		int a = 3 + 8 * k;

		for (int i = 0; i < iterations; i++) {

			seed = Math.floorMod(a * seed, m);
			double r = (double) seed / (m - 1);

			listNumber.add(r);

		}

		return listNumber;

	}

	/**
	 * Congruential Additive
	 * 
	 * @param List<String>
	 */
	public static List<Double> congruentialAdditive(List<String> list) {

		for (int i = 0; i < list.size(); i++)
			if (list.get(i).isEmpty())
				return List.of();

		List<Long> results = new ArrayList<Long>();

		for (String s : list.getFirst().split(","))
			results.add(Long.parseLong(s));

		int module = Integer.parseInt(list.get(1));
		int iterations = Integer.parseInt(list.getLast());

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

	/**
	 * Average Test
	 * 
	 * @param Map<String, Double>
	 */
	public static Map<String, Double> averageTest(Map<String, String> map) {

		ArrayList<Double> numbers = new ArrayList<Double>();
		double alpha = Double.parseDouble(map.get("Alpha"));
		Map<String, Double> localMap = new HashMap<String, Double>();

		for (String s : map.get("Numbers").split(","))
			numbers.add(Double.parseDouble(s));

		double media = Arrays.stream(numbers.stream().mapToDouble(Double::doubleValue).toArray()).average().orElse(0.0);

		double z_alpha = NormalDistribution.of(0, 1).inverseCumulativeProbability(1 - alpha / 2.0);

		double calc = z_alpha * Math.sqrt(1.0 / (12.0 * numbers.size()));

		double lowerLimit = 0.5 - calc;
		double upperLimit = 0.5 + calc;

		// double z0 = ((media - 0.5) * Math.sqrt((double) numbers.size())) /
		// Math.sqrt(1.0 / 12.0);
		// double z_critic = NormalDistribution.of(0, 1).inverseCumulativeProbability(1
		// - alpha / 2);

		localMap.put("LowerLimit", lowerLimit);
		localMap.put("UpperLimit", upperLimit);
		localMap.put("Media", media);

		return localMap;
	}

	/**
	 * Variance Test
	 * 
	 * @param Map<String, Double>
	 */
	public static Map<String, Double> varianceTest(Map<String, String> map) {

		ArrayList<Double> numbers = new ArrayList<Double>();
		double alpha = Double.parseDouble(map.get("Alpha"));
		Map<String, Double> localMap = new HashMap<String, Double>();

		for (String s : map.get("Numbers").split(","))
			numbers.add(Double.parseDouble(s));

		double media = numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		double variance = numbers.stream().mapToDouble(n -> Math.pow(n - media, 2)).sum() / (numbers.size() - 1);

		double libertyGrade = numbers.size() - 1;

		double chiLowerLimit = ChiSquaredDistribution.of(libertyGrade).inverseCumulativeProbability(alpha / 2);
		double chiUpperLimit = ChiSquaredDistribution.of(libertyGrade).inverseCumulativeProbability(1 - alpha / 2);

		double lowerLimit = chiLowerLimit / (12 * (numbers.size() - 1));
		double upperLimit = chiUpperLimit / (12 * (numbers.size() - 1));

		localMap.put("Variance", variance);
		localMap.put("Media", media);
		localMap.put("LowerLimit", lowerLimit);
		localMap.put("UpperLimit", upperLimit);

		return localMap;
	}

	/**
	 * Square Chi
	 * 
	 * @param Map<String, Double>
	 */
	public static Map<String, Double> squareChi(Map<String, String> map) {

		ArrayList<Double> numbers = new ArrayList<Double>();
		double alpha = Double.parseDouble(map.get("Alpha"));
		int inter = Integer.parseInt(map.get("Inter"));

		for (String s : map.get("Numbers").split(","))
			numbers.add(Double.parseDouble(s));

		double[] breaks = Histogram.breaks(0.0, 1.0, inter);
		double[][] histogram = Histogram.of(numbers.stream().mapToDouble(Double::doubleValue).toArray(), breaks);

		double expectedFrecuency = (double) numbers.size() / inter;
		double[] observableFrecuency = histogram[2];

		double calculateChi = 0.0;

		for (double frecuency : observableFrecuency) {

			double diference = frecuency - expectedFrecuency;
			calculateChi += (diference * diference) / expectedFrecuency;
		}

		double tableChi = ChiSquaredDistribution.of(inter - 1).inverseCumulativeProbability(1.0 - alpha);

		Map<String, Double> localMap = new HashMap<String, Double>();

		localMap.put("TableChi", tableChi);
		localMap.put("CalculateChi", calculateChi);

		return localMap;
	}

	/**
	 * Kolmogorov Smirnov
	 * 
	 * @param Map<String, Double>
	 */
	public static Map<String, Double> kolmogorovSmirnov(Map<String, String> map) {

		ArrayList<Double> numbers = new ArrayList<Double>();
		double alpha = Double.parseDouble(map.get("Alpha"));
		Map<String, Double> localMap = new HashMap<String, Double>();

		for (String s : map.get("Numbers").split(","))
			numbers.add(Double.parseDouble(s));

		numbers.sort(Double::compareTo);

		double d_plus = 0.0;
		double d_minus = 0.0;

		for (int i = 0; i < numbers.size(); i++) {
			double difference = (double) (i + 1) / numbers.size() - numbers.get(i);
			d_plus = Math.max(d_plus, difference);
		}

		for (int i = 0; i < numbers.size(); i++) {
			double difference = numbers.get(i) - (double) i / numbers.size();
			d_minus = Math.max(d_minus, difference);
		}

		double d_max = Math.max(d_plus, d_minus);

		// double d_critic = 1.36 / Math.sqrt((double) numbers.size());
		double d_critic = Math.sqrt(-Math.log(alpha / 2.0) / (2.0 * numbers.size()));

		localMap.put("d_plus", d_plus);
		localMap.put("d_minus", d_minus);
		localMap.put("d_max", d_max);
		localMap.put("d_critic", d_critic);

		return localMap;
	}

}