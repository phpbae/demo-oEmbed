$(document).ready(function () {
    console.log('index.js run..');


    $('#oembed-submit').on('click', function () {
        var inputURL = $('#header').find('input').val();

        //validation
        if (isUrlCheker(inputURL)) {
            oembedAjax.getJSON(inputURL, function (data) {
                var rowElement = $('#content-row').html();
                var resultElement = '';

                $.each(data, function (key, value) {
                   var rowTarget = rowElement;
                   var imgElement = '';
                   if(key.indexOf('thumbnail_url') != -1){
                       imgElement = '<img style="display: block" src="'+ value  +'">';
                   }

                   rowTarget = rowTarget
                       .split('{{contents-name}}').join(key)
                       .split('{{contents-value}}').join(value)
                       .split('{{thumbnail_url}}').join(imgElement);
                   resultElement += rowTarget;
                });
                $('#contents').find('tbody').empty();
                $('#contents').find('tbody').append(resultElement);
            });
        }
    });
});


var oembedAjax = (function () {
    return {
        getJSON: function (url, callback) {
            var param = {'url': url};
            var contentsVendor = '';
            console.log(url);

            if (url.indexOf('youtube') != -1) {
                contentsVendor = 'youtube';
            } else if (url.indexOf('vimeo') != -1) {
                contentsVendor = 'vimeo';
            }

            if (contentsVendor === '' || contentsVendor == undefined) {
                alert('요청에 실패하였습니다.');
                return false;
            }

            $.ajax({
                url: '/api/oembed/' + contentsVendor,
                data: param,
                dataType : 'json',
                type : 'get',
                cache : false
            }).done(function (data) {
                if(data.code != undefined){
                    alert(data.code + ' : ' + data.message);
                    return false;
                }
                console.log(data);
                callback(data);


            }).fail(function (data) {
                console.log(data);
            });
        },
        getXML: function (url, callback) {
            //추후 개발 예정..
        }
    }
})();


function isUrlCheker(url) {
    var regexp = /^(?:(?:https?|ftp):\/\/)?(?:(?!(?:10|127)(?:\.\d{1,3}){3})(?!(?:169\.254|192\.168)(?:\.\d{1,3}){2})(?!172\.(?:1[6-9]|2\d|3[0-1])(?:\.\d{1,3}){2})(?:[1-9]\d?|1\d\d|2[01]\d|22[0-3])(?:\.(?:1?\d{1,2}|2[0-4]\d|25[0-5])){2}(?:\.(?:[1-9]\d?|1\d\d|2[0-4]\d|25[0-4]))|(?:(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)(?:\.(?:[a-z\u00a1-\uffff0-9]-*)*[a-z\u00a1-\uffff0-9]+)*(?:\.(?:[a-z\u00a1-\uffff]{2,})))(?::\d{2,5})?(?:\/\S*)?$/;

    if (regexp.test(url)) {
        return true;
    }

    return false;
}