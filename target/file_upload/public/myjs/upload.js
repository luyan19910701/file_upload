$('#myfile').fileinput({//初始化上传文件框
    language: 'zh', //设置语言
    // uploadUrl: $.ctx + '/document/uploadFile', //上传的地址
    uploadUrl:'192.168.0.28:8081/document/upload.do',
    allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
    showUpload: true, //是否显示上传按钮
    showCaption: false,//是否显示标题
    browseClass: "btn btn-primary", //按钮样式
    //dropZoneEnabled: false,//是否显示拖拽区域
    //minImageWidth: 50, //图片的最小宽度
    //minImageHeight: 50,//图片的最小高度
    //maxImageWidth: 1000,//图片的最大宽度
    //maxImageHeight: 1000,//图片的最大高度
    //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
    //minFileCount: 0,
    maxFileCount: 10, //表示允许同时上传的最大文件个数
    enctype: 'multipart/form-data',
    validateInitialCount:true,
    previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
    msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
    slugCallback : function(filename) {
        return filename.replace('(', '_').replace(']', '_');
    }
});