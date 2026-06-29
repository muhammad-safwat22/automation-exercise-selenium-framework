package utilities;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Utility class for reading JSON test data from the project's resources folder.
 */
public final class JsonDataReader {

	private JsonDataReader() {
		// Prevent instantiation.
	}

	// ==========================================================
	// Cached Test Data
	// ==========================================================

	private static JsonObject testData;

	// ==========================================================
	// JSON Reader
	// ==========================================================

	/**
	 * Reads the JSON file from the resources folder. The file is loaded only once
	 * and then cached for the remaining test execution.
	 */
	public static JsonObject readJsonFromResource(String resourcePath) {

		if (testData != null) {
			return testData;
		}

		try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourcePath)) {

			if (is == null) {
				throw new RuntimeException("Resource not found: " + resourcePath);
			}

			try (InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {

				JsonElement json = JsonParser.parseReader(reader);
				testData = json.getAsJsonObject();

				return testData;
			}

		} catch (Exception e) {
			throw new RuntimeException("Failed to read JSON: " + resourcePath, e);
		}
	}
}