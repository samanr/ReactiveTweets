$ ->
  ws = new WebSocket $("body").data("ws-url")
  ws.onmessage = (event) ->
    message = JSON.parse event.data
    $('#tweet').append "<a target='_blank' href='http://localhost:9000/userProfile/"+message.screenName+"'>("+message.screenName+")</a>  : " + message.tweetData + "<br/><br />"