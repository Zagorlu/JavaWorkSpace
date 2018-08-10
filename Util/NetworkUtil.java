package Util;

import java.util.regex.Pattern;

import Network.IPv4;

public final class NetworkUtil {
	private static final Pattern IP_PATTERN = Pattern.compile(
	        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
	
	private NetworkUtil() {}
	
	public static boolean isValidIp(String ip) {
		return IP_PATTERN.matcher(ip.trim()).matches();
	}
	
	public static IPv4 generateIp(String ipAddress, String subnet) {
		return new IPv4(ipAddress,subnet);
	}
	
	public static IPv4 generateIp(String ipAddressAndSubnet) {
		return new IPv4(ipAddressAndSubnet);
	}
}
