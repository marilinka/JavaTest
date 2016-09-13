package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Rostyslav Lesovyi
 */
public class MM {

	@SuppressWarnings("ResultOfMethodCallIgnored")
	public static void mkdirs(String path) {
		new File(path).mkdirs();
	}

	public static boolean copy(String src, String dst) {
		return copy(new File(src), new File(dst));
	}

	public static boolean copy(File src, File dst) {
		try (InputStream in = new FileInputStream(src)) {
			try (OutputStream out = new FileOutputStream(dst)) {
				byte[] buf = new byte[4096];
				int len;
				while ((len = in.read(buf)) > 0) {
					out.write(buf, 0, len);
				}
			} catch (Exception ignore) {
				return false;
			}
		} catch (Exception ignore) {
			return false;
		}
		return true;
	}

	public static String read(String file) {
		return read(new File(file));
	}

	public static String read(File file) {
		StringBuilder sb = new StringBuilder();
		try (InputStream in = new FileInputStream(file)) {
			byte[] buf = new byte[4096];
			int len;
			while ((len = in.read(buf)) > 0) {
				sb.append(new String(buf, 0, len));
			}
		} catch (Exception ignore) {
			return null;
		}
		return sb.toString();
	}

	public static boolean write(String file, String data) {
		return write(new File(file), data);
	}

	public static boolean write(File file, String data) {
		try (OutputStream out = new FileOutputStream(file)) {
			out.write(data.getBytes());
		} catch (Exception ignore) {
			return false;
		}
		return false;
	}

}
