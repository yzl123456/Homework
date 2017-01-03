package bigWork.utils;



import java.util.Random;
/*
 * 姝や负宸ュ叿绫伙紝寰楀埌16浣嶇函鏁板瓧鐨勫瓧绗︿覆
 * 鐗瑰埆瑕佹敞鎰忓繀椤绘槸绾暟瀛楃殑锛岀函鑻辨枃瀛楃鐨勭粷瀵逛笉琛岋紝涓嶇劧濂藉儚鍜岃胺姝屾彁渚涚殑閭ｄ釜绠楁硶涓嶅尮閰�
 */
public class GetRandomString {
	private static String string = "123456789";   
	 
	public static String getRandomString(int length){
	    StringBuffer sb = new StringBuffer();
	    Random random=new Random();
	    
	    int len = string.length();
	    for (int i = 0; i < length; i++) {
	        sb.append(string.charAt(random.nextInt(8)));
	    }
	    return sb.toString();
	}
}
