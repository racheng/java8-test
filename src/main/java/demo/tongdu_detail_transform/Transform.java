package demo.tongdu_detail_transform;

import com.alibaba.fastjson.JSON;
import demo.tongdu_detail_transform.bean.FraudApiResponse;
import demo.tongdu_detail_transform.bean.HitRule;

import java.io.*;
import java.util.HashSet;
import java.util.List;

/**
 * Created by leicheng on 17-7-31.
 */
public class Transform {

	public static void main(String[] args) {
		File file = new File("/home/leicheng/Desktop/tongdun_risk_info_new.txt");
		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line;
			File detailFile = new File("/home/leicheng/Desktop/tongdun_detail.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(detailFile));
			StringBuilder detail = new StringBuilder();
			while ((line = bf.readLine()) != null) {
				String[] split = line.split("@");
				if (split.length >= 3) {
					String id = split[0];
					String seqId = split[1];
					for (int i = 2; i < split.length; i++) {
						if (i == split.length - 1) {
							detail.append(split[i]);
						} else {
							detail.append(split[i]).append("@");
						}
					}
					HashSet<String> hitRulerSet = new HashSet<>();
					if (detail.length() > 0) {

						FraudApiResponse fraudApiResponse = JSON.parseObject(detail.toString(), FraudApiResponse.class);

						List<HitRule> hitRules = fraudApiResponse.getHit_rules();
						for (HitRule hitRule : hitRules) {
							hitRulerSet.add(hitRule.getName());
						}
						String hitRuler = "";
						for (String s : hitRulerSet) {
							hitRuler += s + ",";
						}
						if (hitRuler.length() > 0) {
							hitRuler = hitRuler.substring(0, hitRuler.length() - 1);
						}

						bw.write(id + "@" + hitRuler);
						bw.newLine();
						fraudApiResponse = null;
					}
				}
				detail.delete(0, detail.length());
			}
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
