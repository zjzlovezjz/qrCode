package com.imooc.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;


public class CreateQRCode {

	public static void main(String[] args) throws Exception {
		Qrcode x = new Qrcode();
		x.setQrcodeErrorCorrect('M');   //����ȼ�
		x.setQrcodeEncodeMode('B');     //N�������֣�A����a-Z,B���������ַ�  
		x.setQrcodeVersion(7);          //�汾��
		
		String qrData = "www.baidu.com";     //��ά������
		int width = 67 + 12 * (7 - 1);//���ö�ά��Ĵ�С��ʽ��67 + 12 * ��version - 1��  
        int height = 67 + 12 * (7 - 1);  
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
		
		Graphics2D gs = bufferedImage.createGraphics();  //java�Ļ�ͼ����
		
		gs.setBackground(Color.WHITE);       //���û���ı���ɫ
        gs.setColor(Color.BLACK);            //����ʹ����ɫ
        gs.clearRect(0, 0, width, height);   //������������ 
        
        int pixoff = 2;//���һ��ƫ���������ӿ��ܻᵼ�½�������
        
		byte[] d = qrData.getBytes("utf-8");
		if(d.length>0 && d.length<120){
			boolean[][] s = x.calQrcode(d);
			
			for(int i=0;i<s.length;i++){
				for(int j=0;j<s.length;j++){
					if(s[j][i]){
						gs.fillRect(j*3 + pixoff, i*3 + pixoff, 3, 3);
					}
				}
			}
		}
		gs.dispose();     //������ͼ��
		bufferedImage.flush();  //��ͼҲҪ����
		
		ImageIO.write(bufferedImage, "png", new File("D:/qrcode.png"));  

	}

}
