package controllers

import com.google.inject.Inject
import play.api.libs.json._
import play.api.mvc._
import javax.inject.Singleton

@Singleton
class HomeController @Inject() extends Controller {

  def index = Action {
    Ok("hello")
  }

  // 버튼 팝업
  def keyboard = Action {
    val jsObject = Json.obj("type" -> "buttons", "buttons" -> Seq("help"))
    Ok(jsObject)
  }

  // 메시지 수신 및 자동응답
  def message = Action { request =>
    val jsValue = request.body.asJson.get
    val content = (jsValue \ "content").as[String]
    val text = content match {
      case "help" => "도움말 작성"
      case _ => content + ", 무슨 뜻이죠?"
    }

    val jsObject = Json.obj("message" -> Json.obj("text" -> text))
    Ok(jsObject)
  }

  // 친구 추가되면 호출됨
  def addFriend = Action { request =>
    val jsValue = request.body.asJson.get
    val userKey = (jsValue \ "user_key").as[String]
    Ok("addFriend")
  }

  // 친구 차단되면 호출됨
  def removeFriend(user_key: String) = Action {
    Ok("removeFriend")
  }

  // 친구가 채팅방 나가면 호출됨
  def leaveChatRoom(user_key: String) = Action {
    Ok("leaveChatRoom")
  }

}
