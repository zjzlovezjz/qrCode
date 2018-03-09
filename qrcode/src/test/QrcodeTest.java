package test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;



import com.swetake.util.Qrcode;

public class QrcodeTest {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		String url = "www.baidu.com?pid=520";
		String path = "d://qrcode.jpg";
		genQrcode(url, path);
		System.out.println("二维码生成完毕");
	}
	
	/**
	 * 生成二维码
	 * @param url 二维码的url文本内容
	 * @param path	要存放二维码的路径
	 * @throws IOException
	 */
	public static void genQrcode(String url,String path) throws IOException{
		Qrcode x=new Qrcode();  
        x.setQrcodeErrorCorrect('M');//纠错等级（四种等级）  
        x.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z,B代表其他字符  
        x.setQrcodeVersion(7);//版本  
          
        int width = 67 + 12 * (7 - 1);//设置二维码的大小公式：67 + 12 * （version - 1）  
        int height = 67 + 12 * (7 - 1);  
          
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
        Graphics2D gs = bufferedImage.createGraphics();  
          
        gs.setBackground(Color.WHITE);  
        gs.setColor(Color.BLACK);  
        gs.clearRect(0, 0, width, height);//清除画板的内容  
          
        int pixoff = 2;//添加一个偏移量  
          
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
