package com.kdx.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class IDNumber {
	/**
	 * 随机生成编号
	 * 编号格式：KDX+当前年月日+随机数
	 * @return
	 */
	public static String getIDNumber() {

		SimpleDateFormat simpleDateFormat;

		simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

		Date date = new Date();

		String str = "KDX" + simpleDateFormat.format(date);

		//System.out.println(str);

		Random random = new Random();

		int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数

		//System.out.println(rannum);

		return str + rannum;// 当前时间
	}
}
