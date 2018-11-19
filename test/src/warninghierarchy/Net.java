package warninghierarchy;

import cpu.AllInfo;
import jnetcapforcapture.CaptureCore;
import jnetcapforcapture.MyPcapPacketHandler;
import jnetcapforcapture.PacketMatch;
import layoutrule.NetRuleCala;
import layoutrule.WebRuleCala;
import membership.NetRuleMenberShip;
import weightcala.netweight;

public class Net {

	public static String  Netcalculationweight() {
		//规则一异常ip的数		
		int unnomalipsum = NetRuleMenberShip.getNetRuleOne(NetRuleCala.getUnnomalMap().size());
		System.out.println("异常的IP数量"+unnomalipsum);

//一定时间内包的总数量
		int packetsum = MyPcapPacketHandler.getIpsum();
		System.out.println("一段时间内的总包"+packetsum);

		// 规则三服务率的获取
		float avesever = NetRuleMenberShip.getServiceforddos(NetRuleCala.getAverageSever(CaptureCore.getNetsever()));

		// 规则四获取25中的CPU变化率的平均值
		float cpugradientave = NetRuleMenberShip.getCPUService(WebRuleCala.getCPUGradientAve(AllInfo.getCpusever()));

		double netforwight2 = netweight.getNetWeight(unnomalipsum, packetsum, avesever, cpugradientave);

		if (netforwight2 > 1 && netforwight2 < 1.375) {
//			System.out.println("蓝色预警");
			return "蓝色预警";
//			UI.getNetBule().setBackground(Color.BLUE);
		} else if (netforwight2 >= 1.375 && netforwight2 <= 2.125 && packetsum != 3 && avesever != 3) {
//			System.out.println("黄色预警");
			return "黄色预警";
//			UI.getNetYellow().setBackground(Color.YELLOW);
		} else if ((netforwight2 >= 2.2085 && netforwight2 <= 3) && packetsum == 3 && avesever == 3) {
//			System.out.println("红色预警");
			return "红色预警";
//			UI.getNetRed().setBackground(Color.RED);
		} else {
//			System.out.println("正常");
			return "正常";
//		UI.getNetNormal().setBackground(Color.GREEN);
			
		}

	}

}
