package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class JavaTest {

	public static void main(final String[] args) {
		File template = new File("d:/user_test");
		File photoTemplate = new File(template, "user_photo.png");
		File fingerTemplate = new File(template, "user_finger");
		File fingerDataTemplate = new File(template, "user_finger.data");

		File root = new File("D:/sense_id");
		root.mkdirs();

		for (int i = 0; i < 50; i++) {
			// id m854330ww21qxcvg4f00mic24vh52zxb p 20160829
			String name = "User #" + i;
			String barcode = String.format("%032d", i);

			File user = new File(root, "id"+ barcode + "p" + "20160829");
			user.mkdirs();

			try (OutputStream os = new FileOutputStream(new File(user, "name"))) {
				os.write(name.getBytes());
			} catch (Exception ignore) { }

			copy(photoTemplate, new File(user, "photo"));
			for (int index = 0; index <= 14; ++index) {
				String finger = "id" + barcode + "pf" + index;
				copy(fingerTemplate, new File(user, finger));
				copy(fingerDataTemplate, new File(user, finger + ".data"));
			}
		}
	}







	public static void copy(File src, File dst) {
		try (InputStream in = new FileInputStream(src)) {
			try (OutputStream out = new FileOutputStream(dst)) {

				byte[] buf = new byte[1024];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}

			} catch (Exception ex) {}
		} catch (Exception ex) {}
	}

}
