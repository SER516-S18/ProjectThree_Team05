package project3.model;

import utilities.Constants;

public class ConnectionIpAndPortValues {
	private static String ipAddress = Constants.DEFAULT_IPADDRESS;
	private static int portAddress = Constants.DEFAULT_PORTNUMBER;
	
	public static String getIpAddress() {
		return ipAddress;
	}
	public static void setIpAddress(String ipAddress) {
		ConnectionIpAndPortValues.ipAddress = ipAddress;
	}
	public static int getPortAddress() {
		return portAddress;
	}
	public static void setPortAddress(int portAddress) {
		ConnectionIpAndPortValues.portAddress = portAddress;
	}
}
