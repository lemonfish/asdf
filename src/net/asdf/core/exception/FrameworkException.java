
package net.asdf.core.exception;

public class FrameworkException extends AbstractException {

	private static final long serialVersionUID = 4331651806564377062L;

	public FrameworkException(String message) {
		super(message);
	}

	public FrameworkException(String format, Object... args) {
		super(format, args);
	}


}