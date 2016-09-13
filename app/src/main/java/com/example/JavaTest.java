package com.example;

public class JavaTest {

	public static void main(final String[] args) {
		for (int i = 0; i < 50; i++) {
			String name = "User #" + i;
			String barcode = String.format("%032d", i);

			String user = "D:/sense_id/id" + barcode + "p20160829";
			MM.mkdirs(user);

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
