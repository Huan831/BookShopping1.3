$(function () {
    var url = '/BookShopping1_3_war_exploded/QueryByAmountServlet';
    var f=function (){
        $.getJSON(url, function (data) {
            if (data.success) {
                var bookList = data.BookList;
                var swiperHtml = '';
                //遍历图书列表，javarscript
                bookList.map(function (item,index) {
                    swiperHtml += '<li class="row recom-1" style="margin-top:5px;margin-bottom:5px;display:block;height:242px;background-color:#f8f8f8">\n' +
                        '<div class="col-md-3"  style="line-height:242px;">\n' +
                        '\t\t\t<a href="/BookShopping1_3_war_exploded'+item.bookImage+'" target="_blank" alt="点击看大图" class="img-thumbnail"><img src="/BookShopping1_3_war_exploded' + item.bookImage + '"class="imgBook"/></a>\n' +
                        '</div>\n' +
                        '<div class="col-md-9" style="">\t\n' +
                        '           <div class="row">\t\t\n' +
                        '\t\t\t<ul>\n' +
                        '\t\t\t   <li><span style="font-weight:bold;font-size:14px;line-height:24px;">'+item.bookName+'</span></li>\n' +
                        '\t\t\t   <li><span class="search_now_price">'+item.discount+'</span><span class="search_pre_price">'+item.price+'</span></li>\n' +
                        '   \n' +
                        '\t\t\t   <li><span style="color:blue">'+item.bookAuthor+'</span><span style="color:blue">/'+item.publishingName+'</span>\n' +
                        '\t\t\t   <li>ISBN：<span style="color:blue">'+item.bookIsbn+'</span></li>\n' +
                        '\t\t\t   <li>所属分类：<span style="color:blue">'+item.bookTypeName+'</span></li>\n' +
                        '\t\t\t   <li>\t\t<p style="height:60px;overflow:hidden">'+item.bookIntroduction+'</li>\n' +
                        '\t\t\t</ul>\n' +
                        '\t\t\t</div>\n' +
                        '\t\t\t<div class="row" style="">\n' +
                        '\t\t\t\t<button type="button" class="btn btn-primary">收藏</button>\n' +
                        '\t\t\t\t<button type="button" class="btn btn-success">加入购物车</button>\n' +
                        '\t\t\t\t<button type="button" class="btn btn-danger">一键购买</button>\n' +
                        '\t\t\t </div>\n' +
                        '</div>\n' +
                        '</li>';
                });
                //将图书列表赋值给前端HTML控件
                $('#bookRecom').html(swiperHtml);
            }
        })
    };
    f()
});