package FileExpoter;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public abstract class FileExpoter {
	protected String path;
	protected int dateColumn;
	protected int closeColumn;

	public FileExpoter(String path) {
		this.path = path;
	}

	public void export(String fileName) throws FileNotFoundException, IOException {
		String outputFile;

		outputFile = "./" + fileName + getFormat();
		PrintWriter p = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile),"utf-8")));

		p.println(inputFile());

		p.close();
		System.out.println("CSVファイルを出力しました。");
		System.out.println("出力ファイル名：" + fileName);
	}

	public abstract StringBuffer inputFile() throws FileNotFoundException, IOException;

	public abstract String getFormat();

}
