package Util;

public final class ThreadUtil {
	private ThreadUtil() {}
	
	public static void sleep(long milliSecond) {
		try {
			Thread.sleep(milliSecond);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
