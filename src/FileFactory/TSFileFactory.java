package FileFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

import FileExpoter.IVFileExpoter;

public class TSFileFactory extends FileFactory {
	private IVFileExpoter exporter = null;

	public TSFileFactory() {
		super();
	}

	public final IVFileExpoter create(String path) {
		exporter = new IVFileExpoter(path);
		return new IVFileExpoter(path);
	}

	@Override
	public void export(String str) throws FileNotFoundException, IOException {
		exporter.export(str);
	}

}
