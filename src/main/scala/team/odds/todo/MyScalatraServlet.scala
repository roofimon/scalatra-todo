package team.odds.todo

import org.scalatra._

class MyScalatraServlet extends ScalatraServlet {

  get("/") {
    views.html.hello()
  }

}
