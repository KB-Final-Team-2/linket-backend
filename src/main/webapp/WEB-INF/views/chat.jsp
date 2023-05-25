<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
        src="http://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
</head>

<body>
    <div id="messageArea"></div>
    <input type="text" id="message" />
    <input type="button" id="sendBtn" value="submit" />
</body>

<script type="text/javascript">
    $("#sendBtn").click(function () {
        sendMessage();
        $('#message').val('')
    });

    let sock = new SoCKJS("http://localhost:8080/linket/chat/");
    sock.onmessage = onMessage;
    sock.onclose = onClose;
    // 메세지 전송
    function sendMessage() {
        sock.send($("#message").val());
    }
    // 서버로부터 메세지를 받았을 때
    function onMessage(msg) {
        var data = msg.data;
        $("#messageArea").append(data + "<br/>");
    }
    // 서버와 연결을 끊었을 때
    function onClose(evt) {
        $("#messageArea").append("연결 끊김");
    }
</script>