<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8">
    <title>英语练习</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="css/jeui.css"  media="all">
    <link rel="stylesheet" href="css/admin.css"  media="all">
    <script type="text/javascript" src="js/modules/require.js"></script>
    <!--<script type="text/javascript" src="js/lib/jquery.min.js"></script>-->
    <!--<script type="text/javascript" src="js/modules/jeLayout.js"></script>-->
<!--     <script type="text/javascript" src="js/modules/jeTabPane.js"></script> -->
    <!--<script type="text/javascript" src="js/modules/jeAccordion.js"></script>-->
</head>
<body>
<div jepane="top" class="je-admin-top">
    <div class="je-admin-logo je-tc je-fl je-white" title="英语教学系统"></div>
    <div class="shrink je-fl je-white je-icon je-f28 je-mr10">&#xe626;</div>
    <div class="je-admin-navs je-fl">
        <ul class="je-ovh je-dib" id="myTabNav">
           <shiro:hasAnyRoles name="zhuming,admin"><li class="curr"><a href="javascript:;" data-tab="p6" data-text="词汇管理" data-url="addEnglishWords.jsp" addtab><em><img src="images/setico.png"></em><p>词汇管理</p></a></li></shiro:hasAnyRoles>
             <shiro:hasAnyRoles name="panglei,admin"><li><a href="javascript:;" data-tab="p7" data-text="单项填空管理" data-url="englishExercisesList.jsp" addtab><em><img src="images/actico.png"></em><p>单项填空管理</p></a></li></shiro:hasAnyRoles>
            <li><a href="javascript:;" data-tab="p8" data-text="完型填空管理" data-url="addProtype.jsp" addtab><em><img src="images/spico.png"></em><p>完型填空管理</p></a></li>
            <li><a href="javascript:;" data-tab="p9" data-text="阅读理解管理" data-url="addRead.jsp" addtab><em><img src="images/ddico.png"></em><p>阅读理解管理</p></a></li>
            <li><a href="javascript:;" data-tab="p10" data-text="写作管理" data-url="addArticle.jsp" addtab><em><img src="images/wxico.png"></em><p>写作管理</p></a></li>
        </ul>
    </div>
    <div class="je-admin-user je-fr je-pt2">
        <p><%=request.getParameter("username") %>,欢迎您使用平台</p>
        <p class="je-tr"><a href="<%=request.getContextPath() %>/logout" class="exit">退出账户</a></p>
    </div>
</div>
<div jepane="left" class="je-admin-left">
    <ul class="je-admin-menu">
        <li class="level">
            <h3><em class="ico"></em>英语系统<i></i></h3>
            <ul class="levelnext">
                <li><a href="javascript:;" data-tab="p1" data-text="单项填空" data-url="allEnglishExercises.jsp" addtab>单项填空</a></li>
                <li><a href="javascript:;" data-tab="p2" data-text="完型填空" data-url="protypeList.jsp?status=0" addtab>完型填空</a></li>
                <li><a href="javascript:;" data-tab="p3" data-text="阅读理解" data-url="protypeList.jsp?status=1" addtab>阅读理解</a></li>
                <li><a href="javascript:;" data-tab="p4" data-text="写作文章" data-url="readList.jsp" addtab>写作文章</a></li>
            </ul>
        </li>
        <!-- <li class="level">
            <h3><em class="ico"></em>导航菜单二<i></i></h3>
            <ul class="levelnext">
                <li><a href="javascript:;">导航选项</a></li>
                <li><a href="javascript:;">导航选项</a></li>
                <li><a href="javascript:;">导航选项</a></li>
                <li><a href="javascript:;">导航选项</a></li>
            </ul>
        </li> -->
    </ul>

</div>
<div jepane="center" class="je-admin-center" tabpane>

</div>
<div jepane="right" class="je-admin-right">right</div>
<div jepane="bottom" class="je-admin-bottom"><p>2017 © jayui.com MIT license</p></div>

<script type="text/javascript">
    require.config({
        baseUrl: './js/modules',
        paths: {
            "jquery": "jquery.min"
        }
    });
    require(["jquery","jeLayout","jeTabPane","jeAccordion"],function ($) {
        //Layout面板布局
        $("body").jeLayout();
        $("#myTabNav").find("li").on("click",function () {
            $(this).addClass('curr').siblings().removeClass('curr');
        });
        //折叠菜单
        $(".je-admin-menu").jeAccordion({ multiple:true});
        //addtabs
        $("[tabpane]").jeTabPane();
    });
</script>

</body>
</html>