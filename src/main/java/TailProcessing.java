
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TailProcessing {

	public static void main(String[] args) {
		BufferedReader reader;
		try {
			
			validateInput(args);
			Integer count = Integer.parseInt(args[1]);
			reader = new BufferedReader(new FileReader(args[0]));

			List<String> copyList = new ArrayList<>(count);
			Integer lineCount = 0;
			String line = reader.readLine();

			while (line != null) {

				copyList.add(line);
				++lineCount;
				if (lineCount > count) {
					copyList.remove(0);
				}
				line = reader.readLine();
			}

			reader.close();

			copyList.forEach(a -> {
				System.out.println(a);
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean validateInput(String args[]) {
		if (args.length < 2) {
			System.out.println("2 Input argument required, 1. File name 2. Line count");
			return false;
		}
		if (!args[0].contains(".txt")) {
			System.out.println("Input File should be text file.");
			return false;
		}
		if (Integer.parseInt(args[1]) < 0) {
			System.out.println("Line Count cannot be negative.");
			return false;
		}
		return true;
	}

}
