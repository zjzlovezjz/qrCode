package com.imooc.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;

public class ReadQRCode {

	public static void main(String[] args) throws Exception {
		
		File file = new File("D:/qrcode.png");
		
		BufferedImage bufferedImage = ImageIO.read(file);
		
		QRCodeDecoder decoder = new QRCodeDecoder();
		
		String result = new String(decoder.decode(new MyQRCodeImage(bufferedImage)),"utf-8");
		
		System.out.println(result);
	}
}
