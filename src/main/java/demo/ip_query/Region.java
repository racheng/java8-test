package demo.ip_query;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leicheng on 17-6-20.
 */
public class Region {

	private final static Map<String, Integer> regionMap = new HashMap<>();
	private final static Map<String, Integer> provinceMap = new HashMap<>();


	public static Map<String, Integer> getRegionMap() {
		return regionMap;
	}

	public static Map<String, Integer> getProvinceMap() {
		return provinceMap;
	}

	static {
		provinceMap.put("云南", 530000);
		provinceMap.put("台湾", 710000);
		provinceMap.put("吉林", 220000);
		provinceMap.put("四川", 510000);
		provinceMap.put("安徽", 340000);
		provinceMap.put("山东", 370000);
		provinceMap.put("山西", 140000);
		provinceMap.put("广东", 440000);
		provinceMap.put("河南", 410000);
		provinceMap.put("河北", 130000);
		provinceMap.put("江西", 360000);
		provinceMap.put("江苏", 320000);
		provinceMap.put("湖南", 430000);
		provinceMap.put("湖北", 420000);
		provinceMap.put("海南", 460000);
		provinceMap.put("浙江", 330000);
		provinceMap.put("辽宁", 210000);
		provinceMap.put("贵州", 520000);
		provinceMap.put("福建", 350000);
		provinceMap.put("甘肃", 620000);
		provinceMap.put("黑龙江", 230000);
		provinceMap.put("青海", 630000);
		provinceMap.put("陕西", 610000);
		provinceMap.put("新疆", 650000);
		provinceMap.put("广西", 450000);
		provinceMap.put("宁夏", 640000);
		provinceMap.put("内蒙古", 150000);
		provinceMap.put("西藏区", 540000);
		provinceMap.put("上海", 310000);
		provinceMap.put("重庆", 500000);
		provinceMap.put("北京", 110000);
		provinceMap.put("天津", 120000);
		provinceMap.put("香港", 810000);
		provinceMap.put("澳门", 820000);

		regionMap.put("七台河市", 230900);
		regionMap.put("三亚市", 460200);
		regionMap.put("三明市", 350400);
		regionMap.put("三沙市", 460300);
		regionMap.put("三门峡市", 411200);
		regionMap.put("上饶市", 361100);
		regionMap.put("东莞市", 441900);
		regionMap.put("东营市", 370500);
		regionMap.put("中卫市", 640500);
		regionMap.put("中山市", 442000);
		regionMap.put("临夏州", 622900);
		regionMap.put("临汾市", 141000);
		regionMap.put("临沂市", 371300);
		regionMap.put("临沧市", 530900);
		regionMap.put("丹东市", 210600);
		regionMap.put("丽水市", 331100);
		regionMap.put("丽江市", 530700);
		regionMap.put("乌兰察布市", 150900);
		regionMap.put("乌海市", 150300);
		regionMap.put("乌鲁木齐市", 650100);
		regionMap.put("乐山市", 511100);
		regionMap.put("九江市", 360400);
		regionMap.put("云浮市", 445300);
		regionMap.put("亳州市", 341600);
		regionMap.put("伊春市", 230700);
		regionMap.put("伊犁", 654000);
		regionMap.put("佛山市", 440600);
		regionMap.put("佳木斯市", 230800);
		regionMap.put("保定市", 130600);
		regionMap.put("保山市", 530500);
		regionMap.put("信阳市", 411500);
		regionMap.put("儋州市", 460400);
		regionMap.put("克孜勒苏柯尔州", 653000);
		regionMap.put("克拉玛依市", 650200);
		regionMap.put("六安市", 341500);
		regionMap.put("六盘水市", 520200);
		regionMap.put("兰州市", 620100);
		regionMap.put("兴安盟", 152200);
		regionMap.put("内江市", 511000);
		regionMap.put("凉山州", 513400);
		regionMap.put("包头市", 150200);
		regionMap.put("北海市", 450500);
		regionMap.put("十堰市", 420300);
		regionMap.put("南京市", 320100);
		regionMap.put("南充市", 511300);
		regionMap.put("南宁市", 450100);
		regionMap.put("南平市", 350700);
		regionMap.put("南昌市", 360100);
		regionMap.put("南通市", 320600);
		regionMap.put("南阳市", 411300);
		regionMap.put("博尔塔拉州", 652700);
		regionMap.put("厦门市", 350200);
//		regionMap.put("县", 500200);
		regionMap.put("双鸭山市", 230500);
		regionMap.put("台州市", 331000);
		regionMap.put("合肥市", 340100);
		regionMap.put("吉安市", 360800);
		regionMap.put("吉林市", 220200);
		regionMap.put("吐鲁番市", 650400);
		regionMap.put("吕梁市", 141100);
		regionMap.put("吴忠市", 640300);
		regionMap.put("周口市", 411600);
		regionMap.put("呼伦贝尔市", 150700);
		regionMap.put("呼和浩特市", 150100);
		regionMap.put("和田地区", 653200);
		regionMap.put("咸宁市", 421200);
		regionMap.put("咸阳市", 610400);
		regionMap.put("哈密地区", 650500);
		regionMap.put("哈尔滨市", 230100);
		regionMap.put("唐山市", 130200);
		regionMap.put("商丘市", 411400);
		regionMap.put("商洛市", 611000);
		regionMap.put("喀什地区", 653100);
		regionMap.put("嘉兴市", 330400);
		regionMap.put("嘉峪关市", 620200);
		regionMap.put("四平市", 220300);
		regionMap.put("固原市", 640400);
		regionMap.put("塔城地区", 654200);
		regionMap.put("大兴安岭地区", 232700);
		regionMap.put("大同市", 140200);
		regionMap.put("大庆市", 230600);
		regionMap.put("大理州", 532900);
		regionMap.put("大连市", 210200);
		regionMap.put("天水市", 620500);
		regionMap.put("太原市", 140100);
		regionMap.put("威海市", 371000);
		regionMap.put("娄底市", 431300);
		regionMap.put("孝感市", 420900);
		regionMap.put("宁德市", 350900);
		regionMap.put("宁波市", 330200);
		regionMap.put("安庆市", 340800);
		regionMap.put("安康市", 610900);
		regionMap.put("安阳市", 410500);
		regionMap.put("安顺市", 520400);
		regionMap.put("定西市", 621100);
		regionMap.put("宜宾市", 511500);
		regionMap.put("宜昌市", 420500);
		regionMap.put("宜春市", 360900);
		regionMap.put("宝鸡市", 610300);
		regionMap.put("宣城市", 341800);
		regionMap.put("宿州市", 341300);
		regionMap.put("宿迁市", 321300);
		regionMap.put("山南市", 540500);
		regionMap.put("岳阳市", 430600);
		regionMap.put("崇左市", 451400);
		regionMap.put("巴中市", 511900);
		regionMap.put("巴彦淖尔市", 150800);
		regionMap.put("巴音郭楞州", 652800);
		regionMap.put("市辖区", 110100);
		regionMap.put("常州市", 320400);
		regionMap.put("常德市", 430700);
		regionMap.put("平凉市", 620800);
		regionMap.put("平顶山市", 410400);
		regionMap.put("广元市", 510800);
		regionMap.put("广安市", 511600);
		regionMap.put("广州市", 440100);
		regionMap.put("庆阳市", 621000);
		regionMap.put("廊坊", 131000);
		regionMap.put("延安市", 610600);
		regionMap.put("延边州", 222400);
		regionMap.put("开封市", 410200);
		regionMap.put("张家口市", 130700);
		regionMap.put("张家界市", 430800);
		regionMap.put("张掖市", 620700);
		regionMap.put("徐州市", 320300);
		regionMap.put("德宏州", 533100);
		regionMap.put("德州市", 371400);
		regionMap.put("德阳市", 510600);
		regionMap.put("忻州市", 140900);
		regionMap.put("怀化市", 431200);
		regionMap.put("怒江州", 533300);
		regionMap.put("恩施州", 422800);
		regionMap.put("惠州市", 441300);
		regionMap.put("成都市", 510100);
		regionMap.put("扬州市", 321000);
		regionMap.put("承德市", 130800);
		regionMap.put("抚州市", 361000);
		regionMap.put("抚顺市", 210400);
		regionMap.put("拉萨市", 540100);
		regionMap.put("揭阳市", 445200);
		regionMap.put("攀枝花市", 510400);
		regionMap.put("文山州", 532600);
		regionMap.put("新乡市", 410700);
		regionMap.put("新余市", 360500);
		regionMap.put("无锡市", 320200);
		regionMap.put("日喀则市", 540200);
		regionMap.put("日照市", 371100);
		regionMap.put("昆明市", 530100);
		regionMap.put("昌吉州", 652300);
		regionMap.put("昌都市", 540300);
		regionMap.put("昭通市", 530600);
		regionMap.put("晋中市", 140700);
		regionMap.put("晋城市", 140500);
		regionMap.put("普洱市", 530800);
		regionMap.put("景德镇市", 360200);
		regionMap.put("曲靖市", 530300);
		regionMap.put("朔州市", 140600);
		regionMap.put("朝阳市", 211300);
		regionMap.put("本溪市", 210500);
		regionMap.put("来宾市", 451300);
		regionMap.put("杭州市", 330100);
		regionMap.put("松原市", 220700);
		regionMap.put("林芝市", 540400);
		regionMap.put("果洛州", 632600);
		regionMap.put("枣庄市", 370400);
		regionMap.put("柳州市", 450200);
		regionMap.put("株洲市", 430200);
		regionMap.put("桂林市", 450300);
		regionMap.put("梅州市", 441400);
		regionMap.put("梧州市", 450400);
		regionMap.put("楚雄州", 532300);
		regionMap.put("榆林市", 610800);
		regionMap.put("武威市", 620600);
		regionMap.put("武汉市", 420100);
		regionMap.put("毕节地区", 520500);
		regionMap.put("永州市", 431100);
		regionMap.put("汉中市", 610700);
		regionMap.put("汕头市", 440500);
		regionMap.put("汕尾市", 441500);
		regionMap.put("江门市", 440700);
		regionMap.put("池州市", 341700);
		regionMap.put("沈阳市", 210100);
		regionMap.put("沧州市", 130900);
		regionMap.put("河池市", 451200);
		regionMap.put("河源市", 441600);
		regionMap.put("泉州市", 350500);
		regionMap.put("泰安市", 370900);
		regionMap.put("泰州市", 321200);
		regionMap.put("泸州市", 510500);
		regionMap.put("洛阳市", 410300);
		regionMap.put("济南市", 370100);
		regionMap.put("济宁市", 370800);
		regionMap.put("海东市", 630200);
		regionMap.put("海北州", 632200);
		regionMap.put("海南州", 632500);
		regionMap.put("海口市", 460100);
		regionMap.put("海西州", 632800);
		regionMap.put("淄博市", 370300);
		regionMap.put("淮北市", 340600);
		regionMap.put("淮南市", 340400);
		regionMap.put("淮安市", 320800);
		regionMap.put("深圳市", 440300);
		regionMap.put("清远市", 441800);
		regionMap.put("温州市", 330300);
		regionMap.put("渭南市", 610500);
		regionMap.put("湖州市", 330500);
		regionMap.put("湘潭市", 430300);
		regionMap.put("湘西州", 433100);
		regionMap.put("湛江市", 440800);
		regionMap.put("滁州市", 341100);
		regionMap.put("滨州市", 371600);
		regionMap.put("漯河市", 411100);
		regionMap.put("漳州市", 350600);
		regionMap.put("潍坊市", 370700);
		regionMap.put("潮州市", 445100);
		regionMap.put("濮阳市", 410900);
		regionMap.put("烟台市", 370600);
		regionMap.put("焦作市", 410800);
		regionMap.put("牡丹江市", 231000);
		regionMap.put("玉林市", 450900);
		regionMap.put("玉树州", 632700);
		regionMap.put("玉溪市", 530400);
		regionMap.put("珠海市", 440400);
		regionMap.put("甘南州", 623000);
		regionMap.put("甘孜州", 513300);
		regionMap.put("白城市", 220800);
		regionMap.put("白山市", 220600);
		regionMap.put("白银市", 620400);
		regionMap.put("百色市", 451000);
		regionMap.put("益阳市", 430900);
		regionMap.put("盐城市", 320900);
		regionMap.put("盘锦市", 211100);
//		regionMap.put("省直辖县级行政区划", 139000);
		regionMap.put("眉山市", 511400);
		regionMap.put("石嘴山市", 640200);
		regionMap.put("石家庄市", 130100);
		regionMap.put("福州市", 350100);
		regionMap.put("秦皇岛市", 130300);
		regionMap.put("红河州", 532500);
		regionMap.put("绍兴市", 330600);
		regionMap.put("绥化市", 231200);
		regionMap.put("绵阳市", 510700);
		regionMap.put("聊城市", 371500);
		regionMap.put("肇庆市", 441200);
//		regionMap.put("自治区直辖县级行政区划", 659000);
		regionMap.put("自贡市", 510300);
		regionMap.put("舟山市", 330900);
		regionMap.put("芜湖市", 340200);
		regionMap.put("苏州市", 320500);
		regionMap.put("茂名市", 440900);
		regionMap.put("荆州市", 421000);
		regionMap.put("荆门市", 420800);
		regionMap.put("莆田市", 350300);
		regionMap.put("莱芜市", 371200);
		regionMap.put("菏泽市", 371700);
		regionMap.put("萍乡市", 360300);
		regionMap.put("营口市", 210800);
		regionMap.put("葫芦岛市", 211400);
		regionMap.put("蚌埠市", 340300);
		regionMap.put("衡水市", 131100);
		regionMap.put("衡阳市", 430400);
		regionMap.put("衢州市", 330800);
		regionMap.put("襄阳市", 420600);
		regionMap.put("西双版纳州", 532800);
		regionMap.put("西宁市", 630100);
		regionMap.put("西安市", 610100);
		regionMap.put("许昌市", 411000);
		regionMap.put("贵港市", 450800);
		regionMap.put("贵阳市", 520100);
		regionMap.put("贺州市", 451100);
		regionMap.put("资阳市", 512000);
		regionMap.put("赣州市", 360700);
		regionMap.put("赤峰市", 150400);
		regionMap.put("辽源市", 220400);
		regionMap.put("辽阳市", 211000);
		regionMap.put("达州市", 511700);
		regionMap.put("运城市", 140800);
		regionMap.put("连云港市", 320700);
		regionMap.put("迪庆州", 533400);
		regionMap.put("通化市", 220500);
		regionMap.put("通辽市", 150500);
		regionMap.put("遂宁市", 510900);
		regionMap.put("遵义市", 520300);
		regionMap.put("邢台市", 130500);
		regionMap.put("那曲地区", 542400);
		regionMap.put("邯郸市", 130400);
		regionMap.put("邵阳市", 430500);
		regionMap.put("郑州市", 410100);
		regionMap.put("郴州市", 431000);
		regionMap.put("鄂尔多斯市", 150600);
		regionMap.put("鄂州市", 420700);
		regionMap.put("酒泉市", 620900);
		regionMap.put("金华市", 330700);
		regionMap.put("金昌市", 620300);
		regionMap.put("钦州市", 450700);
		regionMap.put("铁岭市", 211200);
		regionMap.put("铜仁地区", 520600);
		regionMap.put("铜川市", 610200);
		regionMap.put("铜陵市", 340700);
		regionMap.put("银川市", 640100);
		regionMap.put("锡林郭勒盟", 152500);
		regionMap.put("锦州市", 210700);
		regionMap.put("镇江市", 321100);
		regionMap.put("长春市", 220100);
		regionMap.put("长沙市", 430100);
		regionMap.put("长治市", 140400);
		regionMap.put("阜新市", 210900);
		regionMap.put("阜阳市", 341200);
		regionMap.put("防城港市", 450600);
		regionMap.put("阳江市", 441700);
		regionMap.put("阳泉市", 140300);
		regionMap.put("阿克苏地区", 652900);
		regionMap.put("阿勒泰地区", 654300);
		regionMap.put("阿坝州", 513200);
		regionMap.put("阿拉善盟", 152900);
		regionMap.put("阿里地区", 542500);
		regionMap.put("陇南市", 621200);
		regionMap.put("随州市", 421300);
		regionMap.put("雅安市", 511800);
		regionMap.put("青岛市", 370200);
		regionMap.put("鞍山市", 210300);
		regionMap.put("韶关市", 440200);
		regionMap.put("马鞍山市", 340500);
		regionMap.put("驻马店市", 411700);
		regionMap.put("鸡西市", 230300);
		regionMap.put("鹤壁市", 410600);
		regionMap.put("鹤岗市", 230400);
		regionMap.put("鹰潭市", 360600);
		regionMap.put("黄冈市", 421100);
		regionMap.put("黄南州", 632300);
		regionMap.put("黄山市", 341000);
		regionMap.put("黄石市", 420200);
		regionMap.put("黑河市", 231100);
		regionMap.put("黔东南州", 522600);
		regionMap.put("黔南州", 522700);
		regionMap.put("黔西南州", 522300);
		regionMap.put("齐齐哈尔市", 230200);
		regionMap.put("龙岩市", 350800);
	}
}
