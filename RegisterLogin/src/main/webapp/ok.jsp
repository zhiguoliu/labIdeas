<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
  <head>
  </head>
  
  <body>
   <h2>成功!</h2>
   <a target="_blank" href="/RegisterLogin/upload/<s:property value="someFileName" />">预览</a>
   <img alt="上传图片" src="/RegisterLogin/upload/<s:property value="someFileName" />">
  </body>
</html>
