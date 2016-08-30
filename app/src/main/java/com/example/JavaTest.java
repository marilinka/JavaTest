package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaTest {

	public static void main(final String[] args) {
		for (int i = 0; i < 50; i++) {
			String name = "User #" + i;
			String barcode = String.format("%032d", i);

			String user = "D:/sense_id/id" + barcode + "p20160829";
			new File(user).mkdirs();

			MM.write(user + "/name", name);
			MM.copy("d:/user_test/user_photo.png", user + "/photo");
			for (int index = 0; index <= 14; ++index) {
				String finger = barcode + "pf" + index;
				MM.copy("d:/user_test/user_finger", user + "/" + finger);
				MM.copy("d:/user_test/user_finger.data", user + "/" + finger + ".data");
			}
		}
	}

}
