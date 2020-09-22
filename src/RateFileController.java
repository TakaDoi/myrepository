import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import FileFactory.FileFactory;
import FileFactory.IVFileFactory;
import FileFactory.TSFileFactory;
import FileFactory.YFFileFactory;

public class RateFileController {
	String inputAppPath = null;
	String exportFileName = null;
	FileFactory factory;

	public RateFileController() {
	}

	public void Controller(String exportFile) throws FileNotFoundException, IOException {

		switch (exportFile) {
			case "investing":
				factory = new IVFileFactory();
				break;
			case "tradeStation":
				factory = new TSFileFactory();
				break;
			case "yahooFinance":
				factory = new YFFileFactory();
				break;
			default:
				factory = null;
				break;
		}

		inputAppPath = "data\\" +  exportFile;

		File file = new File(inputAppPath);
		File files[] = file.listFiles();

		System.out.println("[ " + inputAppPath + " ]からファイルを読み込みます");


		for(File dataFile : files) {
			exportFileName = dataFile.getPath().replace(".txt", "");
			exportFileName = exportFileName.replace(inputAppPath, "");

			factory.create(dataFile.getPath());
			factory.export("export/" + exportFileName);
		}

	}

}
