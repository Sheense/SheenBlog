function searchByType(e){
	var type = e.id;
	$.ajax({
		url:"search/byType",
		type:"post",
		dataType:"json",
		data:{"type":type},
		success:function(data){
			if(data!=undefined && data!=null){
				var $blogdiv = $("#blogdiv");
				$blogdiv.empty();
				var blogs = data.blogs;
				for(var i=0;i<blogs.length;i++){
					$blogdiv.append("<h3><a href=\"searchAll?id="+blogs[i].blog.id+"\" target=\"_blank\">"+blogs[i].blog.title+"</a></h3>"
							+"<figure><a href=\"searchAll?id="+blogs[i].blog.id+"\" target=\"_blank\"><img src=\""+blogs[i].blog.pic+"\" alt=\""+blogs[i].blog.pic+"\"></a></figure>"
							+"<ul>"
							+"<p> "+blogs[i].blog.introduction+"</p>"
							+"<a title=\"阅读全文\" href=\"searchAll?id="+blogs[i].blog.id+"\" target=\"_blank\" class=\"readmore\">阅读全文&gt;&gt;</a>"
							+"</ul>"
							+"<p class=\"dateview\"><span>"+blogs[i].blog.time+"</span><span>作者："+blogs[i].blog.author+"</span><span>类型：[<a href=\"#\">"+blogs[i].blog.fromwhere+"</a>]</span><span>浏览量："+blogs[i].blog.scanNum+"</span></p>");
				}
			}	
		}
	})
}
function searchByKey(){
	var $keys = $("#keyboard");
	if($keys.val()=="请输入关键字"){
		$keys.val("");
	}
	$.ajax({
		url:"search/byKeys",
		type:"post",
		data:{"keys":$keys.val()},
		dataType:"json",
		success:function(data){
			if(data!=undefined && data!=null){
				var $blogdiv = $("#blogdiv");
				$blogdiv.empty();
				var blogs = data.blogs;
				for(var i=0;i<blogs.length;i++){
					$blogdiv.append("<h3><a href=\"/jstt/bj/2017-07-13/784.html?id="+blogs[i].blog.id+"\">"+blogs[i].blog.title+"</a></h3>"
							+"<figure><img src=\""+blogs[i].blog.pic+"\" alt=\""+blogs[i].blog.pic+"\"></figure>"
							+"<ul>"
							+"<p> "+blogs[i].blog.introduction+"</p>"
							+"<a title=\"阅读全文\" href=\"/jstt/bj/2017-07-13/784.html\" target=\"_blank\" class=\"readmore\">阅读全文&gt;&gt;</a>"
							+"</ul>"
							+"<p class=\"dateview\"><span>"+blogs[i].blog.time+"</span><span>作者："+blogs[i].blog.author+"</span><span>类型：[<a href=\"/jstt/bj/\">"+blogs[i].blog.fromwhere+"</a>]</span><span>浏览量："+blogs[i].blog.scanNum+"</span></p>");
				}
			}
			$keys.val("请输入关键字");
		}
	})
}