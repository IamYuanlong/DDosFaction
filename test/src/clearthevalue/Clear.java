package clearthevalue;


import jnetcapforcapture.PacketMatch;


public class Clear {

	public static void clearValue() {

		PacketMatch.setCountacceptpack(0);

		PacketMatch.setCountsendpack(0);

		PacketMatch.setHttpresponsecount(0);

		PacketMatch.setHttprequestconut(0);

		PacketMatch.getMapfordosip().clear();

		PacketMatch.setIpsum(0);

		PacketMatch.setUdpsum(0);

		PacketMatch.setTcpsum(0);

		PacketMatch.setHttpsum(0);

	}

}
