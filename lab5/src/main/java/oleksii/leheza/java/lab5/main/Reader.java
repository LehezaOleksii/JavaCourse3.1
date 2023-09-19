package oleksii.leheza.java.lab5.main;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Reader {

	public List<String> read(String fileName) {
		String delimiter = "/n";
		try {
			return Files.lines(getAbsoluteFilePath(fileName)).flatMap(line -> List.of(line.split(delimiter)).stream())
					.collect(Collectors.toList());
		} catch (IOException | NullPointerException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Path getAbsoluteFilePath(String fileName) {
		if (fileName == null) {
			throw new NullPointerException();
		}
		try {
			return Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}