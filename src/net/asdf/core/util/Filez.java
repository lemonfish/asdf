

package net.asdf.core.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;

public class Filez {

	public static Predicate<Path> ext(final String suffix) {
		return path -> {
			return !Files.isDirectory(path) && path.getFileName().toString().toLowerCase().endsWith(suffix.toLowerCase());
		};
	}
}