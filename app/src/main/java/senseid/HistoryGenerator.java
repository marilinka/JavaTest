package senseid;

import com.example.MM;

/**
 * @author Rostyslav Lesovyi
 */
public class HistoryGenerator {

	private static final int RECORDS_COUNT = 100;
	private static final long TIME_DIFF = 60 * 60 * 1000;
	private static final String ROOT = "d:/sense_id/history/";

	public static void main(final String[] args) {
		long timestamp = System.currentTimeMillis();

		MM.mkdirs(ROOT);

		for (int index = 0; index < RECORDS_COUNT; ++index) {
			String file = ROOT + String.format("%016d", timestamp - TIME_DIFF * index);

			MM.write(file, String.format("{\"userName\":\"User Name #%d\",\"userId\":\"User Id #%d\"}", index, index));
		}
	}

}
