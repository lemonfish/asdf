
package net.asdf.core.exception;

public class SysException extends AbstractException {

	private static final long serialVersionUID = 8067136282500214194L;

	public SysException(String message) {
		super(message);
	}

	public SysException(String format, Object... args) {
		super(format, args);
	}
}
