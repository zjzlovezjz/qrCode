package com.imooc.zxing;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

//���ɶ�ά��
public class CreateQRCode {

	public static void main(String[] args) {
		int width = 300;  //���
		int height = 300; //�߶�
		String format = "png"; //ͼƬ�ĸ�ʽ
		String content = "�ҵ�ʶ���һ��棬�Դ���İ��ů����";//����
		
		//�����ά��Ĳ���
		HashMap hints = new HashMap();
		//���ʹ�������ģ�������Ϊutf-8
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   
		//���ö�ά��ľ���ȼ����ȼ�Խ�ߣ��洢������ԽС
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); 
		//���ÿհ׵ش��߾࣬һ�㲻Ҫ̫��
		hints.put(EncodeHintType.MARGIN, 2);
		
		
		//���ɶ�ά��
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new File("D:/img.png").toPath();
			//�����Ұ����ɵĶ�ά�������path·���£�ʵ�������ʹ������ķ������������뵽ҳ�����ػ�����ʾ
			//MatrixToImageWriter.writeToStream(matrix, format, stream);�����ɵĶ�ά������
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
