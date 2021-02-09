// DOM加载完再执行
$(function() {
    $('#selectCityId').change(function() {
        var cityId = $('#selectCityId').val(); // 获取Select选择的Value
        var url = '/report/cityId/' + cityId;
        window.location.href = url;
    })
})