layui.use('element', function(){
    var element = layui.element;
    //…
});
layui.use('layer', function(){
    var layer = layui.layer;
});
function showLoginLayer() {
    layer.open({
        type:2,
        skin:'layui-layer-movl',
        content:['/layer/login','no'],
        area:['400px','250px'],
        title:false,
        closeBtn:1
    })
}

function showRegisterLayer() {
    layer.open({
        type: 2,
        skin: 'layui-layer-movl',
        content:['/layer/register','no'],
        area:['600px','600px'],
        title:false,
        closeBtn:1,
    })
}