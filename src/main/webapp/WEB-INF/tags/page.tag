<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ attribute type="org.ct.bean.Page" name="page" required="true" %>
<%@ attribute type="java.lang.String" name="jsMethodName" required="true" %>

<script type="text/javascript">
	function transCurrentPage(currentPage) {
		var rule = /^[0-9]*[1-9][0-9]*$/;
		if(!rule.test(currentPage)) {
			currentPage = 0;
		}
		window.eval("${jsMethodName}("+currentPage+")");
	}
</script>

<div class="page fix">
	<a href="javascript:transCurrentPage(0)" class="first">首页</a>
	<a href="javascript:transCurrentPage('${page.pageCurrent-1}')" class="pre">上一页</a>
	当前第<span>${page.pageCurrent+1}/${page.pageTotal}</span>页
	<a href="javascript:transCurrentPage('${page.pageCurrent+1}')" class="next">下一页</a>
	<a href="javascript:transCurrentPage('${page.pageTotal}')" class="last">末页</a>
	跳至 &nbsp;<input value="1" class="allInput w28" type="text" id="goTo"/>&nbsp;页 &nbsp;
	<a href="javascript:transCurrentPage($('#goTo').val())" class="go">GO</a>
</div>