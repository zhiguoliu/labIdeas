$(function() {
    $('#tab td').click(function() {
        if ($(this).attr('bgcolor') == '#0f0') {
            $(this).attr('bgcolor', '#fff');
        } else if ($(this).attr('bgcolor') != '#00f') {
            $(this).attr('bgcolor', '#0f0');
        }
        ;
    });
});

$(function() {
    $('.submitAppointment').click(function() {
        var name = $('#isSignIn').text();
        if (name == "") {
            alert("请先登录");
        } else {
            alert(name);
            var userId = $('#userId').val();
            if (userId == "" || userId == null) {
                alert("no userId")
            } else {
                alert("userId: " + userId);
            }
            var scheduleJS = new Array();
            var appointDate = $(this).parent().find("#appointmentDate").text();
            /* var appointDateStr = new Date(appointDate.replace(/-/g, "/"));
             alert(appointDateStr);*/
            var facilityId = $("#facilityId").text();
            var tab = $(this).parent().find("table").get(0);
            for (var i = 1; i < tab.rows.length; i++) {
                for (var j = 0; j < tab.rows[i].cells.length; j++) {
                    if ($(tab.rows[i].cells[j]).attr('bgcolor') == '#0f0') {
                        var index = (i - 1) * 24 + j;
                        scheduleJS[index] = index;
                    }
                }
            }
            /*
             var tds = $('#tab tr:eq(1)').children();
             alert(tds.length);
             for (var i = 0; i < tds.length; i++) {
             if ($('#tab tr:eq(1) td:eq(' + i + ')').attr('bgcolor') == '#0f0') {
             scheduleJS[i] = i;
             }
             }*/
            var scheduleDateJS = appointDate + "\n" + scheduleJS;
            alert(scheduleDateJS);
          
            // window.location = "../scheduleJS/addScheduleJS.action?scheduleJS=" + scheduleJS;
            $.ajax({
                url : "../scheduleJS/addScheduleJS.action?schedule.startTime=" + scheduleJS + "&schedule.facilityId=" + facilityId + "&schedule.appointDate=" + appointDate + "&schedule.userId=" + userId,
                type : "post",
                dataType : "json",
                success : function(data) {
                    alert("success");
                    alert(data);
                    $.each(data.scheduleList, function(i, facility) {
                        alert(i|+" : "+facility.facilityId);
                        $('#tableForScheduleList').append("<tr><td>"+facility.facilityId+"</td><td>"+  
                                  facility.appointDate.substring(0,10)+"</td><td>"+facility.startTime+  
                                  "</td><td>"+facility.endTime+"</td></tr>");

                    });
                    $('.alert-info').show();
                },
                error : function() {
                    alert("error");
                }
            });
        }
    });

});

function bgcolorToggle(thisObj) {
    if ($(thisObj).attr("bgcolor") == '#0f0') {
        $(thisObj).attr("bgcolor", "#fff");
    } else {
        $(thisObj).attr("bgcolor", "#0f0");
    }
}

var timeArr = new Array();
function appointmentTime() {
    var tds = $('#tr1').children();
    for (var i = 0; i < tds.length; i++) {
        if ($('#tr1 td:eq(' + i + ')').attr('bgcolor') == '#0f0') {
            timeArr[i] = i;
        }
    }

    alert(timeArr);
    $.ajax({
        url : "time/timeInterval.action?timeInterval=" + timeArr.toString(),
        type : "post",
        dataType : "json",
        success : function(data) {
            alert(data.username + " : " + data.password);
        },
        error : function() {
            alert("error");
        }
    });
}

$(function() {
    var tab = document.getElementById('tab****');
    for (var i = 1; i < tab.rows.length; i++) {
        for (var j = 0; j < tab.rows[i].cells.length; j++) {
            alert(tab.rows[i].cells[j].innerHTML);
        }
    }
});
