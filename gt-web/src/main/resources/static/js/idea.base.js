//设置默认地址
function default_addr (id) {
	$.ajax({
		type:"GET",
		url:"../../mould/user/?c=addr&a=default&id="+id,
		cache: false,
		dataType:"html",
		error: function(request) {
			layer.open({icon: 5,content: '连接失败，请重试！'});
		},
		success:function(date){
			if(date==1) {
				location.reload();
			}
		}
	});
}
//Cart
function delCNum(p0) {
	var c_num=parseInt($("#m_num"+p0).html());
	if(c_num>1){
		var n_num=c_num-1
		$.ajax({
			type:"GET",
			url:"../../mould/user/?c=cart&a=upnum&id="+p0+"&num="+n_num,
			cache: false,
			dataType:"html",
			error: function(request) {
				layer.open({icon: 5,content: '连接失败，请重试！'});
			},
			success:function(date){
				if(date==1) {
					upCartList();
				}
			}
		});
	}
}
function addCNum(p0,p1) {
	var c_num=parseInt($("#m_num"+p0).html());
	if(c_num<parseInt(p1)){
		var n_num=c_num+1
		$.ajax({
			type:"GET",
			url:"../../mould/user/?c=cart&a=upnum&id="+p0+"&num="+n_num,
			cache: false,
			dataType:"html",
			error: function(request) {
				layer.open({icon: 5,content: '连接失败，请重试！'});
			},
			success:function(date){
				if(date==1) {
					upCartList();
				}
			}
		});
	}
	else {
		layer.open({icon: 0,content: '库存只有这么多了！'});
	}
}

function delCart(p0){
	layer.confirm('确定要删除吗？', function(){
	    $.ajax({
			type:"GET",
			url:"../../mould/user/?c=cart&a=del&id="+p0,
			cache: false,
			dataType:"html",
			error: function(request) {
				layer.open({icon: 5,content: '连接失败，请重试！'});
			},
			success:function(date){
				if(date==1) {
					layer.msg('删除成功！');
					upCartList();
				}
			}
		});
	});
}
//cartList
function upCartList(){
	$.ajax({
		type:"GET",
		url:"../../mould/user/?c=cart",
		cache: false,
		dataType:"html",
		error: function(request) {
			layer.open({icon: 5,content: '连接失败，请重试！'});
		},
		success:function(date){
			$("#cart_list").html(date.split("{fg}")[0]);
			$("#m_total").html(date.split("{fg}")[1]);
			if(parseFloat(date.split("{fg}")[1])>0){
				$("#cart_foot").show();
			}
			else {
				$("#cart_foot").hide();
			}
		}
	});
}

upCartNum();