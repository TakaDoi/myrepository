package FileFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

import FileExpoter.FileExpoter;

public class FileFactory {
	public FileFactory() {

	}

	public FileExpoter create(String path) throws FileNotFoundException, IOException {
		return null;
	}

	protected StringBuffer inputFile(FileExpoter file) throws FileNotFoundException, IOException {
		return file.inputFile();
	}

	public void export(String str) throws FileNotFoundException, IOException {
	}
}
