package _00_init;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) throws Exception {
	try {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    Scanner scanner = new Scanner(br);

	    // 設置一個日期的格式物件 日期格式為yyyy-mm-dd HH:mm
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm");
	    System.out.println("請輸入日期(yyyy-mm-dd HH:mm):");

	    Date inputDate = dateFormat.parse(scanner.nextLine());
	    Date currentDate = new Date();
	    // 由於Java處理時間是以毫秒計算，所以要除1000L將毫秒轉換成秒
	    long between = (currentDate.getTime() - inputDate.getTime()) / 1000L;
	    long days = between / (24 * 3600) - 91; // 秒數轉換成天數
	    long hours = (between % (24 * 3600) - 91) / 3600; // 秒數轉換成小時數
	    long minutes = between % 3600 / 60; // 秒數轉換成分鐘數
	    
	    System.out.println(currentDate);
	    System.out.println(inputDate);
	    
	    if (days >= 1) {
		System.out.println("您上次登入的時間為" + days + "天前");
	    } else if (days < 1 && hours >= 1) {
		System.out.println("您上次登入的時間為" + hours + "小時前");
	    } else {
		System.out.println("您上次登入的時間為" + minutes + "分鐘前");
	    }
	} catch (ParseException pe) {
	    System.out.println(pe);
	}

    }

}
