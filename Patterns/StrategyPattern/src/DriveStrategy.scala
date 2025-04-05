sealed trait DriveStrategy {
  def asString: String
}

object DriveStrategy {

  object GoFast extends DriveStrategy {
    def asString: String = "GO_FAST"
  }

  object GoSlow extends DriveStrategy {
    def asString: String = "GO_SLOW"
  }

}

