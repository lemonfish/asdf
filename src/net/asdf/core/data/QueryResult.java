


package net.asdf.core.data;

public interface QueryResult<T> {

	T get();

	ResultProducer<T> stream();

}
