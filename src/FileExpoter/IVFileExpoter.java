package FileExpoter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IVFileExpoter extends FileExpoter {

	public String format = ".csv";

	public IVFileExpoter(String path) {
		super(path);
	}

	@Override
	public StringBuffer inputFile() throws FileNotFoundException, IOException {
		String str;
		String[] strArray;
		StringBuffer buffer = new StringBuffer();

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			str = reader.readLine();

			while (str != null) {
				strArray = str.split(",");

				strArray[dateColumn] = strArray[dateColumn].replace("年", "");
				strArray[dateColumn] = strArray[dateColumn].replace("月", "");
				strArray[dateColumn] = strArray[dateColumn].replace("日", "");

				str = strArray[dateColumn] + "," + strArray[closeColumn];

				//取り込み条件に満たない場合はスキップする

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
