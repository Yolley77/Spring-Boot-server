/*function sendTextAJAX() {
    let text = $("#request").val();
    $.ajax( {
        url: "/form.php",
        type: "post",
        data: text,
        success: function(data, textStatus) {

        }
    });
}

function sendJson() {
    let xhr = new XMLHttpRequest();

    let json = JSON.stringify({
        strng: " "
    });

    xhr.open("POST", "/submit", true)
    xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
    xhr.onreadystatechange = function(e) {
        if(this.readyState == 4 && this.readyState == 200) { 

        }
    }
    xhr.send(json);
}*/



function sendText () {
    var text = document.getElementById("request").value;
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open ('POST', '/calculate', false);
    xmlhttp.send(text);
    alert("Запрос отправлен");
    xmlhttp.onreadystatechange = function(e) {
        alert("readyState " + this.readyState + " status" + this.status);
        if (this.readyState == 4 && this.status == 200) {
            alert("readyState " + this.readyState + " status" + this.status);
            var result = document.getElementById("result");
            result.value = xmlhttp.responseText;
        } else {
            alert("readyState " + this.readyState + " status" + this.status);
        }
    }
}