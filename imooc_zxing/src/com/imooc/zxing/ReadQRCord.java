package com.imooc.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

//利用zxing读取二维码图片
public class ReadQRCord {

	public static void main(String[] args) throws Exception {
		
		MultiFormatReader formatReader = new MultiFormatReader();
		
		File file = new File("D:/img.png");
		
		BufferedImage image = ImageIO.read(file);
		
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
		
		//定义二维码的参数
		HashMap hints = new HashMap();
		//如果使用了中文，就设置为utf-8
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
				
		Result result=formatReader.decode(binaryBitmap, hints);
		
		System.out.println("解析结果:"+result.toString());
		System.out.println("二维码格式类型:"+result.getBarcodeFormat());
		System.out.println("二维码文本内容:"+result.getText());

	}

}
