package team.odds.todo

import org.scalatra._
import scala.collection.mutable

case class Todo(id:Int, title: String)

class MyScalatraServlet extends ScalatraServlet {
  var todos: mutable.Map[Int, Todo] = mutable.Map()

  get("/") { 
    contentType = "text/html" 
    s"<h1>Welcome to Todo List API</h1>" 
  } 
  // List all todos 
  get("/todos") { 
    contentType = "application/json" 
    todos.values.toList 
  } 
  // Add a new todo 
  post("/todos") { 
    contentType = "application/json" 
    val id: Int = (if (todos.isEmpty) 1 else todos.keys.max + 1) 
    val description = params("description") 
    val todo = Todo(id, description) 
    todos += (id -> todo) 
    todo 
  } 
  // Delete a todo 
  delete("/todos/:id") { 
    contentType = "application/json" 
    val id = params("id").toInt 
    todos -= id 
    s"Todo with id $id deleted."
  }
}
