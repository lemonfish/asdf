
package net.asdf.core.exception;

public class AbstractException extends RuntimeException {

	private static final long serialVersionUID = -5375234726829388441L;

	protected String message;

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AbstractException(String message) {
		this.message = message;
	}

	public AbstractException(String format, Object... args) {
		this.message = String.format(format, args);
	}
}