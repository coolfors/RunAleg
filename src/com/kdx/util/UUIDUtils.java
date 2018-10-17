package com.kdx.util;

import java.util.UUID;
 
/**
 * Helper for creating random and Type 1 (time-based) UUIDs.
 *
 * @author Jon Brisbin
 */
public  class UUIDUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}
	
 
}