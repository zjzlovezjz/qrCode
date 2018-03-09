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
		x.setQrcodeErrorCorrect('M');   //纠错等级
		x.setQrcodeEncodeMode('B');     //N代表数字，A代表a-Z,B代表其他字符  
		x.setQrcodeVersion(7);          //版本号
		
		String qrData = "www.baidu.com";     //二维码内容
		int width = 67 + 12 * (7 - 1);//设置二维码的大小公式：67 + 12 * （version - 1）  
        int height = 67 + 12 * (7 - 1);  
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
		
		Graphics2D gs = bufferedImage.createGraphics();  //java的画图工具
		
		gs.setBackground(Color.WHITE);       //设置画板的背景色
        gs.setColor(Color.BLACK);            //设置使用颜色
        gs.clearRect(0, 0, width, height);   //清除画板的内容 
        
        int pixoff = 2;//添加一个偏移量，不加可能会导致解析出错。
        
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
		gs.dispose();     //结束画图。
		bufferedImage.flush();  //制图也要结束
		
		ImageIO.write(bufferedImage, "png", new File("D:/qrcode.png"));  

	}

}
