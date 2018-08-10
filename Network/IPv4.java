package Network;

import Util.SubnetUtil;
import Util.SubnetUtil.SubnetInfo;

public class IPv4 {
	private SubnetInfo m_ipInfo;
	
	public IPv4(String ipAddress, String subnet) {
		m_ipInfo = new SubnetUtil(ipAddress, subnet).getInfo();
	}
	
	public IPv4(String ipAddressAndSubnet) {
		if(!ipAddressAndSubnet.contains("/"))
			m_ipInfo = new SubnetUtil(ipAddressAndSubnet+"/31").getInfo(); 
		else
			m_ipInfo = new SubnetUtil(ipAddressAndSubnet).getInfo();
	}

	public boolean isInRange(String address) {
		return m_ipInfo.isInRange(address);
	}

	public String getBroadcastAddress() {
		return m_ipInfo.getBroadcastAddress();
	}

	public String getNetworkAddress() {
		return m_ipInfo.getNetworkAddress();
	}

	public String getNetmask() {
		return m_ipInfo.getNetmask();
	}

	public String getAddress() {
		return m_ipInfo.getAddress();
	}

	public String getLowAddress() {
		return m_ipInfo.getLowAddress();
	}

	public String getHighAddress() {
		return m_ipInfo.getHighAddress();
	}

	public int getAddressCount() {
		return m_ipInfo.getAddressCount();
	}

	public String[] getAllAddresses() {
		return m_ipInfo.getAllAddresses();
	}
	
	@Override
	public boolean equals(Object obj) {
		return m_ipInfo.asInteger(((IPv4)obj).getAddress()) == m_ipInfo.asInteger(m_ipInfo.getAddress());
	}
	
	@Override
	public String toString() {
		return m_ipInfo.getAddress();
	}
	
	public String toString(boolean withSubnet) {
		return m_ipInfo.getAddress() + " " + m_ipInfo.getNetmask();
	}
}
