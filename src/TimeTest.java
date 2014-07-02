import java.util.Calendar;
import java.util.TimeZone;


public class TimeTest {
	/**
	 * タイムゾーンを指定して時間を取得します。
	 * @param args
	 */
	public static void main( String[] args )
	{
	    // GMT(世界標準時刻)をセットする。
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTimeInMillis(1235540290269L);
		System.out.println(cal.getTimeInMillis() );
		System.out.println(
				cal.get(Calendar.YEAR) +"/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + ":"
			   +cal.get(Calendar.HOUR_OF_DAY)+ "/" + cal.get(Calendar.MINUTE)  +"/" + cal.get(Calendar.SECOND));

		cal.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		System.out.println(cal.getTimeInMillis());
		System.out.println(
				cal.get(Calendar.YEAR) +"/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + ":"
			   +cal.get(Calendar.HOUR_OF_DAY)+ "/" + cal.get(Calendar.MINUTE)  +"/" + cal.get(Calendar.SECOND));

			
		
		cal.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
		System.out.println(cal.getTimeInMillis());
		System.out.println(
				cal.get(Calendar.YEAR) +"/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + ":"
			   +cal.get(Calendar.HOUR_OF_DAY)+ "/" + cal.get(Calendar.MINUTE)  +"/" + cal.get(Calendar.SECOND));

		cal.setTimeZone(TimeZone.getTimeZone("JST"));
		System.out.println(cal.getTimeInMillis());
		System.out.println(
				cal.get(Calendar.YEAR) +"/" + cal.get(Calendar.MONTH) + "/" + cal.get(Calendar.DAY_OF_MONTH) + ":"
			   +cal.get(Calendar.HOUR_OF_DAY)+ "/" + cal.get(Calendar.MINUTE)  +"/" + cal.get(Calendar.SECOND));

	}
}
