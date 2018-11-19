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
		//����һ�쳣ip����		
		int unnomalipsum = NetRuleMenberShip.getNetRuleOne(NetRuleCala.getUnnomalMap().size());
		System.out.println("�쳣��IP����"+unnomalipsum);

//һ��ʱ���ڰ���������
		int packetsum = MyPcapPacketHandler.getIpsum();
		System.out.println("һ��ʱ���ڵ��ܰ�"+packetsum);

		// �����������ʵĻ�ȡ
		float avesever = NetRuleMenberShip.getServiceforddos(NetRuleCala.getAverageSever(CaptureCore.getNetsever()));

		// �����Ļ�ȡ25�е�CPU�仯�ʵ�ƽ��ֵ
		float cpugradientave = NetRuleMenberShip.getCPUService(WebRuleCala.getCPUGradientAve(AllInfo.getCpusever()));

		double netforwight2 = netweight.getNetWeight(unnomalipsum, packetsum, avesever, cpugradientave);

		if (netforwight2 > 1 && netforwight2 < 1.375) {
//			System.out.println("��ɫԤ��");
			return "��ɫԤ��";
//			UI.getNetBule().setBackground(Color.BLUE);
		} else if (netforwight2 >= 1.375 && netforwight2 <= 2.125 && packetsum != 3 && avesever != 3) {
//			System.out.println("��ɫԤ��");
			return "��ɫԤ��";
//			UI.getNetYellow().setBackground(Color.YELLOW);
		} else if ((netforwight2 >= 2.2085 && netforwight2 <= 3) && packetsum == 3 && avesever == 3) {
//			System.out.println("��ɫԤ��");
			return "��ɫԤ��";
//			UI.getNetRed().setBackground(Color.RED);
		} else {
//			System.out.println("����");
			return "����";
//		UI.getNetNormal().setBackground(Color.GREEN);
			
		}

	}

}
