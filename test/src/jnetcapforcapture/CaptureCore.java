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

	// 获取的值得数据存储类

	private static List<Float> netsever = new ArrayList<Float>();
	private static List<Float> websever = new ArrayList<Float>();

	// 时间戳
	private static long start = System.currentTimeMillis();
	private static long start2 = System.currentTimeMillis();
	private static long start3 = System.currentTimeMillis();

	private static boolean s = true;

	// 前25秒的获取http的值
	private static boolean hs = true;
	// 后25秒的获取ip
	// private static boolean is = true;

	static double d[] = new double[25];
	private static MyPcapPacketHandler<Object> myhandler = new MyPcapPacketHandler<Object>();// 处理包的类
	private static MyHandlePacketHttp<Object> myhandlerhttp = new MyHandlePacketHttp<Object>();// 处理包的类

	@Override
	public void run() {

		// TODO Auto-generated method stub
		try {
			while (true) {

				List<PcapIf> devs = new ArrayList<PcapIf>();
				StringBuilder errsb = new StringBuilder();
				int r = Pcap.findAllDevs(devs, errsb);
				int snaplen = Pcap.DEFAULT_SNAPLEN;// 长度65536
				int flags = Pcap.MODE_PROMISCUOUS;// 混杂模式
				int timeout = 1;
				PcapIf device = devs.get(1);

				if (r != Pcap.OK || devs.isEmpty()) {
					System.out.println("未获取列表");
				}

				pcap = Pcap.openLive(device.getName(), snaplen, flags, timeout, errsb); // 打开网卡

				s = true;

				if (hs) {
					CaptureCore.startCaptureAt();
				} else {
					CaptureCore.startCaptureAtForHttp();
					Clear.clearValue();// 将所有的值清空
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

	public static void startCaptureAtForHttp() throws IOException, Exception {// 选择一个网卡开启抓包

		while (s) {
			// 开始抓包
			pcap.dispatch(1, myhandlerhttp, "Jnetcap");

			if ((System.currentTimeMillis() - start) >= 5000) {
				start = System.currentTimeMillis();
				// System.out.println("第一次获取值 ");
				// float s1 =
				// NetRuleCala.getNetSever(PacketMatch.getCountacceptpack(),
				// PacketMatch.getCountsendpack());
				// netsever.add(s1);
				// System.out.println("网路层的输出服务率"+s1);
				// System.out.println(s1);

				// PacketMatch.getPacketHttp(MyPcapPacketHandler.getPack());

				float s2 = WebRuleCala.getHttpServer(PacketMatch.getHttprequestconut(),
						PacketMatch.getHttpresponsecount());
				websever.add(s2);
				// System.out.println("应用层的输出服务率"+s2);
				// System.out.println("获得http的数量"+PacketMatch.getHttpsum());
			}

			if (start2 + 5 * 5000 <= System.currentTimeMillis() && websever.size() >= 5) {
				start2 = System.currentTimeMillis();
				// System.out.println("输出结果");
				// Net.Netcalculationweight();

				Web.Applicationcalculationweight();
				s = false;
				// System.out.println("输出结果");

			}
		}
		pcap.close();
		hs = true;
	}

	public static void startCaptureAt() throws IOException, Exception {// 选择一个网卡开启抓包

		while (s) {
			// 开始抓包
			pcap.dispatch(1, myhandler, "Jnetcap");

			if ((System.currentTimeMillis() - start) >= 5000) {
				start = System.currentTimeMillis();
				// System.out.println("第一次获取值 ");
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
				// System.out.println("输出结果1");
				 Web.Applicationcalculationweight();
				s = false;
				// System.out.println("输出结果1");
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
