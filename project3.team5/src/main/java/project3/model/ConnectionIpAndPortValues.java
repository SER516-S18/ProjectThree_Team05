/*
 * @SER516-Project3_Team05
 */
package project3.model;

import utilities.Constants;

/*
 * Class to define the web socket connection IP Address and Port Address
 */
public class ConnectionIpAndPortValues {
	private static String ipAddress = Constants.DEFAULT_IPADDRESS;
	private static int portAddress = Constants.DEFAULT_PORTNUMBER;

	/*
	 * To get the IP Address of the Connection
	 * 
	 * @return ipAddress
	 */
	public static String getIpAddress() {
		return ipAddress;
	}

	/*
	 * To set the IP address that we received in the getIPAddress method
	 */
	public static void setIpAddress(String ipAddress) {
		ConnectionIpAndPortValues.ipAddress = ipAddress;
	}

	/*
	 * To get the port Address of the Connection
	 * 
	 * @return portAddress
	 */
	public static int getPortAddress() {
		return portAddress;
	}

	/*
	 * To set the port Address that is received in the getPortAddress methods
	 */
	public static void setPortAddress(int portAddress) {
		ConnectionIpAndPortValues.portAddress = portAddress;
	}
}
