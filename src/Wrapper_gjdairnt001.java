import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.qunar.qfwrapper.bean.booking.BookingInfo;
import com.qunar.qfwrapper.bean.booking.BookingResult;
import com.qunar.qfwrapper.bean.search.FlightDetail;
import com.qunar.qfwrapper.bean.search.FlightSearchParam;
import com.qunar.qfwrapper.bean.search.FlightSegement;
import com.qunar.qfwrapper.bean.search.OneWayFlightInfo;
import com.qunar.qfwrapper.bean.search.ProcessResultInfo;
import com.qunar.qfwrapper.constants.Constants;
import com.qunar.qfwrapper.interfaces.QunarCrawler;
import com.qunar.qfwrapper.util.QFGetMethod;
import com.qunar.qfwrapper.util.QFHttpClient;
import com.qunar.qfwrapper.util.QFPostMethod;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.lang.StringUtils;

public class Wrapper_gjdairnt001 implements QunarCrawler {

	private static final NameValuePair DATA_SEARCH_RETURN_DATE = new NameValuePair("data[search][returnDate]", "");
	private static final NameValuePair DATA_SEARCH_DATE_ADVANCE = new NameValuePair("data[search][dateAdvance]", "2");
	private static final NameValuePair SEARCH_INIT_DATES_0_MONTH = new NameValuePair("search[initDates][0][month]", "06");
	private static final NameValuePair SEARCH_INIT_DATES_0_YEAR = new NameValuePair("search[initDates][0][year]", "2014");
	private static final NameValuePair SEARCH_INIT_DATES_1_MONTH = new NameValuePair("search[initDates][1][month]", "");
	private static final NameValuePair SEARCH_INIT_DATES_1_YEAR = new NameValuePair("search[initDates][1][year]", "");
	private static final NameValuePair DATA_SEARCH_TIPO_BUSQUEDA = new NameValuePair("data[search][tipoBusqueda]", "normal");	
	private static final NameValuePair DATA_SEARCH_ONE_WAY = new NameValuePair("data[search][oneWay]", "1");
	private static final NameValuePair DATA_SEARCH_ONLY_POINTS = new NameValuePair("data[search][onlyPoints]", "0");
	private static final NameValuePair DATA_SEARCH_ONLY_DIRECT_FLIGHTS = new NameValuePair("data[search][onlyDirectFlights]", "0");
	private static final NameValuePair DATA_SEARCH_RETURN_DATE_VISUAL = new NameValuePair("data[search][returnDateVisual]", "");
	private static final NameValuePair DATA_SEARCH_CALENDAR = new NameValuePair("data[search][calendar]", "0");
	private static final NameValuePair DATA_SEARCH_PASSENGERS_ADTDC = new NameValuePair("data[search][passengers][ADTDC]", "1");
	private static final NameValuePair DATA_SEARCH_PASSENGERS_ADT = new NameValuePair("data[search][passengers][ADT]", "0");
	private static final NameValuePair DATA_SEARCH_PASSENGERS_CHDDC = new NameValuePair("data[search][passengers][CHDDC]", "0");
	private static final NameValuePair DATA_SEARCH_PASSENGERS_CHD = new NameValuePair("data[search][passengers][CHD]", "0");
	private static final NameValuePair DATA_SEARCH_PASSENGERS_INFDC = new NameValuePair("data[search][passengers][INFDC]", "0");
	private static final NameValuePair DATA_SEARCH_PASSENGERS_INF = new NameValuePair("data[search][passengers][INF]", "0");
	private static final NameValuePair DATA_SEARCH_CONDITIONS = new NameValuePair("data[search][conditions]", "0");
	private static final NameValuePair DATA_SEARCH_FLAG_LESS_29_FARE = new NameValuePair("data[search][flagLess29Fare]", "0");
	private static final NameValuePair DATA_SEARCH_FLAG_HIGHER_60_FARE = new NameValuePair("data[search][flagHigher60Fare]", "0");
	private static final NameValuePair DATA_SEARCH_FLAG_LARGE_FAMILY = new NameValuePair("data[search][flagLargeFamily]", "0");
	private static final NameValuePair DATA_SEARCH_FLAG_UNIVERSITY_FARE = new NameValuePair("data[search][flagUniversityFare]", "0");
	
	
	@Override
	public BookingResult getBookingInfo(FlightSearchParam arg0) {
		String bookingUrlPre = "https://www.bintercanarias.com/booking/searchDo";
		BookingResult bookingResult = new BookingResult();
		
		BookingInfo bookingInfo = new BookingInfo();
		bookingInfo.setAction(bookingUrlPre);
		bookingInfo.setMethod("post");
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		map.put("data[search][departureDate]", arg0.getDepDate().replaceAll("-", "/"));
		map.put("data[search][returnDate]",  "");
		map.put("data[search][dateAdvance]", "2");
		map.put("search[initDates][0][month]", "06");
		map.put("search[initDates][0][year]", "2014");
		map.put("search[initDates][1][month]", "06");
		map.put("search[initDates][1][year]", "2014");
		map.put("data[search][tipoBusqueda]", "normal");
		map.put("data[search][from]", arg0.getDep());
		map.put("data[search][to]", arg0.getArr());
		map.put("data[search][oneWay]", "1");
		map.put("data[search][onlyPoints]", "0");
		map.put("data[search][onlyDirectFlights]", "0");
		map.put("data[search][returnDateVisual]", "");
		map.put("data[search][calendar]", "0");
		map.put("data[search][passengers][ADTDC]", "1");
		map.put("data[search][passengers][ADT]", "0");
		map.put("data[search][passengers][CHDDC]", "0");
		map.put("data[search][passengers][CHD]", "0");
		map.put("data[search][passengers][INFDC]", "0");
		map.put("data[search][passengers][INF]", "0");
		map.put("data[search][conditions]", "0");
		map.put("data[search][flagLess29Fare]", "0");
		map.put("data[search][flagHigher60Fare]", "0");
		map.put("data[search][flagLargeFamily]", "0");
		map.put("data[search][flagUniversityFare]", "0");
		
		
		bookingInfo.setContentType("UTF-8");
		bookingInfo.setInputs(map);		
		bookingResult.setData(bookingInfo);
		bookingResult.setRet(true);
		return bookingResult;
	}

	@Override
	public String getHtml(FlightSearchParam arg0) {
		QFPostMethod postMethod = null;
		QFGetMethod getMethod = null;	
		try {
			QFHttpClient httpClient = new QFHttpClient(arg0, false);
			httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
			
			postMethod = new QFPostMethod("https://www.bintercanarias.com/booking/searchDo");
			
			NameValuePair[] values = {
					new NameValuePair("data[search][departureDate]", arg0.getDepDate().replaceAll("-", "/")),
					DATA_SEARCH_RETURN_DATE,
					DATA_SEARCH_DATE_ADVANCE,
					SEARCH_INIT_DATES_0_MONTH,
					SEARCH_INIT_DATES_0_YEAR,
					SEARCH_INIT_DATES_1_MONTH,
					SEARCH_INIT_DATES_1_YEAR,
					DATA_SEARCH_TIPO_BUSQUEDA,
					new NameValuePair("data[search][from]", arg0.getDep()),
					//DATA_SEARCH_FROM_TEXT,
					new NameValuePair("data[search][to]", arg0.getArr()),
					//DATA_SEARCH_TO_TEXT,
					DATA_SEARCH_ONE_WAY,
					DATA_SEARCH_ONLY_POINTS,
					DATA_SEARCH_ONLY_DIRECT_FLIGHTS,
					//DATA_SEARCH_DEPARTURE_DATE_VISUAL,
					DATA_SEARCH_RETURN_DATE_VISUAL,
					DATA_SEARCH_CALENDAR,
					DATA_SEARCH_PASSENGERS_ADTDC,
					DATA_SEARCH_PASSENGERS_ADT,
					DATA_SEARCH_PASSENGERS_CHDDC,
					DATA_SEARCH_PASSENGERS_CHD,
					DATA_SEARCH_PASSENGERS_INFDC,
					DATA_SEARCH_PASSENGERS_INF,
					DATA_SEARCH_CONDITIONS,
					DATA_SEARCH_FLAG_LESS_29_FARE,
					DATA_SEARCH_FLAG_HIGHER_60_FARE,
					DATA_SEARCH_FLAG_LARGE_FAMILY,
					DATA_SEARCH_FLAG_UNIVERSITY_FARE,
			};
			httpClient.getState().clearCookies();
			postMethod.setRequestBody(values);
			httpClient.executeMethod(postMethod);
			if(postMethod.getStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY || postMethod.getStatusCode() == HttpStatus.SC_MOVED_PERMANENTLY){
				Header location = postMethod.getResponseHeader("Location");
				String url = "";
				if(location !=null){
					url = location.getValue();
					if(!url.startsWith("http")){
						url = postMethod.getURI().getScheme() + "://" + postMethod.getURI().getHost() + (postMethod.getURI().getPort()==-1?"":(":" + postMethod.getURI().getPort())) + url;
					}
				}else{
					return "Exception";
				}
				String cookie = StringUtils.join(httpClient.getState().getCookies(),"; ");
				getMethod = new QFGetMethod(url);
				httpClient.getState().clearCookies();
				getMethod.addRequestHeader("Cookie",cookie);
				httpClient.executeMethod(getMethod);
				String html = getMethod.getResponseBodyAsString();
				String redirectUrl =  getMethod.getURI().getScheme() + "://" + getMethod.getURI().getHost() + (getMethod.getURI().getPort()==-1?"":(":" + getMethod.getURI().getPort())) + StringUtils.substringBetween(html, "window.location.replace(\"", "\")");
				
				getMethod = new QFGetMethod(redirectUrl);
				httpClient.getState().clearCookies();
				getMethod.addRequestHeader("Cookie",cookie);
				httpClient.executeMethod(getMethod);
				return getMethod.getResponseBodyAsString();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (postMethod != null) {
				postMethod.releaseConnection();
			}
		}
		return "Exception";
	}

	@Override
	public ProcessResultInfo process(String arg0, FlightSearchParam arg1) {
		String html = arg0;
		
		ProcessResultInfo result = new ProcessResultInfo();
		if ("Exception".equals(html)) {	
			result.setRet(false);
			result.setStatus(Constants.CONNECTION_FAIL);
			return result;			
		}		
		
		if (html.contains("There are no places available on this date. ")) {
			result.setRet(false);
			result.setStatus(Constants.INVALID_DATE);
			return result;			
		}
		
		List<OneWayFlightInfo> flightList = new ArrayList<OneWayFlightInfo>();
		int p = html.indexOf("availability-subrow-info");
		if (p == -1) {
			result.setRet(false);
			result.setStatus(Constants.NO_RESULT);
			return result;
		}
		do {
			OneWayFlightInfo baseFlight = new OneWayFlightInfo();
			List<FlightSegement> segs = new ArrayList<FlightSegement>();
			FlightDetail flightDetail = new FlightDetail();
			
			List<String> flightNoList = new ArrayList<String>();
			
			String htmlSource = StringUtils.substringBetween(html.substring(p), "<div class=\"availability-cell-right  offer \">", ">");
			String flightInfoString = StringUtils.substringBetween(htmlSource, "value=\"", "\"");
			String[] flightInfoList = StringUtils.substringBetween(flightInfoString, "|", "|").split(";");
			for (int i = 0; i < flightInfoList.length; i++) {
				String[] flightInfo = flightInfoList[i].split(",");
				
				flightNoList.add(flightInfo[0]);
				
				FlightSegement seg = new FlightSegement();
				seg.setFlightno(flightInfo[0]);
				seg.setDepDate(arg1.getDepDate());
				seg.setDepairport(flightInfo[1]);
				seg.setDeptime(flightInfo[3]);
				
				seg.setArrairport(flightInfo[2]);
				seg.setArrtime(flightInfo[4]);
				seg.setArrDate(this.convertDateString(flightInfo[6]));
				segs.add(seg);
			}
			String priceString = StringUtils.substringBetween(htmlSource, "data-fareimport=\"", "\"");
			String taxString = StringUtils.substringBetween(htmlSource, "data-taxes=\"", "\"");
			flightDetail.setFlightno(flightNoList);
			flightDetail.setMonetaryunit("EUR");
			flightDetail.setPrice(Double.valueOf(priceString));
			flightDetail.setTax(Double.valueOf(taxString) + 12);
			flightDetail.setDepcity(arg1.getDep());
			flightDetail.setArrcity(arg1.getArr());
			flightDetail.setWrapperid(arg1.getWrapperid());
			
			baseFlight.setDetail(flightDetail);
			baseFlight.setInfo(segs);
			flightList.add(baseFlight);
			
			p = html.indexOf("availability-subrow-info", p + 1);
		} while(p != -1);
		result.setRet(true);
		result.setStatus(Constants.SUCCESS);
		result.setData(flightList);
		return result;
	}
	
	// 将YYYYmmdd格式的日期转换为YYYY-mm-dd
	private String convertDateString(String date) {
		return date.substring(0, 4) + "-" + date.substring(4, 6) + "-" + date.substring(6, 8);
	}
}
