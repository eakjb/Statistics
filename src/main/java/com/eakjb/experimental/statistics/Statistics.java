package com.eakjb.experimental.statistics;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Statistics {

	public static void main(String[] args) throws IOException {		
		Reader in = new FileReader(Statistics.class.getClassLoader().getResource("test.csv").getPath());
		
		List<NDInstance> objs = new ArrayList<NDInstance>();
		List<CSVRecord> records = CSVFormat.EXCEL.parse(in).getRecords();
		
		NDObject architype = new NDObject("Architype");
		List<Dimension> dimensions = new ArrayList<Dimension>();
		
		for (int y=1;y<records.get(0).size();y++) {
			Dimension d = new Dimension(records.get(0).get(y),Double.parseDouble(records.get(1).get(y)));
			dimensions.add(d);
			architype.put(d, Double.parseDouble(records.get(2).get(y)));
		}
		
		for (int x=3;x<records.size();x++) {
			NDInstance n = new NDInstance(records.get(x).get(0),architype);
			for (int y=1;y<records.get(x).size();y++) {
				n.put(dimensions.get(y-1),Double.parseDouble(records.get(x).get(y)));
			}
			objs.add(n);
		}
		
		Collections.sort(objs);
		
		for (NDObject o : objs) {
			System.out.println(o);
		}
	}

}
