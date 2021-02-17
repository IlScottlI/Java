package com.codingdojo.johnson.se.services;

import java.util.ArrayList;
import java.util.List;

public interface EntryService {
	 public static List<Entry> getAllEntries() {
	       List<Entry> entries = new ArrayList<>();
	        entries.add(new Entry("Farm",12,"success"));
	        return entries;
	 }
}
