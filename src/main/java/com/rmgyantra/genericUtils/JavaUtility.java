package com.rmgyantra.genericUtils;

import java.util.Random;
/**
 * this is a java utility class
 * @author Bhavana
 *
 */
public class JavaUtility {
/**
 * this method will generate random numbers
 * @return
 */
	public int random() {
		Random random=new Random();
		int ran_num=random.nextInt(5000);
		return ran_num;
	}
}
