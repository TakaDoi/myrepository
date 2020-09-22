package FileExpoter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TSFileExpoter extends FileExpoter {
	public String format = ".csv";

	public TSFileExpoter(String path) {
		super(path);
	}

	@Override
	public StringBuffer inputFile() throws FileNotFoundException, IOException {
		String str;
		String[] strArray;
		String[] dateArray;
		StringBuffer buffer = new StringBuffer();

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			str = reader.readLine();

			while (str != null) {
				strArray = str.split(",");

				dateArray = strArray[dateColumn].split("/");
				if (dateArray.length == 3) {
					strArray[dateColumn] = dateArray[2] + dateArray[0] + dateArray[1];
				}

				str = strArray[dateColumn] + "," + strArray[closeColumn];

				buffer.append(str + System.getProperty("line.separator"));
				str = reader.readLine();
			}
		}
		return buffer;
	}

	@Override
	public String getFormat() {
		return format;
	}

}
