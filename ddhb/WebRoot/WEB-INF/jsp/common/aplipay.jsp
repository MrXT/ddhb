<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<title>www.elve.cn</title>

<meta content="www.elve.cn" name="keywords" />

<meta content="www.elve.cn" name="description" />

</head>


<body>

 

    <form id="form1" action= "/ddhb/aplipay/deposit" method="post" target="_blank">  

                <table>      <tr>  

                        <td>充值测试</td>  

                        <td class="balance" id="userBalance"></td>  

                    </tr>  

                    <tr>  

                        <td><i class="zfb"></i></td>  

                        <td style="padding-bottom: 0px;">亲爱的<span  

                            class="suppliment_user" id="suppliment_user"></span>,您可以使用支付宝充值积善分，请填写以下信息  

                        </td>  

                    </tr>  

                    <tr>  

                        <td></td>  

                        <td>

                                金额<input type="text" name="amount" id="amount">

                        </td>  

                    </tr>  

   

                    <tr>  

                        <td></td>  

                        <td><button type="submit" id="doSubmit" class="blank_btn">确认</button></td>  

                    </tr>  

                </table>  

    </form>  

</body>

</html>