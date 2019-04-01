package com.qrcode.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class EncodeUtil {
	private static final String CHARSET = "utf-8";

	public File encode(String content, int height, int width, File QRCodeFile) {
		// 存放二维码配置
		HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 指定纠错等级
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 指定内容字符编码
		hints.put(EncodeHintType.CHARACTER_SET, CHARSET);

		BitMatrix bitMatrix;
		try {
			OutputStream outputStream = new FileOutputStream(QRCodeFile);
			bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return QRCodeFile;
	}
}
