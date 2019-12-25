function ajaxSubmit(url) {
    $("#myform").Validform({
		tiptype:function(msg,o,cssctl){
			if(msg!="通过信息验证！"){
				if(msg=="正在提交数据…"){
					layer.load();
				}
				else {
					if(isNaN(msg)){
						layer.msg(msg);
					}
				}
			}
		},
		postonce:true,
		ajaxPost:true,
		callback:function(data){
			layer.closeAll();
			if (data.status=="y") {
				if (data.ico==9){
					location.href=url;
				}
				else {
					if(isNaN(data.ico)){
						var myarr=data.ico.split("|");
						if(myarr[0]>2){
							if(myarr[0]==3){location.href="../../pay/wxpay/api.asp?c=order&orderid="+myarr[1]+"&total="+myarr[2]+"";};
							if(myarr[0]==4){location.href="../../pay/alipay/index.asp?c=order&orderid="+myarr[1]+"&total="+myarr[2]+"";};
						}
						else {
							layer.open({icon: 1 , content: data.info , yes: function(index, layero){location.href=url;}});
						}
					}
					else {
				        layer.open({icon: data.ico , content: data.info , yes: function(index, layero){location.href=url;}});
					}
				}
			}
			else {
				layer.open({icon: data.ico , content: data.info});
			}
		}
	});
}
//刷新验证码
function reloadcode() { 
	$("#safecode").attr("src","../../inc/code.asp?" + Math.random());
}
//获取优惠券
function getCoupon (id,jf) {
	var dh_str="";
	if(jf>0){ dh_str="这将花费您"+jf+"积分!" }
	layer.msg('确定要获取吗?'+dh_str, {
		time: 0
		,btn: ['确定', '取消']
		,yes: function(index){
			layer.close(index);
			$.ajax({
				type:"GET",
				url:"mould/coupon/?a=get&id="+id,
				cache: false,
				dataType:"html",
				beforeSend:function(XMLHttpRequest){
					layer.load();
				},
				error: function(request) {
					layer.closeAll();
					layer.msg("连接失败，请重试!");
				},
				success:function(date){
					layer.closeAll();
					layer.msg(date);
				}
			});
		}
	});
}
//兑换商品
function dhJf(p0,p1,p2){
	layer.msg('确定要兑换吗?', {
		time: 0
		,btn: ['确定', '取消']
		,yes: function(index){
			layer.close(index);
			$.ajax({
				type:"GET",
				url:"mould/jifen/?a=dh&type="+p0+"&id="+p1+"&score="+p2,
				cache: false,
				dataType:"html",
				beforeSend:function(XMLHttpRequest){
					layer.load();
				},
				error: function(request) {
					layer.closeAll();
					layer.msg("连接失败，请重试!");
				},
				success:function(date){
					layer.closeAll();
					layer.msg(date);
					if(date=="兑换成功!"){location.reload();}
				}
			});
		}
	});
}
//规格id,当前规格序号,原价,本站价,库存-以下在商品展示页
function checkGG(p0,p1,p2,p3,p4) {
	$(".show_gg2").attr("class","show_gg1");
	$("#my_gg"+p1).attr("class","show_gg2");
	$("#m_gg").val(p0);
	$("#m_yprice").html(p2.toFixed(2));
	$("#m_dzprice").html(p3.toFixed(2));
	$("#m_stock").html(p4);
}
//购买数量
function delNum() {
	var c_num=parseInt($("#m_num").html());
	if(c_num>1){
		$("#m_num").html(c_num-1)
	}
}
function addNum() {
	var c_num=parseInt($("#m_num").html());
	if(c_num<parseInt($("#m_stock").html())){
		$("#m_num").html(c_num+1)
	}
	else {
		layer.msg("库存只有这么多了!");
	}
}
//商品分销
function getShare(sid,id){
	$.ajax({
		type:"GET",
		url:"mould/fenxiao/?a=get&cid="+sid+"&id="+id,
		cache: false,
		dataType:"html",
		beforeSend:function(XMLHttpRequest){
			layer.load();
		},
		error: function(request) {
			layer.closeAll();
			layer.msg("连接失败，请重试!");
		},
		success:function(date){
			layer.closeAll();
			if(date==0) {
				layer.msg("生成失败!");
			}
			else if(date==-1) {
				layer.msg("请先登录!");
			}
			else if(date==-2) {
				layer.msg("需要先下单哦!");
			}
			else {
				location.href="plug/fenxiao/?c=share&id="+id+"&fid="+date+"&mid="+date;
			}
		}
	});
}
//添加到购物车:多规格，商品id
function addCart(p0,p1) {
	var c_num=parseInt($("#m_num").html());
	if(parseInt($("#m_stock").html())<c_num){
		layer.msg("库存不足!");
	}
	else {
		if(p0==1){
			var c_gg=$("#m_gg").val();
			if (c_gg!=0){
				$.ajax({
					type:"GET",
					url:"../../mould/user/?c=cart&a=add&pid="+p1+"&specid="+c_gg+"&total="+c_num,
					cache: false,
					dataType:"html",
					beforeSend:function(XMLHttpRequest){
						layer.load();
					},
					error: function(request) {
						layer.closeAll();
						layer.msg("连接失败，请重试!");
					},
					success:function(date){
						layer.closeAll();
						if(date==1) {
							layer.msg("已添加到购物车!");
							upCartNum();
						}
					}
				});
			}
			else {
				layer.msg("请选择规格!");
			}
		}
		else {
			$.ajax({
				type:"GET",
				url:"../../mould/user/?c=cart&a=add&pid="+p1+"&specid=0&total="+c_num,
				cache: false,
				dataType:"html",
				beforeSend:function(XMLHttpRequest){
					layer.load();
				},
				error: function(request) {
					layer.closeAll();
					layer.msg("连接失败，请重试!");
				},
				success:function(date){
					layer.closeAll();
					if(date==1) {
						layer.msg("已添加到购物车!");
						upCartNum();
					}
				}
			});
		}
	}
}
function upCartNum(){
	$.ajax({
		type:"GET",
		url:"../../mould/user/?c=cart&a=total",
		cache: false,
		dataType:"html",
		success:function(date){
			if(date>0) {
				$("#b_cart").html(date);
				$("#b_cart").show();
			}
		}
	});
}
//立即购买
function buyNow(p0,p1){
	var m_gg=parseInt($("#m_gg").val());
	var m_num=parseInt($("#m_num").html());
	if(parseInt($("#m_stock").html())<m_num){
		layer.msg("库存不足!");
	}
	else {
		if(p0==1){
			if(m_gg==0){
				layer.msg("请选择规格!");
			}
			else {
				location.href="plug/user/?c=cartbuy&id="+p1+"&num="+m_num+"&gg="+m_gg;
			}
		}
		else {
			location.href="plug/user/?c=cartbuy&id="+p1+"&num="+m_num;
		}
	}
}
//收藏
function getCollect(uid,pid){
	if(uid<=0){
	    layer.msg("请先登录!");
	}
	else {
		$.ajax({
			type:"GET",
			url:"../../mould/user/?c=collect&pid="+pid,
			cache: false,
			dataType:"html",
			beforeSend:function(XMLHttpRequest){
				layer.load();
			},
			error: function(request) {
				layer.closeAll();
				layer.msg("连接失败，请重试!");
			},
			success:function(date){
				layer.closeAll();
				if(date==1) {
					document.getElementById("m_sc").style.color="#fe9331";
				}
				else if(date==2) {
					document.getElementById("m_sc").style.color="";
				}
			}
		});
	}
}
//删除收藏：我的收藏页
function delCollect(id){
	layer.msg('确定要删除吗?', {
		time: 0
		,btn: ['确定', '取消']
		,yes: function(index){
			layer.close(index);
			$.ajax({
				type:"GET",
				url:"../../mould/user/?c=collect&a=del&id="+id,
				cache: false,
				dataType:"html",
				beforeSend:function(XMLHttpRequest){
					layer.load();
				},
				error: function(request) {
					layer.closeAll();
					layer.msg("连接失败，请重试!");
				},
				success:function(date){
					layer.closeAll();
					if(date==1) {
						location.reload();
					}
				}
			});
		}
	});
}

//操作订单-我的订单页cancel:取消，sh：收货，th：退货
function updateOrder(id,type){
	var m_msg;
	if(type=="cancel"){
		m_msg="确定要取消吗?";
	}
	if(type=="sh"){
		m_msg="确定要收货吗?";
	}
	if(type=="th"){
		m_msg="确定要退货吗?";
	}
	layer.msg(m_msg, {
		time: 0
		,btn: ['确定', '取消']
		,yes: function(index){
			layer.close(index);
			$.ajax({
				type:"GET",
				url:"../../mould/user/?c=order&a="+type+"&id="+id,
				cache: false,
				dataType:"html",
				beforeSend:function(XMLHttpRequest){
					layer.load();
				},
				error: function(request) {
					layer.closeAll();
					layer.msg("连接失败，请重试!");
				},
				success:function(date){
					layer.closeAll();
					if(date==1) {
						location.reload();
					}
				}
			});
		}
	});
}
//推广二维码-分销中心
function getEwm(){
	$.ajax({
		type:"GET",
		url:"../../mould/fenxiao/?a=getewm",
		cache: false,
		dataType:"html",
		beforeSend:function(XMLHttpRequest){
			layer.load();
		},
		error: function(request) {
			layer.closeAll();
			layer.msg("连接失败，请重试！");
		},
		success:function(date){
			layer.closeAll();
			if(date==0) {
				layer.msg("生成失败!");
			}
			else if(date==-1) {
				layer.msg("请先登录!");
			}
			else {
				location.href="?c=share&fid="+date+"&mid="+date;
			}
		}
	});
}

//添加评论
function addPl(id){
	if($("#m_pl"+id).val().length==0) {
		layer.msg('评论为空!');
		return false;
	}
	else {
		$.ajax({
			type: "POST",
			url: "../../mould/user/?c=addpl",
			data:$('#myform'+id).serialize(),
			async: false,
			beforeSend:function(XMLHttpRequest){
				layer.load();
			},
			error: function(request) {
				layer.closeAll();
				layer.msg("连接失败，请重试！");
			},
			success: function(date) {
				layer.closeAll();
				if(date==1){
					layer.msg('评论成功!')
					location.reload();
				}
				else {
					layer.msg('评论失败!');
				}
			}
		});
		return false;
	}
}
//cartbuy
//切换支付方式
function ckpay(p0) {
	for(var i=1;i<=6;i++){
		if($("#pay"+i)){$("#pay"+i).attr("class","buy_cell1");}
	}
	$("#pay"+p0).attr("class","buy_cell2");
	$("#pay_type").val(p0);
}
//切换快递
function cksend(p0,p1) {
	for(var i=1;i<=10;i++){
		if($("#send"+i)){$("#send"+i).attr("class","buy_cell1");}
	}
	$("#send"+p0).attr("class","buy_cell2");
	$("#send_type").val(p0);
	p1=parseFloat(p1);
	if(p1>=0){
		var m_price=parseFloat($("#m_price").val())
		var m_yhprice=parseFloat($("#m_yhprice").val())
		$("#m_sendprice").val(p1);
		$("#m_total").val(m_price+p1-m_yhprice);
		$("#span_sendprice").html(p1.toFixed(2));
		$("#span_total").html((m_price+p1-m_yhprice).toFixed(2));
	}
}
//选择优惠券
function selectCoupon(id){
	$.ajax({
		type:"GET",
		url:"../../mould/user/?c=usecoupon&id="+id,
		cache: false,
		dataType:"html",
		beforeSend:function(XMLHttpRequest){
			layer.load();
		},
		error: function(request) {
			layer.closeAll();
			layer.msg("连接失败，请重试！");
		},
		success:function(date){
			layer.closeAll();
			date=parseFloat(date);
			$("#m_yhprice").val(date);
			$("#span_yhprice").html(date.toFixed(2));
			var m_price=parseFloat($("#m_price").val());
			var m_sendprice=parseFloat($("#m_sendprice").val());
			$("#m_total").val(m_price+m_sendprice-date);
		    $("#span_total").html((m_price+m_sendprice-date).toFixed(2));
		}
	});
}