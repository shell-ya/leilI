//抽奖代码
$(function() {
    $(".btn").click(function(){
        var award = 1;//模拟接口返回中奖号码
        var angleArr = [0, 45, 90, 135, 180, 225, 270, 315];
        isture = true;
        $('.turntable').rotate({
            angle: 0, //旋转的角度数
            duration: 2000, //旋转时间
            animateTo: angleArr[award] + 1440,
            callback: function(){
                alert("恭喜您，已获得奖品" + award);
            }
        });
    })
});