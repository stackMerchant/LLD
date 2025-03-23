class Observer(asString: String) {

  def update(event: String): Unit = {
    println("Event: " + event + " acknowledged by " + asString)
  }

}