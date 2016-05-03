<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Item</title>
   
 <script  type ="text/javascript">

   function update()
	{
	document.productForm.action="update.do";
	document.productForm.submit();
	
	}

   function list()
	{
	document.productForm.action="list.do";
	document.productForm.submit();
	
	}

</script>
    </head>
   
<input type="submit" value="Add New Item" action="save.do">           
        
    </body>
</html>