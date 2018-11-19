package jnetcapforcapture;



import java.util.HashMap;
import java.util.Map;

import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.JPacketHandler;
import org.jnetpcap.protocol.network.Ip4;


public class MyPcapPacketHandler<Object> implements JPacketHandler<Object> {
//	
Ip4 Ip=new Ip4();
int sum=0;
private static int ipsum;
// �������յ��İ�������
private static int countacceptpack;
// ���Ͱ�������
private static int countsendpack;

// ����http����Ӧ�ı�������
private static int httpresponsecount;
// ����http����Ӧ�������ĵ�����
private static int httprequestconut;

// ����������������ͳ��
private static int udpsum;
private static int tcpsum;

private static int httpsum;



public int getSum() {
	return sum;
}


public void setSum(int sum) {
	this.sum = sum;
}


public static int getIpsum() {
	return ipsum;
}


public static void setIpsum(int ipsum) {
	MyPcapPacketHandler.ipsum = ipsum;
}


public static int getCountacceptpack() {
	return countacceptpack;
}


public static void setCountacceptpack(int countacceptpack) {
	MyPcapPacketHandler.countacceptpack = countacceptpack;
}


public static int getCountsendpack() {
	return countsendpack;
}


public static void setCountsendpack(int countsendpack) {
	MyPcapPacketHandler.countsendpack = countsendpack;
}


public static int getHttpresponsecount() {
	return httpresponsecount;
}


public static void setHttpresponsecount(int httpresponsecount) {
	MyPcapPacketHandler.httpresponsecount = httpresponsecount;
}


public static int getHttprequestconut() {
	return httprequestconut;
}


public static void setHttprequestconut(int httprequestconut) {
	MyPcapPacketHandler.httprequestconut = httprequestconut;
}


public static int getUdpsum() {
	return udpsum;
}


public static void setUdpsum(int udpsum) {
	MyPcapPacketHandler.udpsum = udpsum;
}


public static int getTcpsum() {
	return tcpsum;
}


public static void setTcpsum(int tcpsum) {
	MyPcapPacketHandler.tcpsum = tcpsum;
}


public static int getHttpsum() {
	return httpsum;
}


public static void setHttpsum(int httpsum) {
	MyPcapPacketHandler.httpsum = httpsum;
}


public static Map<String, Integer> getMapfordosip() {
	return mapfordosip;
}


public static void setMapfordosip(Map<String, Integer> mapfordosip) {
	MyPcapPacketHandler.mapfordosip = mapfordosip;
}


// ���ֵ�ip,�Լ����յ��İ�������
private static Map<String, Integer> mapfordosip = new HashMap<String, Integer>();


	@Override
	public void nextPacket(JPacket packet, Object arg) {
//		pack.add(packet);
		// TODO Auto-generated method stub
//		PacketMatch packetMatch = PacketMatch.getInstance();
		
		if (packet.hasHeader(Ip)) {
			sum++;
//			System.out.println(sum);
//		}
		packet.getHeader(Ip);
		byte[] sIP = new byte[4], dIP = new byte[4];
		sIP = Ip.source();
		dIP = Ip.destination();

		String srcIP = org.jnetpcap.packet.format.FormatUtils.ip(sIP);
		String dstIP = org.jnetpcap.packet.format.FormatUtils.ip(dIP);

		// ��ȡIP�Ͷ�Ӧ��IP��������

		// System.out.println(string);
		// ������ip���Ǳ�����ip����ôͳ��ip��Ӧ��ip������
		if (!srcIP.contains(PacketMatch.getIp())) {
			if (mapfordosip.get(srcIP) == null)
				mapfordosip.put(srcIP, 1);
			else
				mapfordosip.replace(srcIP, mapfordosip.get(srcIP) + 1);
		}
		// �жϽ��պͷ��͵������İ�
		// System.out.println("dasfsafsacasfsa");
		if (PacketMatch.getIp().contains(dstIP)) {
			// ��ȡ���հ�������
			countacceptpack++;
			// System.out.println("��ȡ����������"+countacceptpack);

		} else if (PacketMatch.getIp().contains(srcIP)) {
			countsendpack++;
			// System.out.println("���Ͱ���������"+countsendpack);
		}
		}
//		packetMatch.handlePacket(packet);
		
//		packetMatch.handlePacketHttp(packet);
		
		

	


	}


}