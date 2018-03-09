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

//生成二维码
public class CreateQRCode {

	public static void main(String[] args) {
		int width = 300;  //宽度
		int height = 300; //高度
		String format = "png"; //图片的格式
		String content = "幸得识卿桃花面，自此阡陌多暖春。";//内容
		
		//定义二维码的参数
		HashMap hints = new HashMap();
		//如果使用了中文，就设置为utf-8
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");   
		//设置二维码的纠错等级，等级越高，存储的容量越小
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M); 
		//设置空白地带边距，一般不要太大
		hints.put(EncodeHintType.MARGIN, 2);
		
		
		//生成二维码
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			Path file = new File("D:/img.png").toPath();
			//这里我把生成的二维码放在了path路径下，实际你可以使用下面的方法做成流输入到页面下载或者显示
			//MatrixToImageWriter.writeToStream(matrix, format, stream);把生成的二维码变成流
			MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
