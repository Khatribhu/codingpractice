package com.coding.pratice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PreProcessor {

	private static PreProcessor instance;
	private static int LCM = 1;
	private static List<List<Integer>> processes = new ArrayList<>();;

	private static Map<Integer, StringBuilder> preProcessorCache;

	private PreProcessor() {
	}

	public static synchronized PreProcessor getInstance() {
		if (instance == null) {
			instance = new PreProcessor();
		}
		return instance;
	}

	public static void update(List<Integer> list) {
		init(list);
	}

	public static void init(List<Integer> list) {
		
		processes.add(list);
		List<Integer> diffList = new ArrayList<>();
		for (List<Integer> process : processes) {
			diffList.add(process.get(0));
			LCM *= process.get(0);
			continue;
		}

		preProcessorCache = new ConcurrentHashMap<Integer, StringBuilder>(LCM);
		for (int i = 0; i < LCM; i++) {
			StringBuilder stBuild = new StringBuilder();
			for(int j = 0; j < diffList.size(); j++) {
				if(i % LCM == 0) {
					preProcessorCache.put(i, new StringBuilder("All"));
					break;
				} else if(i % diffList.get(j) == 0) {
					stBuild = preProcessorCache.get(i);
					stBuild.append("P"+j);
					preProcessorCache.put(i, stBuild);
				}
			}
		}
	}
}