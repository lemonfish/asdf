
package net.asdf.core.data;

public interface ResultConsumer<T> {

	void consume(T row);

}