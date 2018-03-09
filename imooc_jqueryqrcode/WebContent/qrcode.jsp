<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>生成二维码</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.qrcode.min.js"></script>
</head>
<body>
生成的二维码如下：<br>

<div id="qrcode"></div>

<!-- 如果不使用下面的js函数对字符串处理会造成中文乱码的问题 -->
<script type="text/javascript">
function utf16to8(str) {  
    var out, i, len, c;    
    out = "";    
    len = str.length;    
    for(i = 0; i < len; i++) {    
    c = str.charCodeAt(i);    
    if ((c >= 0x0001) && (c <= 0x007F)) {    
        out += str.charAt(i);    
    } else if (c > 0x07FF) {    
        out += String.fromCharCode(0xE0 | ((c >> 12) & 0x0F));    
        out += String.fromCharCode(0x80 | ((c >>  6) & 0x3F));    
        out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));    
    } else {    
        out += String.fromCharCode(0xC0 | ((c >>  6) & 0x1F));    
        out += String.fromCharCode(0x80 | ((c >>  0) & 0x3F));    
    }    
    }    
    return out;    
}  


jQuery('#qrcode').qrcode( utf16to8("http://www.baidu.com"));
</script>

</body>
</html>