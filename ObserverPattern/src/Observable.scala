trait Observable {

  def asString: String

  def event: String

  var observers: List[Observer]

  def addObserver(_observers: List[Observer]): Unit = {
    observers = observers ++ _observers
  }

  def notifyObservers(): Unit = {
    observers.foreach(_.update(event))
  }

}

object Observable {

  class NewsObservable extends Observable {
    override def asString: String = "NEWS_OBSERVABLE"
    override def event: String = "New Article Published"
    override var observers: List[Observer] = Nil
  }

  class JobObservable extends Observable {
    def asString: String = "JOB_OBSERVABLE"
    def event: String = "New Job Posted"
    override var observers: List[Observer] = Nil
  }

  class WeatherObservable extends Observable {
    def asString: String = "WEATHER_OBSERVABLE"
    def event: String = "Uncertain Weather Alert"
    override var observers: List[Observer] = Nil
  }

}
