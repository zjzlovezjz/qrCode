package com.imooc.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QRCode {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String url = "www.baidu.com?pid=520";
		String path = "d://qrcode.jpg";
		genQrcode(url, path);
		System.out.println("��ά���������");
	}
	
	/**
	 * ���ɶ�ά��
	 * @param url ��ά���url�ı�����
	 * @param path	Ҫ��Ŷ�ά���·��
	 * @throws IOException
	 */
	public static void genQrcode(String url,String path) throws IOException{
		Qrcode x=new Qrcode();  
        x.setQrcodeErrorCorrect('M');//����ȼ������ֵȼ���  
        x.setQrcodeEncodeMode('B');//N�������֣�A����a-Z,B���������ַ�  
        x.setQrcodeVersion(7);//�汾  
          
        int width = 67 + 12 * (7 - 1);//���ö�ά��Ĵ�С��ʽ��67 + 12 * ��version - 1��  
        int height = 67 + 12 * (7 - 1);  
          
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        Graphics2D gs = bufferedImage.createGraphics();  
          
        gs.setBackground(Color.WHITE);  
        gs.setColor(Color.BLACK);  
        gs.clearRect(0, 0, width, height);//������������  
          
        int pixoff = 2;//���һ��ƫ����  
          
        byte[] d = url.getBytes("utf-8");  
        if (d.length>0 && d.length <120){  
            boolean[][] s = x.calQrcode(d);  
  
            for (int i=0;i<s.length;i++){  
            for (int j=0;j<s.length;j++){  
                if (s[j][i]) {  
                gs.fillRect(j*3 + pixoff,i*3 + pixoff,3,3);  
                }  
            }  
            }  
        }  
        gs.dispose();  
        bufferedImage.flush();  
          
        ImageIO.write(bufferedImage, "png", new File(path));  
	}
}
