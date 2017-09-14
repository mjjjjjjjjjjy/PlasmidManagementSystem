package com.mo.plasmid.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
	public static void main(String[] args) {
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间：" + sdf.format(d));
        Date d2 = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("当前时间：" + sdf2.format(d2));
        Date d3 = new Date();
        SimpleDateFormat sdf3 = new SimpleDateFormat("HH:mm:ss");
        System.out.println("当前时间：" + sdf3.format(d3));
	     
	}
}
