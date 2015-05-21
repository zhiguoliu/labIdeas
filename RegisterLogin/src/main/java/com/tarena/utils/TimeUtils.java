package com.tarena.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	public static String calculateTheRealTime(Date date, int i) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		String dateString = sdf.format(date);
		System.out.println(dateString);
		if (i % 2 == 0) {
			if (i / 2 < 10) {
				return dateString + "0" + i / 2 + ":00:00";
			} else {
				return dateString + i / 2 + ":00:00";
			}
		} else {
			if (i / 2 < 10) {
				return dateString + " 0" + i / 2 + ":30:00";
			} else {
				return dateString + i / 2 + ":30:00";
			}
		}
	}

}
