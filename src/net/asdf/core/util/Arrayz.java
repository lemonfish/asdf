package net.asdf.core.util;

import java.util.ArrayList;

public class Arrayz {
	@SafeVarargs
	public static <T>  ArrayList<T> add(ArrayList<T> arrayList, T ... items){
		for(T item : items) {
			arrayList.add(item);
		}
		return arrayList;
	}
}
