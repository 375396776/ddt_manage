package com.ddt.manage.util;

import java.util.UUID;

public class GetUUID {

	public static String UUID(){
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
}
