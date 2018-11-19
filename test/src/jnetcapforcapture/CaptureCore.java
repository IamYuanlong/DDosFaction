package jnetcapforcapture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;


import clearthevalue.Clear;
import layoutrule.NetRuleCala;
import layoutrule.WebRuleCala;
import warninghierarchy.Net;
import warninghierarchy.Web;

public class CaptureCore extends Thread {
	private static Pcap pcap;

	// ��ȡ��ֵ�����ݴ洢��

	private static List<Float> netsever = new ArrayList<Float>();
	private static List<Float> websever = new ArrayList<Float>();

	// ʱ���
	private static long start = System.currentTimeMillis();
	private static long start2 = System.currentTimeMillis();
	private static long start3 = System.currentTimeMillis();

	private static boolean s = true;

	// ǰ25��Ļ�ȡhttp��ֵ
	private static boolean hs = true;
	// ��25��Ļ�ȡip
	// private static boolean is = true;

	static double d[] = new double[25];
	private static MyPcapPacketHandler<Object> myhandler = new MyPcapPacketHandler<Object>();// ���������
	private static MyHandlePacketHttp<Object> myhandlerhttp = new MyHandlePacketHttp<Object>();// ���������

	@Override
	public void run() {

		// TODO Auto-generated method stub
		try {
			while (true) {

				List<PcapIf> devs = new ArrayList<PcapIf>();
				StringBuilder errsb = new StringBuilder();
				int r = Pcap.findAllDevs(devs, errsb);
				int snaplen = Pcap.DEFAULT_SNAPLEN;// ����65536
				int flags = Pcap.MODE_PROMISCUOUS;// ����ģʽ
				int timeout = 1;
				PcapIf device = devs.get(1);

				if (r != Pcap.OK || devs.isEmpty()) {
					System.out.println("δ��ȡ�б�");
				}

				pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, errsb); // ������

				s = true;

				if (hs) {
					CaptureCore.startCaptureAt();
				} else {
					CaptureCore.startCaptureAtForHttp();
					Clear.clearValue();// �����е�ֵ���
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void startCaptureAtForHttp() throws IOException, Exception {// ѡ��һ����������ץ��

		while (s) {
			// ��ʼץ��
			pcap.dispatch(1, myhandlerhttp, "Jnetcap");

			if ((System.currentTimeMillis() - start) >= 5000) {
				start = System.currentTimeMillis();
				// System.out.println("��һ�λ�ȡֵ ");
				// float s1 =
				// NetRuleCala.getNetSever(PacketMatch.getCountacceptpack(),
				// PacketMatch.getCountsendpack());
				// netsever.add(s1);
				// System.out.println("��·������������"+s1);
				// System.out.println(s1);

				// PacketMatch.getPacketHttp(MyPcapPacketHandler.getPack());

				float s2 = WebRuleCala.getHttpServer(PacketMatch.getHttprequestconut(),
						PacketMatch.getHttpresponsecount());
				websever.add(s2);
				// System.out.println("Ӧ�ò�����������"+s2);
				// System.out.println("���http������"+PacketMatch.getHttpsum());
			}

			if (start2 + 5 * 5000 <= System.currentTimeMillis() && websever.size() >= 5) {
				start2 = System.currentTimeMillis();
				// System.out.println("������");
				// Net.Netcalculationweight();

				Web.Applicationcalculationweight();
				s = false;
				// System.out.println("������");

			}
		}
		pcap.close();
		hs = true;
	}

	public static void startCaptureAt() throws IOException, Exception {// ѡ��һ����������ץ��

		while (s) {
			// ��ʼץ��
			pcap.dispatch(1, myhandler, "Jnetcap");

			if ((System.currentTimeMillis() - start) >= 5000) {
				start = System.currentTimeMillis();
				// System.out.println("��һ�λ�ȡֵ ");
				float s1 = NetRuleCala.getNetSever(MyPcapPacketHandler.getCountacceptpack(),
						MyPcapPacketHandler.getCountsendpack());
				netsever.add(s1);

			}
			int i = 0;
			if ((System.currentTimeMillis() - start3) >= 1000 && i <= 25) {

				d[i] = MyPcapPacketHandler.getIpsum();
				i++;

			}

			if (start2 + 5 * 5000 <= System.currentTimeMillis() && netsever.size() >= 5 && i <= 25) {
				start2 = System.currentTimeMillis();
				// System.out.println("������1");
				 Web.Applicationcalculationweight();
				s = false;
				// System.out.println("������1");
			}
		}
		pcap.close();
		hs = false;

	}

	public static double[] getD() {
		return d;
	}

	public static void setD(double[] d) {
		CaptureCore.d = d;
	}

	public static List<Float> getNetsever() {
		return netsever;
	}

	public static void setNetsever(List<Float> netsever) {
		CaptureCore.netsever = netsever;
	}

	public static List<Float> getWebsever() {
		return websever;
	}

	public static void setWebsever(List<Float> websever) {
		CaptureCore.websever = websever;
	}


}
