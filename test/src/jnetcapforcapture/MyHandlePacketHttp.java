package jnetcapforcapture;

import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.JPacketHandler;

public class MyHandlePacketHttp<Object>  implements JPacketHandler<Object> {

	@Override
	public void nextPacket(JPacket packet, Object arg1) {
//		pack.add(packet);
		// TODO Auto-generated method stub
		PacketMatch packetMatch = PacketMatch.getInstance();
//		packetMatch.handlePacket(packet);
		packetMatch.handlePacketHttp(packet);
		
		
	}


}
