$(function () {
    //定义访问后台，获取图书列表以及图书类别列表的URL
    var url = '/frontend/home';
   // alert("hhh");
    //访问后台，获取销售量最高的4本图书条列表
    $.getJSON(url, function (data) {
        if (data.success) {
            //获取后台传递过来的图书列表
            var recomList =data.recomList;
            alert(recomList);
            var swiperHtml = '';
            //遍历图书列表，javarscript
            recomList.map(recomList,function (item, index) {
                swiperHtml += ' <div class="col-sm-4 col-md-3">\n' +
                    '                    <div class="thumbnail">\n' +
                    '                        <a href="#"><img src="' + item.bookImage + '" class="img-responsive img-thumbnail" alt="..."\n' +
                    '                                         style="height: 150px;width:150px;"/></a>\n' +
                    '                        <div class="caption">\n' +
                    '                            <h5 class="book_title"><a href="#">' + item.bookName + '</a></h5>\n' +
                    '                            <p class="book_intro">\n' + item.bookIntroduction +
                    '                                 </p>\n' +
                '                            <p><span class="search_now_price">¥' + item.discount + '</span><span class="search_pre_price">¥' + item.price + '</span>\n' +
                '                            </p>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </div>';
            });
            //将图书列表赋值给前端HTML控件
            $('#recom_product').html(swiperHtml);


            var newItemList=data.newItemList;
            swiperHtml = '';
            newItemList.map(function (item,index){


            });

        }
    });

});
