package demo.tongdu_detail_transform;

import java.io.*;

/**
 * Created by leicheng on 17-7-31.
 */
public class Extra {

	public static void main(String[] args) {
		File file = new File("/home/leicheng/Desktop/tongdun_detail.txt");
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line;
			File detailFile = new File("/home/leicheng/Desktop/tongdun_detail_new.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(detailFile));
			while ((line = bf.readLine()) != null) {
				String[] split = line.split("@");
				if (split.length == 2) {
					String ruler = split[1];
					if (ruler != null && ruler.length() > 2) {
						bw.write(line);
						bw.newLine();
					}
				}
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
