package warninghierarchy;


import java.awt.Color;

import UI.UI;
import cpu.AllInfo;
import jnetcapforcapture.CaptureCore;
import jnetcapforcapture.MyPcapPacketHandler;
import jnetcapforcapture.PacketMatch;
import layoutrule.WebRuleCala;
import membership.WebMenberShip;
import weightcala.webweight;

public class Web {

	public static void Applicationcalculationweight() {
		// 规则一获取anrc值得隶属度
		int AnrcAve = WebMenberShip.getWebRuleOne(WebRuleCala.getAnrcAve(PacketMatch.getHttpresponsecount(), MyPcapPacketHandler.getMapfordosip().size()));
		// 规则二服务率
		float httpServerAve = WebMenberShip.getWebRuleTwo(WebRuleCala.getHttpServerAve(CaptureCore.getWebsever()));
		// 规则三cpu的获取
		float cpuGradientAve = WebMenberShip.getCPUService(WebRuleCala.getCPUGradientAve(AllInfo.getCpusever()));

		double apllicationforwight21 = webweight.getWebWeight(AnrcAve, httpServerAve, cpuGradientAve);

		if (AnrcAve != 3 && httpServerAve == 1 && cpuGradientAve != 3 && apllicationforwight21 >= 1
				&& apllicationforwight21 < 1.418) {
//			 return "蓝色预警";
//			System.out.println("蓝色预警");
			UI.getWebBule().setBackground(Color.BLUE);
			
		} else if ((AnrcAve == 2 && httpServerAve == 1 && apllicationforwight21 < 2.109
				&& apllicationforwight21 >= 1.418)
				|| (httpServerAve == 2 && apllicationforwight21 < 2.109 && apllicationforwight21 >= 1.418)) {
			UI.getWebYellow().setBackground(Color.YELLOW);
//			 return "黄色预警";
//			System.out.println("黄色预警");
		} else if ((AnrcAve == 3 && apllicationforwight21 >= 2.109 && apllicationforwight21 <= 3)
				|| (httpServerAve == 3 && apllicationforwight21 >= 2.109 && apllicationforwight21 <= 3) || (AnrcAve != 1
						&& httpServerAve != 1 && apllicationforwight21 >= 2.109 && apllicationforwight21 <= 3)) {
UI.getWebRed().setBackground(Color.RED);
//			 return "红色预警";
//			System.out.println("红色预警");
		} else {
			UI.getWebNormal().setBackground(Color.GREEN);
//			 return "正常";
//			System.out.println("正常");
		}
	}

}
