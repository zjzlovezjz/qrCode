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

//����zxing��ȡ��ά��ͼƬ
public class ReadQRCord {

	public static void main(String[] args) throws Exception {
		
		MultiFormatReader formatReader = new MultiFormatReader();
		
		File file = new File("D:/img.png");
		
		BufferedImage image = ImageIO.read(file);
		
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
		
		//�����ά��Ĳ���
		HashMap hints = new HashMap();
		//���ʹ�������ģ�������Ϊutf-8
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
				
		Result result=formatReader.decode(binaryBitmap, hints);
		
		System.out.println("�������:"+result.toString());
		System.out.println("��ά���ʽ����:"+result.getBarcodeFormat());
		System.out.println("��ά���ı�����:"+result.getText());

	}

}
