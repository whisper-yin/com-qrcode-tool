package com.qrcode;

import java.io.File;

import com.qrcode.util.EncodeUtil;

public class Test {
	public static void main(String[] args) {
		File file = new File("./target/qrcode.png");
		EncodeUtil encodeUtil = new EncodeUtil();
		encodeUtil.encode("http://baidu.com", 200, 200, file);
	}
}
